package org.diorite.web;

import org.diorite.web.utils.HttpServlet;

public class LoginServlet extends HttpServlet
{
    private static final long serialVersionUID = 0;

//    @Override
//    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException
//    {
//        final PrintWriter writer = response.getWriter();
//
//        writer.println("<br>request.getAuthType(): " + request.getAuthType());
//        writer.println("<br>request.getHeader(\"User-Agent\"): " + request.getHeader("User-Agent"));
//        writer.println("<br>request.getRequestedSessionId(): " + request.getRequestedSessionId());
//        writer.println("<br>request.getLocalAddr(): " + request.getLocalAddr());
//        writer.println("<br>request.getLocalName(): " + request.getLocalName());
//        writer.println("<br>request.getRemoteAddr(): " + request.getRemoteAddr());
//        writer.println("<br>request.request.getHeader(\"X-FORWARDED-FOR\"): " + request.getHeader("X-FORWARDED-FOR"));
//        writer.println("<br>request.getRemoteHost(): " + request.getRemoteHost());
//        writer.println("<br>request.getRemoteUser(): " + request.getRemoteUser());
//        writer.println("<br>request.getServerPort(): " + request.getServerPort());
//        writer.println("<br>request.isRequestedSessionIdValid(): " + request.isRequestedSessionIdValid());
//        writer.println("<br>request.isRequestedSessionIdFromCookie(): " + request.isRequestedSessionIdFromCookie());
//        writer.println("<br>request.isRequestedSessionIdFromURL(): " + request.isRequestedSessionIdFromURL());
//        writer.println("<br>request.isSecure(): " + request.isSecure());
//        writer.println("<br>Params: ");
//        request.getParameterMap().forEach((n, v) -> writer.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;" + n + ": " + Arrays.toString(v)));
//        writer.println("<br>request.getParameter(\"login\"): " + request.getParameter("login"));
//        writer.println("<br>request.getParameter(\"pass\"): " + request.getParameter("pass"));
//        writer.println("<br><br>Session: ");
//        final HttpSession session = request.getSession();
//        writer.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;session.getId(): " + session.getId());
//        writer.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;session.getCreationTime(): " + session.getCreationTime());
//        writer.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;session.getLastAccessedTime(): " + session.getLastAccessedTime());
//        writer.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;session.getMaxInactiveInterval(): " + session.getMaxInactiveInterval());
//        writer.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;session.isNew(): " + session.isNew());
//        {
//            final Enumeration<String> names = session.getAttributeNames();
//            while (names.hasMoreElements())
//            {
//                final String name = names.nextElement();
//                writer.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;" + name + ": " + session.getAttribute(name));
//            }
//        }
//        writer.println("<br>");
//        writer.println("<br><br>Headers: ");
//        {
//            final Enumeration<String> names = request.getHeaderNames();
//            while (names.hasMoreElements())
//            {
//                final String name = names.nextElement();
//                writer.println("<br>&nbsp;&nbsp;&nbsp;&nbsp;" + name + ": " + request.getHeader(name));
//            }
//        }
//        writer.println("<br>");
//        writer.println("<br>this.getServicesNum(): " + this.getServicesNum());
//    }
}
