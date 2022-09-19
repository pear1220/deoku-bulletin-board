package edu.backend.deokubulletinboard.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * packageName     : edu.backend.deokubulletinboard.common.filter
 * fileName        : Filter
 * author          : jungwon.lee
 * date            : 2022-09-16
 * version         : v0.1
 */

@WebFilter(urlPatterns = "/*")
public class GlobalFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);

        LOG.info("================= encode, CORS, XSS, LOG process =================");

        // pre handle
        chain.doFilter(httpServletRequest, httpServletResponse);

        // after handle

    }
}
