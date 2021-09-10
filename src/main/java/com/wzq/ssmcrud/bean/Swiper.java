package com.wzq.ssmcrud.bean;

public class Swiper {
    private Integer swiperId;

    private String swiperName;

    private String swiperUrl;

    public Integer getSwiperId() {
        return swiperId;
    }

    public void setSwiperId(Integer swiperId) {
        this.swiperId = swiperId;
    }

    public String getSwiperName() {
        return swiperName;
    }

    public void setSwiperName(String swiperName) {
        this.swiperName = swiperName == null ? null : swiperName.trim();
    }

    public String getSwiperUrl() {
        return swiperUrl;
    }

    public void setSwiperUrl(String swiperUrl) {
        this.swiperUrl = swiperUrl == null ? null : swiperUrl.trim();
    }
}