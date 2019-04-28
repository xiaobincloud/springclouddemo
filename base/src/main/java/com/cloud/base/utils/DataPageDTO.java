package com.cloud.base.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 分页对象
 * @author xiaobin
 * Created by xiaobin on 2017/7/21
 * Copyright (c) 2016-2019
 */
@ApiModel(value = "分页数据对象", description = "查询分页时的数据对象")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataPageDTO <T> {

    @ApiModelProperty(value = "总页数")
    private int totalPage;

    @ApiModelProperty(value = "页码")
    private int number;

    @ApiModelProperty(value = "页大小")
    private int size;

    @ApiModelProperty(value = "总条数")
    private long totalElements;

    @ApiModelProperty(value = "分页数据")
    private List<T> content;

    public DataPageDTO() {
    }

    public DataPageDTO(int totalPage, int number, int size, List<T> content,long totalElements) {
        this.totalPage = totalPage;
        this.number = number;
        this.size = size;
        this.content = content;
        this.totalElements=totalElements;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}
