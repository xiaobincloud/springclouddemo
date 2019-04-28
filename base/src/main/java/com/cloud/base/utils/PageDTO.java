package com.cloud.base.utils;

import com.cloud.base.eunm.SortType;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaobin
 * 成都友漾健康科技有限公司
 * Created by xiaobin on 2017/7/20
 * Copyright (c) 2016-2019
 */
public class PageDTO implements Serializable{

    @ApiModelProperty(value = "页码", required = true)
    private Integer pageNumber = 1;

    @ApiModelProperty(value = "页大小", required = true)
    private Integer pageSize = 10;

    @ApiModelProperty(value = "排序方式")
    private SortType sort;

    @ApiModelProperty(value = "排序字段")
    private List<String> properties = new ArrayList<>();

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public SortType getSort() {
        return sort;
    }

    public void setSort(SortType sort) {
        this.sort = sort;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }
}
