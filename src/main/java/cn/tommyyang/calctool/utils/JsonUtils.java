package cn.tommyyang.calctool.utils;

import cn.tommyyang.calctool.model.Data;
import cn.tommyyang.calctool.model.ResultData;

import java.util.List;

/**
 * Created by TommyYang on 2017/11/23.
 */
public class JsonUtils {
    /*
     * 获得数据信息的json数据
     */
    public static String getDataJson(List<Data> list, Integer pageNumber, Integer pageSize) {
        String json = "";
        int total = 0;// 记录总数
        total = list.size();
        json += "{\"total\":\"" + total + "\",\"rows\":[";
        int totals = (pageNumber * pageSize) <= total ? (pageNumber * pageSize)
                : total;
        int i = (pageNumber - 1) * pageSize;
        for (int j = i; j < totals; j++) {
            Data data = list.get(j);
            if(!data.getLow()){
                continue;
            }
            json += "{\"qihao\":\"" + data.getQihao() + "\",\"res\":\"" + data.getRes() + "\",\"islow\":\"是\"},";
        }
        json = json.substring(0, json.length() - 1);
        json += "]}";
        return json;
    }


    /*
     * 获得返回数据信息的json数据
     */
    public static String getResultDataJson(List<ResultData> list, Integer pageNumber, Integer pageSize) {
        String json = "";
        int total;// 记录总数
        total = list.size();
        json += "{\"total\":\"" + total + "\",\"rows\":[";
        int totals = (pageNumber * pageSize) <= total ? (pageNumber * pageSize)
                : total;
        int i = (pageNumber - 1) * pageSize;
        for (int j = i; j < totals; j++) {
            ResultData resultData = list.get(j);
            json += "{\"res\":\"" + resultData.getCombine() + "\",\"avg\":\"" + resultData.getAvg() + "\",\"islow\":\"是\"},";
        }
        if(total > 0){
            json = json.substring(0, json.length() - 1);
        }
        json += "]}";
        return json;
    }


    /**
     * JSON字符串特殊字符处理，比如：“\A1;1300”
     * @param s
     * @return String
     */
    public static String stringtoJson(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch (c){
//             case '\"':
//                 sb.append("\\\"");
//                 break;
                case '"':
                    sb.append("'");break;
//             case '\\':
//                 sb.append("\\\\");
//                 break;
//             case '/':
//                 sb.append("\\/");
//                 break;
//             case '\b':
//                 sb.append("\\b");
//                 break;
//             case '\f':
//                 sb.append("\\f");
//                 break;
//             case '\n':
//                 sb.append("\\n");
//                 break;
//             case '\r':
//                 sb.append("\\r");
//                 break;
//             case '\t':
//                 sb.append("\\t");
//                 break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();
    }

}
