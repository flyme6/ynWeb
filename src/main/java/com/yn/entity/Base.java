package com.yn.entity;

/**
 * @Author ：flyme
 * @ProjectName: ynWeb1.2
 * @Title : Base
 * @Description：Bean对象基本类
 * @Date ：Created in 16:44 2018/10/31
 */
public class Base {
    private Integer lastCount;

    private Integer pageSize;

    public Integer getLastCount() {
        return lastCount;
    }

    public void setLastCount(Integer lastCount) {
        this.lastCount = lastCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
