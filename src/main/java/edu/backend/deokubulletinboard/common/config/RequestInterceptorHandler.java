package edu.backend.deokubulletinboard.common.config;

import org.apache.ibatis.javassist.bytecode.stackmap.Tracer;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * packageName     : edu.backend.deokubulletinboard.common.config
 * fileName        : RequestInterceptorHandler
 * author          : jungwon.lee
 * date            : 2022-09-16
 * version         : v0.1
 */
@Component
public class RequestInterceptorHandler implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(RequestInterceptorHandler.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
//        response.addHeader("trace-id", tracer.currentSpan( ).context( ).traceIdString( ));
//        response.addHeader("span-id", tracer.currentSpan( ).context( ).spanIdString( ));
        // TODO Auto-generated method stub
        LOG.info("================= login, session, cache process =================");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
    }
}
