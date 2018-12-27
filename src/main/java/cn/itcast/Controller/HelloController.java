package cn.itcast.Controller;

import cn.itcast.Service.UserService;

import cn.itcast.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by netman on 2018/12/26.
 */
@RestController
public class HelloController {

   @Autowired
    UserService userService;



    @GetMapping("hi")

    public User Hello()
    {

       //System.out.println(userService.queryById(1));
        return userService.queryById(1);

    }
}
