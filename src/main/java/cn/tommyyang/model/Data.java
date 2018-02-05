package cn.tommyyang.model;

/**
 * Created by TommyYang on 2018/2/5.
 */
public class Data {

    private Long qihao;

    private Integer res;

    public Data(Long qihao, Integer res) {
        this.qihao = qihao;
        this.res = res;
    }

    public Long getQihao() {
        return qihao;
    }

    public void setQihao(Long qihao) {
        this.qihao = qihao;
    }

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }
}
