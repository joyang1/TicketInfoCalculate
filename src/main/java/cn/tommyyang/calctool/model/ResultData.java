package cn.tommyyang.calctool.model;

/**
 * Created by TommyYang on 2018/2/10.
 */
public class ResultData {

    private Integer id;

    private String section;

    private String combine;

    private Integer avg;

    private Bit bit;

    public ResultData(String section, String combine, Integer avg, Bit bit) {
        this.section = section;
        this.combine = combine;
        this.avg = avg;
        this.bit = bit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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
