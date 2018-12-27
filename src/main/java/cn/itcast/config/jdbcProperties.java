package cn.itcast.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by netman on 2018/12/26.
 */

/**
 * springboot 自动帮我们注入
 */

/**
 * 任何类需要使用这个属性类的时候只需要在该类上加上这个注解即可
 * @EnableConfigurationProperties(jdbcProperties.class)
 *
 */
// @PropertySource("classpath:jdbc.properties") //属性地址 springboot会自动去找application.properties文件
//@ConfigurationProperties(prefix = "jdbc") //属性前缀
public class jdbcProperties {
    private String driverClassName;

    private String url;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;

    private String password;
}
