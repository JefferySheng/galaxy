package com.galaxy.framework.base.pagination;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author aaron.pan
 * @date 2018/5/28
 */
public class Pagination {

    /**
     * 升序
     */
    public final static String ASC = "asc";
    /**
     * 降序
     */
    public final static String DESC = "desc";

    @ApiModelProperty(value = "一页条数")
    private Integer pageSize;
    @ApiModelProperty(value = "当前页码")
    private Integer pageNumber;
    @ApiModelProperty(value = "排序字段")
    private String orderBy;
    @ApiModelProperty(value = "正序/倒序（asc/desc）")
    private String orderDirection;

    public <T> Page getPage() {
        Integer pageSize = this.pageSize != null ? this.pageSize : 20;
        Integer pageNumber = this.pageNumber != null ? this.pageNumber : 1;
        Page<T> page = new Page<T>(pageNumber, pageSize);
        if (StringUtils.isNotEmpty(orderBy)) {
            page.setOpenSort(true);
            page.setOrderByField(orderBy);
            page.setAsc(!DESC.equals(orderDirection));
        }
        return page;
    }

    public static String getASC() {
        return ASC;
    }

    public static String getDESC() {
        return DESC;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }
}
