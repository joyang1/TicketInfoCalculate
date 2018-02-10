package cn.tommyyang.calctool.controller;

import cn.tommyyang.calctool.model.Data;
import cn.tommyyang.calctool.model.ResultData;
import cn.tommyyang.calctool.model.responsecode.ResponseCode;
import cn.tommyyang.calctool.service.IDataService;
import cn.tommyyang.calctool.utils.CalcUtils;
import cn.tommyyang.calctool.utils.DateTimeUtils;
import cn.tommyyang.calctool.utils.IntegerUtils;
import cn.tommyyang.calctool.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by TommyYang on 2018/2/5.
 */
@Controller
@RequestMapping("calc")
public class CalcController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(CalcController.class);
    private final static Integer[] initArr = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @Autowired
    private IDataService dataService;

    @RequestMapping("/index.do")
    public String index(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "index");
    }

    @RequestMapping("/gocalc.do")
    public String goCalc(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "calcpage");
    }

    @RequestMapping("/goadddata.do")
    public String goAdddata(HttpServletRequest request, HttpServletResponse response) {
        return renderString(response, "adddata");
    }

    @RequestMapping(value = "/adddata.do", method = RequestMethod.POST)
    @ResponseBody
    public Integer adddata(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam("qihao") String qihao,
                           @RequestParam("res") String res) {
        try {
            Long qihaoLong = Long.parseLong(qihao);
            Integer resInt = Integer.parseInt(res);
            Boolean flag = dataService.insertOne(new Data(qihaoLong, resInt.toString()));
            if (!flag) {
                return ResponseCode.ERROR_CODE;
            }
        } catch (NumberFormatException e) {
            logger.error("参数异常");
            return ResponseCode.PARAMETER_INVALID_CODE;
        }
        return ResponseCode.SUCCESS_CODE;
    }

    @RequestMapping(value = "/count.do", method = RequestMethod.POST)
    @ResponseBody
    public void countInfo(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam("starttime") String startTime, @RequestParam("endtime") String endTime,
                          @RequestParam("qishu") Integer qishu, @RequestParam("weishu") Integer weishu,
                          @RequestParam("szavg") Integer szavg,
                          @RequestParam("page") Integer page, @RequestParam("rows") Integer rows) {
        try {
            List<Data> dataList;
            if (qishu > 0) {
                dataList = dataService.get(qishu);
            } else {
                String startDateStr = DateTimeUtils.dateToStr("yyyyMMdd", DateTimeUtils.strToDate("yyyy-MM-dd", startTime)) + "000";
                String endDateStr = DateTimeUtils.dateToStr("yyyyMMdd", DateTimeUtils.strToDate("yyyy-MM-dd", endTime)) + "999";
                Long startDateLong = Long.parseLong(startDateStr);
                Long endDateLong = Long.parseLong(endDateStr);
                dataList = dataService.get(startDateLong, endDateLong);
            }
            Map<Integer, Map<Integer, Integer>> initMap = CalcUtils.getMap();
            Integer avg = szavg;
            List<String> combineArr = new ArrayList<>();
            CalcUtils.combine(combineArr,0, weishu, initArr);

            for (Data data : dataList) {
                Integer[] resArr = IntegerUtils.strToArray(data.getRes());
                Integer pos = 0;
                for (Integer i : resArr) {
                    Map<Integer, Integer> dataMap = initMap.get(pos);
                    Integer times = dataMap.get(i);
                    dataMap.put(i, times + 1);
                    initMap.put(pos, dataMap);
                    pos++;
                }
            }
            List<ResultData> resultDataList = new ArrayList<>();
            for (String combine : combineArr) {
                Integer[] resArr = IntegerUtils.integerStrToArray(combine);
                Integer pos = 0;
                Integer sum = 0;
                for (Integer i : resArr) {
                    Map<Integer, Integer> dataMap = initMap.get(pos);
                    Integer times = dataMap.get(i);
                    sum = sum + times;
                    pos++;
                }

                if (sum < avg) {
                    ResultData resultData = new ResultData(combine, sum);
                    resultDataList.add(resultData);
                }
            }
            this.writeResponseContent(response, JsonUtils.getResultDataJson(resultDataList, page, rows));
        } catch (ParseException e) {
            logger.error("参数异常:\n", e);
        } catch (NumberFormatException e) {
            logger.error("参数异常:\n", e);
        } catch (IOException e) {
            logger.error("writeResponseContent error : \n", e);
        }
    }

}
