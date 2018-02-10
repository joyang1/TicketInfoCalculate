package cn.tommyyang.calctool.model;

/**
 * Created by TommyYang on 2018/2/10.
 */
public class ResultData {

    private String combine;

    private Integer avg;

    public ResultData(String combine, Integer avg) {
        this.combine = combine;
        this.avg = avg;
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
}
