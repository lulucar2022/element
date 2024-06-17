package cn.lulucar.element.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wenxiaolan
 * @ClassName SwaggerConfig
 * @date 2024/6/17 16:04
 * @description
 */
@Configuration
public class Knife4jConfig {
    /**
     * 创建分组
     * group中写入分组名称（商店管理）
     * pathsToMatch中写入需要扫描的接口
     * @return
     */
    @Bean
    public GroupedOpenApi businessApi() {
        return GroupedOpenApi.builder()
                .group("商店管理")
                .pathsToMatch("/BusinessController/**")
                .build();
    }

    /**
     * docAPI
     * @return
     */
    @Bean
    public OpenAPI docsOpenApi() {
        return new OpenAPI()
                .info(new Info().title("Element-CRUD API")
                        .description("测试接口文档")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }
    
    
}
