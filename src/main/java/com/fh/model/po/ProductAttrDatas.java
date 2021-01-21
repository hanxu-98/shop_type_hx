package com.fh.model.po;

public class ProductAttrDatas {
    private Integer id;
    private Integer proId;
    private String attrData; // {"1":3,"2":9}
    private Integer storcks;
    private Double price;
    //private String sttrDataCH;//{"颜色":"红色","内存大小":"16G"}


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getAttrData() {
        return attrData;
    }

    public void setAttrData(String attrData) {
        this.attrData = attrData;
    }

    public Integer getStorcks() {
        return storcks;
    }

    public void setStorcks(Integer storcks) {
        this.storcks = storcks;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
