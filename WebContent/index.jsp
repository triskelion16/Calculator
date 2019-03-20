<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kalkulator</title>
</head>
<body>
<jsp:useBean class="application.Calculator" id="object" scope="session"/>
<form action="CalculatorServlet" method="POST">
<table>
  <tr>
    <td colspan="4"><jsp:getProperty property="value1" name="object"/></td>
    <td><input name="btn" type="submit" value="C" /></td>
  </tr>
  <tr>
    <td><input name="btn" type="submit" value="7" /></td>
    <td><input name="btn" type="submit" value="8" /></td>
    <td><input name="btn" type="submit" value="9" /></td>
    <td><input name="btn" type="submit" value="/" /></td>
    <td><input name="btn" type="submit" value="sqrt" /></td>
  </tr>
  <tr>
    <td><input name="btn" type="submit" value="4" /></td>
    <td><input name="btn" type="submit" value="5" /></td>
    <td><input name="btn" type="submit" value="6" /></td>
    <td><input name="btn" type="submit" value="*" /></td>
    <td><input name="btn" type="submit" value="%" /></td>
  </tr>
  <tr>
    <td><input name="btn" type="submit" value="1" /></td>
    <td><input name="btn" type="submit" value="2" /></td>
    <td><input name="btn" type="submit" value="3" /></td>
    <td><input name="btn" type="submit" value="-" /></td>
    <td rowspan="2"><input name="btn" type="submit" value="=" /></td>
  </tr>
  <tr>
    <td><input name="btn" type="submit" value="0" /></td>
    <td><input name="btn" type="submit" value="." /></td>
    <td><input name="btn" type="submit" value="+/-" /></td>
    <td><input name="btn" type="submit" value="+" /></td>
  </tr>
</table>
</form>
</body>
</html>