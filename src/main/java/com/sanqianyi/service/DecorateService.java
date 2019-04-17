package com.sanqianyi.service;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.sanqianyi.bean.PageBean;
import com.sanqianyi.dto.DecorateListDto;
import com.sanqianyi.dto.DecorateProductDto;
import com.sanqianyi.mapper.DecorateMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liuweiguo on 2016/8/10.
 */
@Service
@Slf4j
public class DecorateService {
    /**
     * The Lend mapper.
     */
    @Autowired
    DecorateMapper decorateMapper;

    /**
     * 查询装修公司列表
     *
     * @param bean the bean
     * @return list
     */
    public JSONObject queryDecorateApplyList(PageBean bean) {
        JSONObject retJson = new JSONObject();
        //查询装修公司列表
        Page<DecorateListDto> list = decorateMapper.queryDecorateApplyList(bean);
        log.info("查询装修公司列表的个数={}", list.size());
        JSONObject data = new JSONObject();

        //总页数
        data.put("totalpage", list.getPages());
        //总条数
        data.put("totalnum", list.getTotal());

        data.put("list", list.getResult());
        retJson.put("code", "1");
        retJson.put("desc", "查询成功");
        retJson.put("data", data);
        return retJson;
    }


    /**
     * 根据id查询装修公司详情
     *
     * @param productid
     * @return
     */
    public JSONObject decorateProductDetail(String productid) {
        JSONObject json = new JSONObject();
        if (StringUtils.isEmpty(productid)) {
            json.put("code", "-1");
            json.put("desc", "查询失败");
            log.info("查询装修公司id为空");
            return json;
        }
        //根据id查询装修公司详情
        DecorateProductDto dto = decorateMapper.decorateProductDetail(productid);
        if (null == dto || StringUtils.isEmpty(dto.getProductname())) {
            json.put("code", "-1");
            json.put("desc", "产品不存在");
            log.info("查询装修公司id={}, 数据库不存在!", productid);
            return json;
        }
        log.info("查询装修公司id={}, 名称={}", dto.getProductid(), dto.getProductname());
        json.put("code", "1");
        json.put("desc", "查询成功");
        json.put("data", dto);
        return json;
    }
}
