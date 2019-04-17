package com.sanqianyi.dto;

import lombok.Data;

/**
 * 装修列表查询
 *
 * @author zwy
 * @date 2019/4/17
 */
@Data
public class DecorateListDto {
    /**
     * 产品id
     */
    private String productid;
    /**
     * 产品名称
     */
    private String productname;
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
}
