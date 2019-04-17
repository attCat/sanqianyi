package com.sanqianyi.mapper;

import com.github.pagehelper.Page;
import com.sanqianyi.bean.PageBean;
import com.sanqianyi.dto.DecorateListDto;
import com.sanqianyi.dto.DecorateProductDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by liuweiguo on 2016/8/10.
 */
@Mapper
public interface DecorateMapper {

    /**
     * 查询装修公司列表
     *
     * @param bean
     * @return
     */
    Page<DecorateListDto> queryDecorateApplyList(PageBean bean);

    /**
     * 根据id查询装修公司详情
     *
     * @param productid
     * @return
     */
    DecorateProductDto decorateProductDetail(String productid);
}
