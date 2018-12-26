package cn.itcast.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by netman on 2018/12/26.
 */
@RestController
public class SecondHello {
    @GetMapping("second")
    public String second()
    {
        return "say second!";
    }
}
