package com.sanqianyi.controller;

import com.alibaba.fastjson.JSONObject;
import com.sanqianyi.bean.PageBean;
import com.sanqianyi.service.DecorateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 装修产品列表查询及申请
 */
@RestController
@Slf4j
@RequestMapping("/decorate")
public class DecorateController {

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    //    @Autowired
//    LendProductBolt lendProductBolt;
    @Autowired
    DecorateService service;

    /**
     * 装修申请人数随机数产生
     *
     * @return
     */
    @RequestMapping("/decorateNum.go")
    public JSONObject decorateNum() {
        log.info("开始查询装饰公司的申请人数");
        JSONObject json = new JSONObject();

        String now = LocalDate.now().toString();
        String yesterday = LocalDate.now().plusDays(-1).toString();

        if (redisTemplate.opsForValue().get(now) == null) {
            redisTemplate.opsForValue().set(now, String.valueOf(new Random().nextInt(10) + 10), 1, TimeUnit.DAYS);
            redisTemplate.delete(yesterday);
        }
        int randomNum = Integer.parseInt(redisTemplate.opsForValue().get(now).toString()) + new Random().nextInt(3);
        redisTemplate.opsForValue().set(now, String.valueOf(randomNum));
        log.info("装饰公司的申请人数一共有={}个", redisTemplate.opsForValue().get(now).toString());
        json.put("data", randomNum);
        json.put("code", "1");
        json.put("desc", "生成成功");
        return json;
    }


    /**
     * 查询装修公司列表
     *
     * @return
     */
    @RequestMapping("/decorateApplyList.go")
    public JSONObject decorateApplyList(PageBean bean) {
        log.info("开始查询装修公司列表时间={}", LocalDateTime.now());
        return service.queryDecorateApplyList(bean);
    }

    /**
     * 根据id查询装修公司详情
     *
     * @return
     */
    @RequestMapping("/decorateProductDetail.go")
    public JSONObject decorateProductDetail(String productid) {
        log.info("productid={}查询详情时间={}", productid, LocalDateTime.now());
        return service.decorateProductDetail(productid);
    }

}
