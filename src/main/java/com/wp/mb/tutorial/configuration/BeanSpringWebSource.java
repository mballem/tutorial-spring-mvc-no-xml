package com.wp.mb.tutorial.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created with IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 10/10/12
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebMvc
public class BeanSpringWebSource extends WebMvcConfigurerAdapter {

    private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/view/";
    private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

    @Bean(name = "jspViewResolver")
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();

        resolver.setPrefix(VIEW_RESOLVER_PREFIX);
        resolver.setSuffix(VIEW_RESOLVER_SUFFIX);
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
