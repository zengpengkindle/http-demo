package cn.itcast.Controller;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

/**
 * Created by netman on 2018/12/26.
 */
@RestController
public class HelloController {

    @Autowired
    DataSource dataSource;

    @GetMapping("hi")
    public String Hello()
    {

        System.out.println(dataSource);
        return "hi zp!";

    }
}
