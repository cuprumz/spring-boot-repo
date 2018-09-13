package io.github.cuprumz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author cuprumz
 * @date 2018/09/12
 */
@Configuration
public class ImageMvcConfigure extends WebMvcConfigurerAdapter {


    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("classpath:/image/");
    }
}
