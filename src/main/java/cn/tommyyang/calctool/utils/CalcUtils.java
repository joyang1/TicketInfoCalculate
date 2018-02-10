package cn.tommyyang.calctool.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TommyYang on 2018/2/8.
 */
public class CalcUtils {
    private static List<Integer> tmpArr = new ArrayList<>();

    /**
     * 该map为初始化map，第一层Integer:0-4分别表示 个(0)十(1)百(2)千(3)万(4)
     * 里面的map，键表示0-9 值为每个数字出现的次数
     * 该map为最后存储数据的数据结构
     */
    public static Map<Integer, Map<Integer, Integer>> getMap() {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            Map<Integer, Integer> dataMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                dataMap.put(j, 0);
            }
            map.put(i, dataMap);
        }
        return map;
    }

    public static Integer getAvg(Integer qishu, Integer weishu) {
        return qishu / 10 * weishu;
    }

    public static void combine(List<String> combineArr, Integer index, Integer k, Integer[] arr) {
        if (k == 1) {
            for (int i = index; i < arr.length; i++) {
                tmpArr.add(arr[i]);
                String str = tmpArr.toString().replace(Constants.Left_Parenthesis, Constants.EMPTY)
                        .replace(Constants.Right_Parenthesis, Constants.EMPTY);
                combineArr.add(str);
                tmpArr.remove((Object) arr[i]);
            }
        } else if (k > 1) {
            for (int i = index; i <= arr.length - k; i++) {
                tmpArr.add(arr[i]);
                combine(combineArr,i + 1, k - 1, arr);
                tmpArr.remove((Object) arr[i]);
            }
        } else {
            return;
        }
    }

    public static List<Integer> getCombineList(List<String> combineArr) {
        List<Integer> combineList = new ArrayList<>();
        for (String item : combineArr) {
            String[] strArr = item.split(Constants.COMMA);
            Integer num = 0;
            for (Integer i = 0; i < strArr.length; i--) {
                if (i == strArr.length - 1) {
                    num += Integer.valueOf(strArr[i]);
                } else {
                    num += ((Double) Math.pow(Integer.valueOf(strArr[i]), strArr.length - 1 - i)).intValue();
                }
            }
            combineList.add(num);
        }
        return combineList;
    }

}
