package cn.tommyyang.calctool.utils;

/**
 * Created by TommyYang on 2018/2/8.
 */
public class IntegerUtils {

    public static Integer[] strToArray(String integer){
        Integer[] arrs;
        String intStr = integer.toString();
        if(intStr.length() == 5){
            arrs = new Integer[5];
            arrs[4] = Integer.parseInt(intStr.substring(0,1));
            arrs[3] = Integer.parseInt(intStr.substring(1,2));
            arrs[2] = Integer.parseInt(intStr.substring(2,3));
            arrs[1] = Integer.parseInt(intStr.substring(3,4));
            arrs[0] = Integer.parseInt(intStr.substring(4));
            return arrs;
        }else {
            return new Integer[]{0,0};
        }
    }

    public static Integer[] integerStrToArray(String intStr){
        String[] intStrArr = intStr.split(Constants.COMMA);
        Integer[] intArr = new Integer[intStrArr.length];
        Integer i = 0;
        for (String str: intStrArr) {
            intArr[i] = Integer.valueOf(str.trim());
            i++;
        }
        return intArr;
    }

    public static void main(String[] args){
        Integer[] arrs = strToArray("01982");
        for (Integer i: arrs) {
            System.out.println(i);
        }
    }

}
