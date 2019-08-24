package main.java.controller;

import main.java.domain.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author yuyy
 * @date 2019/8/22 9:37
 */

@Controller
public class tripModeController {

    @RequestMapping(value = "/test")
    //@RequestMapping(value = "/test",method = RequestMethod.GET)

    @ResponseBody
    public Result bestTimeAndMethod(String temp){
        System.out.println(temp);
        System.out.println("020");
        return new Result("0","020");
    }
}
