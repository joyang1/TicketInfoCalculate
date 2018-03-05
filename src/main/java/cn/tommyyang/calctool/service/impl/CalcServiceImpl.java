package cn.tommyyang.calctool.service.impl;

import cn.tommyyang.calctool.model.Bit;
import cn.tommyyang.calctool.model.Data;
import cn.tommyyang.calctool.model.WarningData;
import cn.tommyyang.calctool.service.ICalcService;
import cn.tommyyang.calctool.service.IDataService;
import cn.tommyyang.calctool.utils.IntegerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by TommyYang on 2018/3/5.
 */
@Service
public class CalcServiceImpl implements ICalcService {

    @Autowired
    private IDataService dataService;

    @Override
    public List<WarningData> getWarningDataList() {
        List<Data> dataList = dataService.getAll();
        List<WarningData> warningDataList = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Integer allQS = dataList.size();
        for (Bit bit: Bit.values()) {
            Map<Integer, Integer> map1 = new HashMap<>();
            for(int i=0; i<10; i++){
                map1.put(i, allQS);
            }
            map.put(bit.getBit(), map1);
        }

        Integer qstimes = 0;
        for (Data data : dataList) {
            Integer[] resArr = IntegerUtils.strToArray(data.getRes());
            qstimes++;
            Integer pos = 0;
            for (Integer num : resArr) {
                Integer times = map.get(pos).get(num);
                if(qstimes != times && times == allQS){
                    map.get(pos).put(num, qstimes);
                }
                pos++;
            }
        }

        for (Integer bitKey: map.keySet()) {
            Map<Integer, Integer> numMap = map.get(bitKey);
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(numMap.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {

                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            for (Map.Entry<Integer, Integer> entry : list) {
                WarningData warningData = new WarningData(Bit.get(bitKey), entry.getKey(), entry.getValue());
                warningDataList.add(warningData);
            }
        }
        return warningDataList;
    }

    @Override
    public void warnData() {

    }
}
