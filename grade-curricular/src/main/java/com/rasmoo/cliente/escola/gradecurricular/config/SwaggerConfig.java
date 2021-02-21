package com.rasmoo.cliente.escola.gradecurricular.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    public static final String CURSO = "Curso";

    @Bean
    public Docket gradeCurricularApi() {
        return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).select()
                .apis(RequestHandlerSelectors.basePackage("com.rasmoo.cliente.escola.gradecurricular")).build()
                .apiInfo(this.metaData())
                .tags(new Tag(CURSO, "Operações referente a manipulação da entidade Curso"));
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder().title("GRADE CURRICULAR")
                .description(" API responsavel pela manutenção da grade curricular")
                .version("1.0.0").license("").build();
    }

    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> listPlugins = new ArrayList<>();
        listPlugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(listPlugins));
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:META-INF/resources/webjars/");
    }
}
