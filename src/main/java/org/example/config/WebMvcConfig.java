package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.common.JacksonObjectMapper;
import org.example.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    @Autowired
//    private LoginInterceptor loginInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        log.info("静态资源映射ok");
    }

    /**
     * 添加mvc拦截器，并配置拦截路径
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html","/swagger-resources/**","/webjars/**","/swagger-ui/**","/v3/api-docs/**","/doc.html")
        ;
    }


    /**
     * 扩展mvc框架的消息转换器
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("扩展消息转换器...");
        converters.add(new ByteArrayHttpMessageConverter());

        // 创建消息转换器对象
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setDefaultCharset(StandardCharsets.UTF_8);
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        messageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));

        // 将上面的消息转换器对象追加到mvc框架的转换器集合中
        converters.add( messageConverter);

        // 创建并配置 StringHttpMessageConverter
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(StandardCharsets.UTF_8);
        stringHttpMessageConverter.setSupportedMediaTypes(
                Arrays.asList(
                        MediaType.TEXT_PLAIN,
                        MediaType.TEXT_HTML,
                        MediaType.APPLICATION_JSON_UTF8
                )
        );

        converters.add(stringHttpMessageConverter);

    }
}
