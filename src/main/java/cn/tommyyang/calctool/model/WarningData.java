package cn.tommyyang.calctool.model;

/**
 * Created by TommyYang on 2018/2/24.
 */
public class WarningData {

    private Bit bit;

    private Integer number;

    private Integer qstimes;

    public WarningData(Bit bit, Integer number, Integer qstimes) {
        this.bit = bit;
        this.number = number;
        this.qstimes = qstimes;
    }

    public Bit getBit() {
        return bit;
    }

    public void setBit(Bit bit) {
        this.bit = bit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getQstimes() {
        return qstimes;
    }

    public void setQstimes(Integer qstimes) {
        this.qstimes = qstimes;
    }
}
