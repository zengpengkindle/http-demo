package cn.itcast.config;

import cn.itcast.intercepter.LoginInterceptor;
import com.zaxxer.hikari.HikariConfigMXBean;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Created by netman on 2018/12/26.
 */

/**
 * 定义mvc 拦截器/过滤器  需要定义高级的拦截器 堵在这里配置 具体看WebMvcConfigurer 接口
 */
@Configuration
public class MVCconfig implements WebMvcConfigurer {

    @Autowired
    private DataSource dataSource;

    //拦截器方式一
    //  @Override
    public void addInterceptors2(InterceptorRegistry registry) {//注册拦截器

        registry.addInterceptor(new HandlerInterceptor() {
            //定义self4j日志主键
            private Logger logger = LoggerFactory.getLogger(this.getClass());

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

//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactoryBean() {
//        SqlSessionFactoryBean sqlFactory = new SqlSessionFactoryBean();
//        //  SqlSessionFactory
//        try {
//            sqlFactory.setDataSource(dataSource);
//            //设置mybatis的主配置文件  记住是主配置文件啊
//            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//            Resource mybatisXml = resolver.getResource("classpath:mybatis-config.xml");
//            sqlFactory.setConfigLocation(mybatisXml);
//            //设置mapper.xml文件的路径
//            Resource[] resource = resolver.getResources("classpath*:com/jiuzhm/memo/mybatis/**/*.xml");//{resourceMapXML};
//            sqlFactory.setMapperLocations(resource);
//            //扫描实体类所在包
//            sqlFactory.setTypeAliasesPackage("com.jiuzhm.memo.mybatis.entity");
//        } catch (Exception e) {
//            //e.printStackTrace();
//        }
//        return sqlFactory;
//    }



    @Bean
    public LoginInterceptor loginInterceptor()
    {
        return new LoginInterceptor();
    }

    //@Autowired
  //  DataSource dataSource;
    //拦截器 方式二
    @Override
            public void addInterceptors(InterceptorRegistry registry) {

        //这样new 会导致LoginInterceptor类中的注入 注入不了 因为此处是new 已经不是spring 管理的
        //组件 需要特别注意  如果一定要注入 则需要在当前拦截器中 用@bean 的方式注入需要使用的拦截器方法
        //切记不能直接使用new 否则spring 将无法注入
       // registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");

        registry.addInterceptor(this.loginInterceptor()).addPathPatterns("/**");
    }
}
