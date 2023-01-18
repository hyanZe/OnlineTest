package top.jayczee.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    /**
     * 设置多个：
     *
     * @return
     * @Bean public Docket appApi() {
     * <p>
     * List<Parameter> pars = new ArrayList<>();
     * ParameterBuilder token = new ParameterBuilder();
     * token.name("token").description("用户令牌").modelRef(new ModelRef("string")).parameterType("header").required(false)
     * .build();
     * pars.add(token.build());
     * <p>
     * return new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/app/.*")).build()
     * .globalOperationParameters(pars).apiInfo(pdaApiInfo()).useDefaultResponseMessages(false)
     * .enable(enableSwagger)
     * .groupName("appApi");
     * <p>
     * }
     * @Bean public Docket adminApi() {
     * <p>
     * List<Parameter> pars = new ArrayList<>();
     * ParameterBuilder token = new ParameterBuilder();
     * token.name("token").description("用户令牌").modelRef(new ModelRef("string")).parameterType("header").required(false)
     * .build();
     * pars.add(token.build());
     * return new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/admin/.*")).build()
     * .globalOperationParameters(pars).apiInfo(pdaApiInfo()).useDefaultResponseMessages(false)
     * .enable(enableSwagger)
     * .groupName("adminApi");
     * <p>
     * }
     */

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("top.jayczee.backend.controller")).paths(PathSelectors.any())
                .build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("action-swagger").description("榆荚无才思在线题库系统").termsOfServiceUrl("")
                .version("1.0").build();
    }

}
