<%--
  Created by IntelliJ IDEA.
  User: tommyyang
  Date: 2018/2/24
  Time: 18:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预警数据</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/EasyUI/themes/icon.css" rel="stylesheet" />
    <link href="/EasyUI/themes/default/easyui.css" rel="stylesheet" />
    <link href="/css/common.css" rel="stylesheet">
    <script src="/EasyUI/jquery.min.js"></script>
    <script src="/EasyUI/jquery.easyui.min.js"></script>
    <script src="/EasyUI/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table id="dg">
</table>
</body>
</html>

<script type="text/javascript">
    $(document).ready(function () {
        $('#dg').datagrid({
            loadMsg: "数据加载中...",
            //fit : true, //设置了分页不显示
            border: true,
            singleSelect: true,
            fitColumns: true,
            pagination: true,
            url: '/calc/getwarningdata.do',
            method: 'GET',
            columns: [[{
                field: 'bit',
                title: '位置',
                width: 40
            }, {
                field: 'num',
                title: '数值',
                width: 40
            }, {
                field: 'times',
                title: '未出现的期数',
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


    });
</script>
