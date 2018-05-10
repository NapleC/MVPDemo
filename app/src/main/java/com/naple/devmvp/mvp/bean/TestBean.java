package com.naple.devmvp.mvp.bean;

/**
 * created by hl at 2018/5/9
 * com.naple.devmvp.mvp.bean
 */
public class TestBean {

    private String name;
    private int bookCount;
    private int monthlyCount;

    public TestBean() {
    }

    public TestBean(String name, int bookCount, int monthlyCount) {
        this.name = name;
        this.bookCount = bookCount;
        this.monthlyCount = monthlyCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public int getMonthlyCount() {
        return monthlyCount;
    }

    public void setMonthlyCount(int monthlyCount) {
        this.monthlyCount = monthlyCount;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", bookCount=" + bookCount +
                ", monthlyCount=" + monthlyCount +
                '}';
    }
}
