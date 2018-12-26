package cn.itcast.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;



@Configuration //声明这个类是配置类 代替xml

public class jdbcConfig3 {





    @Bean
    @ConfigurationProperties(prefix = "jdbc") //他会去找所有以jdbc为前缀的属性 然后赋值 注入
    public DruidDataSource  dataSource()
    {
        DruidDataSource dataSource=new DruidDataSource();

        return dataSource;
    }
}



