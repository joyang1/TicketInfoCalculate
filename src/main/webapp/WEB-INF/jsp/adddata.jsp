<%--
  Created by IntelliJ IDEA.
  User: tommyyang
  Date: 2018/2/5
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/EasyUI/themes/icon.css" rel="stylesheet" />
    <link href="/EasyUI/themes/default/easyui.css" rel="stylesheet" />
    <link href="/css/common.css" rel="stylesheet">
    <script src="/EasyUI/jquery.min.js"></script>
    <script src="/EasyUI/jquery.easyui.min.js"></script>
    <script src="/EasyUI/locale/easyui-lang-zh_CN.js"></script>
    <title>单期添加</title>
</head>
<body>
<div class="easyui-panel" title="单期添加" style="width:400px;padding:30px 60px">
    <div style="margin-bottom:20px">
        <div>下一个期号</div>
        <input class="easyui-textbox" style="width:100%;height:32px">
    </div>
    <div style="margin-bottom:20px">
        <div>开奖结果</div>
        <input class="easyui-textbox" style="width:100%;height:32px">
    </div>
    <div>
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">添加</a>
    </div>
</div>
</body>
</html>
