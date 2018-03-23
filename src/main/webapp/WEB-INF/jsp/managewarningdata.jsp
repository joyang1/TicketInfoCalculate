<%--
  Created by IntelliJ IDEA.
  User: tommyyang
  Date: 2018/3/23
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理预警数据</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/EasyUI/themes/icon.css" rel="stylesheet"/>
    <link href="/EasyUI/themes/default/easyui.css" rel="stylesheet"/>
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
            url: '/calc/getneedwarningdata.do',
            method: 'GET',
            onSelect: function () {
                $('#btn-del').linkbutton('enable');
            },
            onUnselect: function () {
                $('#btn-del').linkbutton('disable');
            },
            columns: [[{
                field: 'id',
                title: '标号',
                width:10,
                hidden:true
            }, {
                field: 'section',
                title: '期号区间',
                width: 40
            }, {
                field: 'res',
                title: '组合',
                width: 30
            }, {
                field: 'avg',
                title: '均值',
                width: 15
            }, {
                field: 'bit',
                title: '低于均值的位',
                width: 15
            }]], toolbar: [{
                iconCls: 'icon-remove',
                id: 'btn-del',
                text: '删除',
                disabled: true,
                handler: function () {
                    var row = $('#dg').datagrid('getSelected');
                    $.ajax({
                        url: "/calc/delneedwarningdata.do",
                        type: "post",
                        dataType: "json",
                        async: false,
                        //传送请求数据
                        data: {
                            "id": row.id
                        },
                        //根据返回值进行状态显示
                        success: function (data) {
                            if (data == "1") {
                                $.messager.alert('我的消息', '删除成功!', '提示');
                            } else {
                                $.messager.alert('我的消息', '删除失败!', '提示');
                            }
                        }
                    });
                    $('#dg').datagrid('reload', null);
                }
            }]
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
