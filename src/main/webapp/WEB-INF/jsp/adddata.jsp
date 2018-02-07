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
    <link href="/EasyUI/themes/icon.css" rel="stylesheet"/>
    <link href="/EasyUI/themes/default/easyui.css" rel="stylesheet"/>
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
        <input class="easyui-textbox" id="qihao" style="width:100%;height:32px">
    </div>
    <div style="margin-bottom:20px">
        <div>开奖结果</div>
        <input class="easyui-textbox" id="res" style="width:100%;height:32px">
    </div>
    <div>
        <a href="#" id="add" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">添加</a>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    $(document).ready(
        function () {
            $("#add").click(function () {
                if ($("#qihao").val() == "") {
                    $.alert("期号不能为空");
                    return;
                }
                if ($("#res").val() == "") {
                    $.alert("开奖结果不能为空")
                    return;
                }
                $.ajax(
                    {
                        url:"/calc/adddata.do",
                        type:'POST',
                        data:{qihao:$("#qihao").val(), res:$("#res").val()},
                        dataType:'json',
                        success:function (data) {
                            if(data==1){
                                $.messager.alert('提示','添加成功!','info');
                            }else if(data==2){
                                $.messager.alert('提示','参数格式有问题，检查后再试!','warning');
                            }else {
                                $.messager.alert('提示','内部错误，联系管理员!','error');
                            }
                        }
                    }
                );
            });
        }
    );

</script>
