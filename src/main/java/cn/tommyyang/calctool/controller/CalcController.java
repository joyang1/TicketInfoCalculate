package cn.tommyyang.calctool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by TommyYang on 2018/2/5.
 */
@Controller
@RequestMapping("calc")
public class CalcController extends BaseController {

    @RequestMapping("/index.do")
    public String index(HttpServletRequest request, HttpServletResponse response){
        return renderString(response, "index");
    }

    @RequestMapping("/gocalc.do")
    public String goCalc(HttpServletRequest request, HttpServletResponse response){
        return renderString(response, "calcpage");
    }

    @RequestMapping("/adddata.do")
    public String adddata(HttpServletRequest request, HttpServletResponse response){
        return renderString(response, "adddata");
    }
}
