package com.sanqianyi.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author B-0219
 * @date 2018/5/31
 */
@RestController
public class HelloController {

    @RequestMapping("/aaa/bbb/helloWorld")
    public JSONObject helloWorld() {
        System.out.println("hahahahah");
        JSONObject json = new JSONObject();
        json.put("desc", "成功");
        json.put("code", "1");
        return json;
    }

}
