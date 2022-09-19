package edu.backend.deokubulletinboard.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * packageName     : edu.backend.deokubulletinboard.common.config
 * fileName        : WebConfig
 * author          : jungwon.lee
 * date            : 2022-09-16
 * version         : v0.1
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    RequestInterceptorHandler interceptor;

    @Override
    public void addCorsMappings( CorsRegistry registry ) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowCredentials(true) // 쿠키 요청을 허용한다(다른 도메인 서버에 인증하는 경우에만 사용해야하며, true 설정시 보안상 이슈가 발생할 수 있다)
                .allowedMethods(RequestMethod.GET.name(),
                        RequestMethod.POST.name(),
                        RequestMethod.PUT.name(),
                        RequestMethod.DELETE.name(),
                        RequestMethod.OPTIONS.name());
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**/*");
    }


}
