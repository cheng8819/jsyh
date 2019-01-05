package com.example.jsconsumerregister.jsconsumerregister.util;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ConditionalOnProperty(prefix = "swagger", value = { "enable" }, havingValue = "true")
@EnableSwagger2
public class Swagger2 {

    /*@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.jsconsumerregister.jsconsumerregister.controller"))
                .paths(PathSelectors.any())
                .build();
    }
*/
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定当前服务的host

                // 指定package下生成API文档
                .select().apis(RequestHandlerSelectors.basePackage("com.example.jsconsumerregister.jsconsumerregister.controller"))
                // 过滤生成链接(any()表示所有url路径)
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    // api接口作者相关信息
    private ApiInfo apiInfo() {
        Contact contact = new Contact("moguang", "", "xxx@qq.com");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .license("Apache License Version 2.0")
                .title("Example服务接口")
                .description("接口文档")
                .contact(contact)
                .version("1.0")
                .build();
        return apiInfo;
    }


}
