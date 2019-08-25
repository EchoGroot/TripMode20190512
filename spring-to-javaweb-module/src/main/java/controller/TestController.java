package main.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class TestController {

    @RequestMapping(value = "/query")

    @ResponseBody
    public String TestRequest(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        //获取请求参数
        JSONObject param = new JSONObject(request.getParameter("param"));
        System.out.println(param.get("start"));
        System.out.println(param.get("end"));

        response.setCharacterEncoding("utf-8");//第一句，设置服务器端编码
        response.setContentType("text/html;charset=utf-8");//第二句，设置浏览器端解码

        JSONObject jsonobject = new JSONObject();
        String str = "railway";
        str =  new String(str.getBytes("gbk"),"UTF-8");
        jsonobject.put("time","20190824");
        jsonobject.put("type",str);

        return jsonobject.toString();
    }
}
