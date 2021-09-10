package com.wzq.ssmcrud.bean;

public class Juvenile {
    private Integer juvenileId;

    private String jName;

    private String gender;

    private String weapon;

    private String sect;

    private String portraitUrl;

    private Integer cId;

    private Comic comic;

    public Juvenile() {
    }

    public Juvenile(Integer juvenileId, String jName, String gender, String weapon, String sect, String portraitUrl, Integer cId) {
        this.juvenileId = juvenileId;
        this.jName = jName;
        this.gender = gender;
        this.weapon = weapon;
        this.sect = sect;
        this.portraitUrl = portraitUrl;
        this.cId = cId;
    }

    public Juvenile(Integer juvenileId, String jName, String gender, String weapon, String sect, String portraitUrl, Comic comic) {
        this.juvenileId = juvenileId;
        this.jName = jName;
        this.gender = gender;
        this.weapon = weapon;
        this.sect = sect;
        this.portraitUrl = portraitUrl;
        this.comic = comic;
    }

    public Comic getComic() {
        return comic;
    }

    public void setComic(Comic comic) {
        this.comic = comic;
    }

    public Integer getJuvenileId() {
        return juvenileId;
    }

    public void setJuvenileId(Integer juvenileId) {
        this.juvenileId = juvenileId;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName == null ? null : jName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon == null ? null : weapon.trim();
    }

    public String getSect() {
        return sect;
    }

    public void setSect(String sect) {
        this.sect = sect == null ? null : sect.trim();
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl == null ? null : portraitUrl.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "Juvenile{" +
                "juvenileId=" + juvenileId +
                ", jName='" + jName + '\'' +
                ", gender='" + gender + '\'' +
                ", weapon='" + weapon + '\'' +
                ", sect='" + sect + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", cId=" + cId +
                ", comic=" + comic +
                '}';
    }
}