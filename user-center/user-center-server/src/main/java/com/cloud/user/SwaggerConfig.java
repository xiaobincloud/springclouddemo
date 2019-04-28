package com.cloud.user;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xiaobin
 * @Title: SwaggerConfig
 * @date 2019/04/28
 * @Description:
 */

@Configuration
@EnableSwagger2
// 当配置文件没有swagger注入时，matchIfMissing 为false不加载此类，当有属性注入时为true依然加载此类
@ConditionalOnProperty(prefix = "swagger", value = "enabled")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cloud.user.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ULINKCARE构建RESTful APIs相关文档")
                .description("更多相关文档请咨询【乐享峰动】微信公众号")
                .termsOfServiceUrl("http://www.ulinkcare.com")
                .version("1.0")
                .build();
    }
}
