/*
 * Copyright (c) 2013-2015, 成都友漾健康科技有限公司
 * Created by qingyu on 2017/5/6.
 */
package com.cloud.base.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

public class SuperBase {
    /**
     * 初始化查询参数
     * @param pageNumber
     * @param pageSize
     * @return
     */
    protected Pageable initPublicSearchParams(Integer pageNumber, Integer pageSize,Sort.Direction direction, String... properties){
        Integer pageIndex = pageNumber == null ? 1 : pageNumber;
        Integer size = pageSize == null ? SysConstant.DEFAULT_SIZE : pageSize;
        Sort.Direction sort = direction == null ? Sort.Direction.DESC : direction;
        //默认排序
        List<Sort.Order> orders=new ArrayList<>();
        if(properties!=null&&properties.length>0){
            for (String propertie : properties){
                orders.add(new Sort.Order(sort, propertie));
            }
        }else{
            orders.add(new Sort.Order(sort,"createTime"));
        }
        // 页码的判断
        pageIndex = (pageIndex <= 0) ? 1 : pageIndex;
        // 一页内数据条数的判断
        size = (size <= 0) ? SysConstant.DEFAULT_SIZE : size;
        // 返回构造的分页对象
        Pageable pageable= new PageRequest((pageIndex - 1), size, new Sort(orders));
        return pageable;
    }

    /**
     * 重载初始化参数
     * @param pageNumber
     * @param pageSize
     * @return
     */
    protected Pageable initPublicSearchParams(Integer pageNumber, Integer pageSize){
        return initPublicSearchParams(pageNumber, pageSize, null);
    }
}
