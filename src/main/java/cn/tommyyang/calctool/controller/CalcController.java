package cn.tommyyang.calctool.controller;

import cn.tommyyang.model.Data;
import cn.tommyyang.model.responsecode.ResponseCode;
import cn.tommyyang.service.IDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by TommyYang on 2018/2/5.
 */
@Controller
@RequestMapping("calc")
public class CalcController extends BaseController {

    private final static Logger logger = LoggerFactory.getLogger(CalcController.class);
    private IDataService dataService;

    @RequestMapping("/index.do")
    public String index(HttpServletRequest request, HttpServletResponse response){
        return renderString(response, "index");
    }

    @RequestMapping("/gocalc.do")
    public String goCalc(HttpServletRequest request, HttpServletResponse response){
        return renderString(response, "calcpage");
    }

    @RequestMapping("/goadddata.do")
    public String goAdddata(HttpServletRequest request, HttpServletResponse response){
        return renderString(response, "adddata");
    }

    @RequestMapping("/adddata.do")
    @ResponseBody
    public Integer adddata(HttpServletRequest request, HttpServletResponse response,
                          @RequestParam("qihao") String qihao,
                          @RequestParam("res") String res){
        try {
            Long qihaoLong = Long.parseLong(qihao);
            Integer resInt = Integer.parseInt(res);
            Boolean flag = dataService.insertOne(new Data(qihaoLong, resInt));
            if(!flag){
                return ResponseCode.ERROR_CODE;
            }
        }catch (NumberFormatException e){
            logger.error("参数异常");
            return ResponseCode.PARAMETER_INVALID_CODE;
        }
        return ResponseCode.SUCCESS_CODE;
    }


}
