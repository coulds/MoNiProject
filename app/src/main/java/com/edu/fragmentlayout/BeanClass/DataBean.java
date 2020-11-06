package com.edu.fragmentlayout.BeanClass;

import java.io.Serializable;

public class DataBean implements Serializable {

    /**
     * pid : 286730 //价格
     * cid : 1 //选中状态
     * dl_cnt : 0
     * c_t : 2014-11-28 01:00:01 // 时间
     * imgcut : 0
     * url : http://p3.qhimg.com/bdr/__85/d/_sjzs/didaxianshi141120/141101022926.jpg
     * tempdata :
     * fav_total : 8249//数量
     */

    private String pid;
    private String cid;
    private String dl_cnt;
    private String c_t;
    private String imgcut;
    private String url;
    private String tempdata;
    private String fav_total;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getDl_cnt() {
        return dl_cnt;
    }

    public void setDl_cnt(String dl_cnt) {
        this.dl_cnt = dl_cnt;
    }

    public String getC_t() {
        return c_t;
    }

    public void setC_t(String c_t) {
        this.c_t = c_t;
    }

    public String getImgcut() {
        return imgcut;
    }

    public void setImgcut(String imgcut) {
        this.imgcut = imgcut;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTempdata() {
        return tempdata;
    }

    public void setTempdata(String tempdata) {
        this.tempdata = tempdata;
    }

    public String getFav_total() {
        return fav_total;
    }

    public void setFav_total(String fav_total) {
        this.fav_total = fav_total;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "pid='" + pid + '\'' +
                ", cid='" + cid + '\'' +
                ", dl_cnt='" + dl_cnt + '\'' +
                ", c_t='" + c_t + '\'' +
                ", imgcut='" + imgcut + '\'' +
                ", url='" + url + '\'' +
                ", tempdata='" + tempdata + '\'' +
                ", fav_total='" + fav_total + '\'' +
                '}';
    }
}
