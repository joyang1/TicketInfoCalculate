package cn.tommyyang.calctool.model;

/**
 * Created by TommyYang on 2018/2/5.
 */
public class Data {

    private Long qihao;

    private String res;

    private Boolean isLow;

    public Data(Long qihao, String res) {
        this.qihao = qihao;
        this.res = res;
    }

    public Long getQihao() {
        return qihao;
    }

    public void setQihao(Long qihao) {
        this.qihao = qihao;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public Boolean getLow() {
        return isLow;
    }

    public void setLow(Boolean low) {
        isLow = low;
    }
}
