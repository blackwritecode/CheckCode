<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>checkcode</title>
</head>
<body>
<form action="/CheckCode/servlet/LoginServlet" method="get">
验证码：<input type="text" name="checkcode" /><img alt="验证码" src="/CheckCode/servlet/ImageServlet" id="imageCode">
<a href="javascript:reloadCode();">看不清楚</a><br>
<input type="submit" name="提交" value="提交">
</form>


<script type="text/javascript">
	function reloadCode() {
		var time = new Date().getTime();
		document.getElementById("imageCode").src="/CheckCode/servlet/ImageServlet?d=" + time;
	}
</script>
</body>
</html>