package cn.tommyyang.calctool.model;

/**
 * Created by TommyYang on 2018/3/20.
 */
public class MissingData {

    private Bit bit;

    private String num;

    private Integer sameNum;

    public MissingData(Bit bit, String num, Integer sameNum) {
        this.bit = bit;
        this.num = num;
        this.sameNum = sameNum;
    }

    public Bit getBit() {
        return bit;
    }

    public void setBit(Bit bit) {
        this.bit = bit;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Integer getSameNum() {
        return sameNum;
    }

    public void setSameNum(Integer sameNum) {
        this.sameNum = sameNum;
    }
}
