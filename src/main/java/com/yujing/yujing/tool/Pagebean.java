package com.yujing.yujing.tool;

import java.util.List;

public class Pagebean<T> {
    private Integer total; //记录总数
    private Integer number; //每页显示的记录个数
    private Integer pagecount; //总页数
    private Integer page; //当前页码
    private List<T> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPagecount() {
        return pagecount;
    }

    public void setPagecount(Integer pagecount) {
        this.pagecount = pagecount;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Pagebean{" +
                "total=" + total +
                ", number=" + number +
                ", pagecount=" + pagecount +
                ", page=" + page +
                ", list=" + list +
                '}';
    }
}
