<%--
  Created by IntelliJ IDEA.
  User: qiuwei
  Date: 2020/6/20
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>注册-米淘乐 -  手机回收网 | 二手手机交易 | 笔记本回收 | 平板回收</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://v3.bootcss.com/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://v3.bootcss.com/examples/signin/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <%--    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>--%>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script>
        /**
         * 刷新随机验证码
         */
        function IfPhoneCode() {
            console.log("phoneCode");
            //相当于 一张图片
            //浏览器，认为请求路径没变，就认为这是同一张图片，使用缓存！！！
            //欺骗浏览器，告诉它，这是一张新的图片！
            $("#validateCode").attr("src","${pageContext.request.contextPath}/validatecode.jsp?"+Math.random());
        }

    </script>

</head>

<body>

<div class="container">

    <form class="form-signin" action="${pageContext.request.contextPath}/user/register">
        账户:<input type="text" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
        密码:<input type="text" id="inputPassword" class="form-control" placeholder="Password" required>
        号码:<input type="text" id="inputTel" class="form-control" placeholder="Tel" required>
        验证码:<input type="text" class="form-control" placeholder="验证码" name="phoneCode"/>
        <img id="validateCode" onclick="IfPhoneCode" src="${pageContext.request.contextPath}/validatecode.jsp"><br><br>

        <button class="btn btn-lg btn-primary btn-block" type="button" onclick="register()">注册</button>

    </form>

</div> <!-- /container -->

<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
<script src="js/jquery-3.1.1.js"></script>

<script>

    function register() {
        //用户名和密码
        var username = $("#inputUsername").val();
        var password = $("#inputPassword").val();
        var tel = $("#inputTel").val();
        var jsonObj={"userName":username,"userPassword":password,"userTel":tel};

        // 通过ajax将用户和密码传递到controller
        // $.post("user/register",
        //     {"userName":username,"userPassword":password,"userTel":tel},
        //     function (data) {
        //         console.log(data);
        //         if (data.code == 0){
        //             window.location.href=data.obj;
        //         } else {
        //             alert(data.obj);
        //         }
        //     });

        $.ajax({
            url: "user/register",
            contentType:"application/json;charset=utf-8",//必须指定数据类型为application
            type: "post",//请求必须是post
            dataType: "json",
            data: JSON.stringify(jsonObj),
            success: function (data) {
                //当异步请求对象状态发生改变就会执行本方法
                console.log(data);
                if (data.code == 0) {
                    window.location.href=data.obj;
                } else {
                    alert(data.obj);
                }
            }
        });


    }
</script>

</body>
</html>
