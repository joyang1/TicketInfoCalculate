package cn.tommyyang.calctool.utils;

/**
 * Created by TommyYang on 2018/2/8.
 */
public class IntegerUtils {

    public static Integer[] integerToArray(Integer integer){
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

    public static void main(String[] args){
        Integer[] arrs = integerToArray(19802);
        for (Integer i: arrs) {
            System.out.println(i);
        }
    }

}
