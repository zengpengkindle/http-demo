package cn.itcast.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by netman on 2018/12/26.
 */

/**
 * 定义mvc 拦截器/过滤器  需要定义高级的拦截器 堵在这里配置 具体看WebMvcConfigurer 接口
 */
@Configuration
public class MVCconfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//注册拦截器

        registry.addInterceptor(new HandlerInterceptor() {
            //定义self4j日志主键
            private Logger logger= LoggerFactory.getLogger(this.getClass());

            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                logger.info("这是前置拦截器");
                return true;
            }

            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
                logger.info("这是后置拦截器");
            }

            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
                logger.info("这是阿福尔特拦截器");
            }
        }).addPathPatterns("/**");


    }
}
