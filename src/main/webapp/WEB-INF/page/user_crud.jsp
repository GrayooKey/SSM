<%--
  Created by IntelliJ IDEA.
  User: zeng
  Date: 2019/3/20
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户的增删改查</title>
    <script src="/common/js/jquery-2.1.1.min.js"></script>
</head>
<body>

<h1>新增：</h1>
<form action="/user/add">
    ID：<input type="text" name="id"><br>
    Name：<input type="text" name="name"><br>
    <input type="submit" value="提交">
</form>


<h1>删除：</h1>
<form action="/user/deleteById">
    要删除的用户ID：<input type="text" name="id"><br>
    <input type="submit" value="删除">
</form>


<h1>修改：</h1>
<form action="/user/update">
    要修改的用户ID：<input type="text" name="id"><br>
    修改后的用户Name：<input type="text" name="name"><br>
    <input type="submit" value="提交">
</form>


<h1>查询：</h1>
<form id="queryParam" action="">
    要查询的用户ID：<input type="text" name="id"><br>
    <button type="button" onclick="queryById()">查询</button>
    <div id="showUser"></div>
</form>


<h1>用户列表：</h1>
<form action="">
    <button type="button" onclick="queryAll()">刷新列表</button>
    <div id="showUserList"></div>
</form>



<script type="text/javascript">

    $(function(){
        queryAll();
    });

    //根据id查询用户
    function queryById() {
        $.ajax({
            type: "post",
            async: true,
            dataType: "json",
            url: "/user/findById",
            data:$("#queryParam").serialize(),
            success: function (data) {
                /*var user = JSON.parse(data);
                var user = data.parseJSON();
                var user = eval('(' + data + ')');
                var user = jQuery.parseJSON(data);*/
                $("#showUser").html("id：" + data.id + "<br>" + "name：" + data.name + "<br>" + "createDate：" + changeDateFormat(data.createDate.time));
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("系统出错，请检查！");
            }
        });
    }

    //查询用户列表
    function queryAll() {
        $.ajax({
            type: "post",
            async: true,
            dataType: "json",
            url: "/user/findAll",
            success: function (data) {
                var htm = "";
                for(var i in data){
                    htm += data[i].id + "—" + data[i].name + "—" + changeDateFormat(data[i].createDate.time) + "<br>";
                }
                $("#showUserList").html(htm);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("系统出错，请检查！");
            }
        });
    }


    //转换日期格式(时间戳转换为datetime格式 yyyy-MM-dd HH:mm:ss)
    function changeDateFormat(cellval) {
        if (cellval != null) {
            var date = new Date(parseInt(cellval));
            var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
            var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

            var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
            var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
            var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

            return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
        }
    }
</script>
</body>
</html>
