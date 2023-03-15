package com.blog.blogapidemo.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
//    @Autowired
//    private LoginInterceptor loginInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        //跨域配置
        registry.addMapping("/**").allowedOrigins("https://blog.mszlu.com","http://blog1.mszlu.com","http://localhost:8080");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //拦截test接口，后续实际遇到需要拦截的接口时，在配置为真正的拦截接口
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/test")
//                .addPathPatterns("/comments/create/change")
//                .addPathPatterns("/articles/publish");
//    }
//    此时拦截器没有解决跨域问题，因为在处理跨域配置前就已经被拦截了，需要用corsfilter过滤器实现此网站跨域拦截访问
}
