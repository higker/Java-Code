<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
	<h1>注册页面</h1>
	<form>
		姓 名:<input type="text">
		密 码:<input type="password">
		<p>性 别:<input type="radio" name="sex" value="male">男
<input type="radio" name="sex" value="female">女</p>
		<p>血 型:<input type="radio" name="sex" value="male">A
<input type="radio" name="sex" value="female">B
<input type="radio" name="sex" value="female">O
<input type="radio" name="sex" value="female">AB</p>
		<p>城 市:<select name="cars">
<option value="volvo">纽约</option>
<option value="saab">巴黎</option>
<option value="fiat" selected>洛杉矶</option>
<option value="audi">首尔</option>
<option value="audi">东京</option>
</select>
</p>
<p>
介 绍:
<textarea rows="8" cols="60"></textarea>
</p>
<p>
浏览文件:
<input type="file">
</p>
<button type="submit">提 交</button>
	</form>
</body>
</html>