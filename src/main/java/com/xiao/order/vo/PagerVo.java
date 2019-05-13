package com.xiao.order.vo;

/**
 * @author XiaoPengCheng
 * @create 2019-04-30 11:02
 *
 * 分页
 */
public class PagerVo<T> {

    /**
     * 当前页
     */
    private int page;

    /**
     * 每页显示记录数
     */
    private int limit;

    /**
     * 数据
     */
    private T data;

    /**
     * 总数
     */
    private int total;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PagerVo{" +
                "page=" + page +
                ", limit=" + limit +
                ", data=" + data +
                ", total=" + total +
                '}';
    }
}
