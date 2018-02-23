package cn.tommyyang.calctool.model;

/**
 * Created by TommyYang on 2018/2/10.
 */
public class ResultData {

    private String combine;

    private Integer avg;

    private Bit bit;

    public ResultData(String combine, Integer avg, Bit bit) {
        this.combine = combine;
        this.avg = avg;
        this.bit = bit;
    }

    public String getCombine() {
        return combine;
    }

    public void setCombine(String combine) {
        this.combine = combine;
    }

    public Integer getAvg() {
        return avg;
    }

    public void setAvg(Integer avg) {
        this.avg = avg;
    }

    public Bit getBit() {
        return bit;
    }

    public void setBit(Bit bit) {
        this.bit = bit;
    }
}
