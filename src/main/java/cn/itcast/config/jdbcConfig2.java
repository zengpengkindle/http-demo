package cn.itcast.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * 当spring 扫描到这个类的时候 发现有个datasource方法 并标注了@bean 然后就会
 * 调用该方法 然后返回datasource 到spring 容器中
 */

/**
 * Created by netman on 2018/12/26.
 */

//@Configuration //声明这个类是配置类 代替xml
////开启springboot 注入的熟悉值
//@EnableConfigurationProperties(jdbcProperties.class)

public class jdbcConfig2 {




   // @Bean //注入到spring容器中
    //当spring 扫描到这个方法bean时 发现参数是 这个属性类 然后自动会去找 这个class 然后注入值
    public DataSource dataSource(jdbcProperties properties) //直接在bean 方法中传入 属性实例 就可以自动注入
    {
        // alibabadruid 数据源
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }

    @Autowired
    jdbcProperties pro;

    @Bean
    public DruidDataSource  dataSource()
    {
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(pro.getDriverClassName());
        dataSource.setUrl(pro.getUrl());
        dataSource.setUsername(pro.getUsername());
        dataSource.setPassword(pro.getPassword());
        return dataSource;
    }
}



