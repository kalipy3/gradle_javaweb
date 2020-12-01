<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">
        window.onload = function() {
            var btn = document.getElementById("subId");
            btn.onclick = function() {
            //将按钮变灰,但是它会让表单提交失效
            this.disabled = true;
            //手动提交表单
            var formEle = document.getElementsByTagName("form")[0];
            formEle.submit();
            };
        };
</script>

<form action="UserServlet_FormReSubmit" method="post">
    用户名：
    <input type="text" name="username">
    <input type="submit" value="注册" id="subId">
</form>
