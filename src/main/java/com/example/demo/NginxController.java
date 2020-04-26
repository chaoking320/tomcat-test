package com.example.demo;


import com.example.demo.model.TestModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/nginx")
public class NginxController {

    /**
     * 为了说明nginx的负载均衡
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String callback4Get(Long orderId) {
       return "为了说明nginx的负载均衡：mynginx2";
    }
}
