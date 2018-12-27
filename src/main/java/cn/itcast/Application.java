package cn.itcast;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by netman on 2018/12/26.
 */

/**
 * springboot自动扫描spring的类 无需配置
 *
 */
@MapperScan("cn.itcast.Mapper")
@SpringBootApplication
public class Application {
    
    public static void main(String[] args){
        SpringApplication.run(Application.class);
    } 
}
