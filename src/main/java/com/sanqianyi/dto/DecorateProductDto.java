package com.sanqianyi.dto;

import lombok.Data;

/**
 * 装修产品bean
 *
 * @author zwy
 * @date 2019/4/16
 */
@Data
public class DecorateProductDto {
    /**
     * 产品id
     */
    private String productid;
    /**
     * 产品名称
     */
    private String productname;
    /**
     * 产品创建时间
     */
    private String adddate;
    /**
     * 展示开始时间
     */
    private String startdate;
    /**
     * 展示结束时间
     */
    private String enddate;
    /**
     * 电话
     */
    private String phone;
    /**
     * 产品logo图片url
     */
    private String logourl;
    /**
     * 申请人数
     */
    private String applynum;
    /**
     * 产品描述
     */
    private String desc;
    /**
     * 展示标签
     */
    private String tag;
    /**
     * 详情1
     */
    private String detailurl1;
    /**
     * 详情2
     */
    private String detailurl2;
    /**
     * 详情3
     */
    private String detailurl3;
}
