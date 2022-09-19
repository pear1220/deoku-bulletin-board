package edu.backend.deokubulletinboard.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * packageName     : edu.backend.deokubulletinboard.common.config
 * fileName        : SwaggerConfig
 * author          : jungwon.lee
 * date            : 2022-09-16
 * version         : v0.1
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private String version;

    private String title;

    @Bean
    public Docket SessionApi( ) {

        version = "SESSION";
        title = "session login";

        return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).groupName(version).select( )
                .apis(RequestHandlerSelectors.basePackage("edu.backen.deokubulletinboard.session"))
                .paths(PathSelectors.ant("/api/v1/**")).build( ).apiInfo(apiInfo(title, version))
                .securityContexts(Arrays.asList(securityContext( )))
                .securitySchemes(Arrays.asList(apiKey( )));

    }

    private ApiInfo apiInfo(String title, String version) {
        return new ApiInfoBuilder()
                .version(version)
                .title(title)
                .description(title)
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("access_token", "Authorization", "header");
    }

    private springfox.documentation.spi.service.contexts.SecurityContext securityContext( ) {

        return springfox.documentation.spi.service.contexts.SecurityContext.builder( )
                .securityReferences(defaultAuth( )).forPaths(PathSelectors.any( )).build( );
    }


    private List<SecurityReference> defaultAuth( ) {

        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        //return Lists.newArrayList(new SecurityReference("X-Authorization", authorizationScopes));
        return Arrays.asList(new SecurityReference("X-Authorization", authorizationScopes));
    }

}
