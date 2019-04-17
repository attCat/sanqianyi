package com.sanqianyi.bean;

import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * 分页bean
 */
public class PageBean implements Serializable {

    //==============分页字段开始================
    private Integer pageNum = Integer.valueOf(1);
    private Integer pageSize = Integer.valueOf(10);
    private String orderBy;
    private Integer pn = Integer.valueOf(1);
    private Integer ps = Integer.valueOf(10);
    //==============分页字段结束================

    public void setPn(Integer pn) {
        this.pn = pn;
        this.pageNum = pn;
    }

    public void setPs(Integer ps) {
        this.ps = ps;
        this.pageSize = ps;
    }

    public Integer getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    public Integer getPn() {
        return this.pn;
    }

    public Integer getPs() {
        return this.ps;
    }

    public String getOrderBy() {
        if (!StringUtils.isEmpty(this.orderBy)) {
            String reg = "(?:\')|(?:--)|(/\\*(?:.|[\\n\\r])*?\\*/)|(\\b(select|update|and|or|delete|insert|trancate|char|into|substr|ascii|declare|exec|count|master|into|drop|execute)\\b)";
            Pattern sqlPattern = Pattern.compile(reg, 2);
            if (sqlPattern.matcher(this.orderBy).find()) {
                return "";
            }
        }

        return this.orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}