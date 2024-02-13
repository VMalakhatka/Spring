package org.example.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Logger;

public class LogFilter implements Filter {

    private final Logger logger = Logger.getLogger("HelloLogger");

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        logger.info("Hello from: " + servletRequest.getLocalAddr());

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;


        logRequestDetails(request);

        chain.doFilter(request, response);

        logResponseDetails(response);
    }

    private void logRequestDetails(HttpServletRequest request) {

        StringBuilder parameters = new StringBuilder("{");
        for (String parameterName : request.getParameterMap().keySet()) {
            String[] parameterValues = request.getParameterValues(parameterName);
            parameters.append(parameterName).append(": [");
            for (String value : parameterValues) {
                parameters.append(value).append(", ");
            }
            if (parameterValues.length > 0) {
                parameters.setLength(parameters.length() - 2); //Удалить последнюю ", "
            }
            parameters.append("], ");
        }
        if (parameters.length() > 1) {
            parameters.setLength(parameters.length() - 2); //Удалить последнюю  ", "
        }

        // Атрибуты
        StringBuilder atributes = new StringBuilder();
        Enumeration<String> attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            Object attributeValue = request.getAttribute(attributeName);
            atributes.append("Attribute: {").append(attributeName).append(": ").append(attributeValue).append("}, \n");
        }

        String clientDetails = "\nClient Details - \n" + "Remote Address: {" + request.getRemoteAddr() + "}, \n" +
                "Remote Host: {" + request.getRemoteHost() + "}, \n" +
                "Remote Port: {" + request.getRemotePort() + "}, \n" +
                "Remote User: {" + request.getRemoteUser() + "}, \n";

        HttpSession session = request.getSession();
        parameters.append("}");
        logger.info("\n\nRequest received - \nMethod: {"+ request.getMethod()
                        +"}, \nURL: {"+request.getRequestURL()
                        +"}, \nHeaders: {"+ getHeaders(request)
                        +"}, \nParameters: {"+ parameters
                        +"}\n" +
                        atributes +
                        clientDetails +
                "Session: {"+session+" }\n");
    }

    private void logResponseDetails(HttpServletResponse response) {
        logger.info("\n\nResponse sent - \nStatus: {"+response.getStatus()
                +"}, \nHeaders: {"+response.getHeaderNames()+"}");
    }

    private String getHeaders(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        StringBuilder headers = new StringBuilder("\n    {\n");
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.append("          ").append(headerName).append(": ").
                    append(Collections.list(request.getHeaders(headerName))).append(", \n");
        }
        if (headers.length() > 1) {
            headers.setLength(headers.length() - 2);
        }
        headers.append("\n    }\n");
        return headers.toString();
    }


}
