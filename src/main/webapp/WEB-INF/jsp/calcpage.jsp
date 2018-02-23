<%--
  Created by IntelliJ IDEA.
  User: tommyyang
  Date: 2018/2/5
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/EasyUI/themes/icon.css" rel="stylesheet"/>
    <link href="/EasyUI/themes/default/easyui.css" rel="stylesheet"/>
    <link href="/css/common.css" rel="stylesheet">
    <script src="/EasyUI/jquery.min.js"></script>
    <script src="/EasyUI/jquery.easyui.min.js"></script>
    <script src="/EasyUI/locale/easyui-lang-zh_CN.js"></script>
    <title>计算</title>
</head>
<body>
<table>
    <tr>
        <td>开始时间</td>
        <td>
            <input type="text" class="easyui-datebox" id="starttime" , required="required" ,
                   data-options="validType:'md[\'10/11/2012\']'"/>
        </td>
        <td>结束时间</td>
        <td>
            <input type="text" class="easyui-datebox" id="endtime" , required="required" ,
                   data-options="required:true, validType:'md[\'10/11/2012\']'"/>
        </td>
        <td>统计位数</td>
        <td>
            <select id="weishulist" class="easyui-combobox" name="weishu" style="width:60px;">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
            </select>
        </td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <%--<td>低于平均值多少是显示</td>--%>
        <%--<td>--%>
        <%--<select class="easyui-combobox" name="state" style="width:60px;">--%>
        <%--<option value="0">0</option>--%>
        <%--<option value="1">1</option>--%>
        <%--<option value="2">2</option>--%>
        <%--<option value="3">3</option>--%>
        <%--<option value="4">4</option>--%>
        <%--<option value="5">5</option>--%>
        <%--<option value="6">6</option>--%>
        <%--<option value="7">7</option>--%>
        <%--<option value="8">8</option>--%>
        <%--<option value="9">9</option>--%>
        <%--<option value="10">10</option>--%>
        <%--<option value="11">11</option>--%>
        <%--<option value="12">12</option>--%>
        <%--<option value="13">13</option>--%>
        <%--<option value="14">14</option>--%>
        <%--<option value="15">15</option>--%>
        <%--<option value="16">16</option>--%>
        <%--<option value="17">17</option>--%>
        <%--<option value="18">18</option>--%>
        <%--<option value="19">19</option>--%>
        <%--<option value="20">20</option>--%>
        <%--</select>--%>
        <%--</td>--%>
        <td>期数</td>
        <td>
            <select id="qishulist" class="easyui-combobox" name="qishu" style="width:60px;">
                <option value="50">50</option>
                <option value="100">100</option>
                <option value="150">150</option>
                <option value="200">200</option>
            </select>
        </td>
        <td>当前均值：</td>
        <td>
            <label id="avg"></label>
        </td>
        <td>
            自定义均值:
        </td>
        <td><input type="text" id="szavg" value=""/></td>
        <td>
            <a href="#" id="count" class="easyui-linkbutton" iconCls="icon-search">统计区间</a>
        </td>
    </tr>
</table>
<table id="dg">
</table>
</body>
</html>
<script type="text/javascript">
    $(document).ready(function () {
        $('#weishulist').combobox('setValue', '5');
        $('#avg').text(25);
        $('#dg').datagrid({
            loadMsg: "数据加载中...",
            //fit : true, //设置了分页不显示
            border: true,
            singleSelect: true,
            fitColumns: true,
            pagination: true,
            url: '/calc/count.do',
            method: 'POST',
            queryParams: {
                starttime: "2018-2-6", endtime: "2018-2-7",
                weishu: 5, qishu: 50, szavg: 25
            },
            columns: [[{
                field: 'res',
                title: '组合',
                width: 40
            }, {
                field: 'avg',
                title: '均值',
                width: 40
            }, {
                field: 'bit',
                title: '低于均值的位',
                width: 20
            }]]
        });
        //分页
        var pagenum = 10;
        load();

        function load() {
            var p = $('#dg').datagrid('getPager');
            $(p).pagination({
                pageSize: pagenum, //每页显示的记录条数，默认为10
                pageList: [10, 20, 30], //可以设置每页记录条数的列表
                beforePageText: '第', //页数文本框前显示的汉字
                afterPageText: '页    共 {pages} 页',
                displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
                onBeforeRefresh: function (pageNumberNow, pageSizeNow) {
                    pagenum = pageSizeNow;
                    $('#dg').datagrid('reload', null);
                    load();
                }
            });
        }

        $('#count').click(function () {
            var starttime = $('#starttime').datebox('getValue');
            var endtime = $('#endtime').datebox('getValue');
            var weishu = $('#weishulist').combobox('getValue');
            var qishu = $('#qishulist').combobox('getValue');
            var avg = qishu / 10 * weishu;
            var szavg = $('#szavg').val();
            if (szavg == "" || szavg == null) {
                szavg = avg;
            }
            $('#avg').text(avg);
            reloadgrid(starttime, endtime, weishu, qishu, szavg);
        });

        function reloadgrid(starttime, endtime, weishu, qishu, szavg) {
            // 查询参数直接添加在url中
            var url = "/calc/count.do";
            $('#dg').datagrid('options').url = url;
            // 查询参数直接添加在queryParams中
            var queryParams = $('#dg').datagrid('options').queryParams;
            queryParams.starttime = starttime;
            queryParams.endtime = endtime;
            queryParams.weishu = weishu;
            queryParams.qishu = qishu;
            queryParams.szavg = szavg;
            $('#dg').datagrid('options').queryParams = queryParams;
            $("#dg").datagrid('reload', null);
        }
    });
</script>
