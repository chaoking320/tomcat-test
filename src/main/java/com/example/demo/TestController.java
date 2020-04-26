package com.example.demo;

import com.example.demo.model.TestModel;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utils.SerializeUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/callback4post", method = RequestMethod.POST)
    @ResponseBody
    public TestModel callback4Post(@RequestBody TestModel model) {
        System.out.print("来了");
        TestModel t = new TestModel();
        t.setOrderId(model.getOrderId());
        return t;
    }

    @RequestMapping(value = "/callback4get", method = RequestMethod.GET)
    @ResponseBody
    public TestModel callback4Get(Long orderId) {
        System.out.print("来了"+orderId.toString());
        TestModel t = new TestModel();
        t.setOrderId(orderId);
        return t;
    }


    @RequestMapping(value = "/callback4jsonp", method = RequestMethod.GET)
    @ResponseBody
    public String callback4Jsonp(HttpServletRequest request) throws IOException {
        String callback = request.getParameter("callback");
        Long orderId = Long.parseLong(request.getParameter("orderId"));
        String msg ="({\"userId\":\"E540365921\"})";
        return callback+"("+msg+")";
    }

    @RequestMapping(value = "/wife", method = RequestMethod.GET)
    @ResponseBody
    public String wifelove(HttpServletRequest request) throws IOException {

        Integer type = Integer.parseInt(request.getParameter("type"));
        if(type==1){
            return "老婆我爱你";
        }else{
            return "智卫你好";
        }

    }
}
