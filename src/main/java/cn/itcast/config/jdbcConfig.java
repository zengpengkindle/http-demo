package cn.itcast.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by netman on 2018/12/26.
 */
@Configuration //声明这个类是配置类 代替xml
public class jdbcConfig {

    @Bean //注入到spring容器中
    public DataSource dataSource()
    {
        //alibabadruid 数据源
        DataSource dataSource=new DruidDataSource();
        return dataSource;
    }
}

