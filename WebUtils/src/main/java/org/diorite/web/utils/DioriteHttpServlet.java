package org.diorite.web.utils;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;

import java.io.Serializable;

public interface DioriteHttpServlet extends Servlet, ServletConfig, Serializable
{
    int getServicesNum();

    int incrementServicesNum();

    int decrementServicesNum();

    boolean isShuttingDown();
}
