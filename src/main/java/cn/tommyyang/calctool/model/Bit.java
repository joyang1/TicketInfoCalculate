package cn.tommyyang.calctool.model;

/**
 * Created by TommyYang on 2018/2/23.
 */
public enum Bit {

    GeiWei(0, "个位"),
    ShiWei(1, "十位"),
    BaiWei(2, "百位"),
    QianWei(3, "千位"),
    WanWei(4, "万位");

    private Integer bit;

    private String name;

    Bit(Integer bit, String name) {
        this.bit = bit;
        this.name = name;
    }

    public Integer getBit() {
        return bit;
    }

    public void setBit(Integer bit) {
        this.bit = bit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Bit get(Integer bit){
        for (Bit b : Bit.values()) {
            if(b.getBit() == bit){
                return b;
            }
        }
        return null;
    }
}
