package cn.tommyyang.calctool.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TommyYang on 2018/2/8.
 */
public class CalcUtils {

    /**
     *
     * 该map为初始化map，第一层Integer:0-4分别表示 个(0)十(1)百(2)千(3)万(4)
     * 里面的map，键表示0-9 值为每个数字出现的次数
     * 该map为最后存储数据的数据结构
     *
     * */
    public static Map<Integer, Map<Integer, Integer>> getMap() {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            Map<Integer, Integer> dataMap = new HashMap<>();
            for (int j = 0; j < 10; j++){
                dataMap.put(j , 0);
            }
            map.put(i, dataMap);
        }
        return map;
    }

    public static Integer getAvg(Integer qishu, Integer weishu) {
        return qishu / 10 * weishu;
    }

}
