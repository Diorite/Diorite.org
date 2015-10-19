package org.diorite.web.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("ClassHasNoToStringMethod")
public abstract class HttpServletGWT extends RemoteServiceServlet implements DioriteHttpServlet
{
    private static final long serialVersionUID = 0;

    public static final int DESTROY_INTERVAL = 100;

    private final transient AtomicInteger servicesNum  = new AtomicInteger();
    private final transient AtomicBoolean shuttingDown = new AtomicBoolean();

    @Override
    public int getServicesNum()
    {
        return this.servicesNum.get();
    }

    @Override
    public int incrementServicesNum()
    {
        return this.servicesNum.incrementAndGet();
    }

    @Override
    public int decrementServicesNum()
    {
        return this.servicesNum.decrementAndGet();
    }

    @Override
    public boolean isShuttingDown()
    {
        return this.shuttingDown.get();
    }

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException
    {
        HttpServletRequestWrapper w = new HttpServletRequestWrapper(req)
        {
            @Override
            public String getContentType()
            {
                return "text/x-gwt-rpc";
            }

            @Override
            public String getCharacterEncoding()
            {
                return "UTF-8";
            }
        };
        if (this.isShuttingDown())
        {
            return;
        }
        this.incrementServicesNum();
        try
        {
            super.service(w, resp);
        } finally
        {
            this.decrementServicesNum();
        }
    }

    @Override
    public void destroy()
    {
        this.shuttingDown.set(true);
        while (this.getServicesNum() > 0)
        {
            try
            {
                Thread.sleep(DESTROY_INTERVAL);
            } catch (final InterruptedException ignored)
            {
            }
        }
        this.releaseResources();
    }

    protected void releaseResources()
    {
    }
}
