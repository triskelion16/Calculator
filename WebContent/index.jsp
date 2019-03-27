<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kalkulator</title>

<meta name="viewport" content="width=device-width, initial-scale=0.8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<jsp:useBean class="application.Calculator" id="object" scope="session" />
	
	<form action="CalculatorServlet" method="POST">
		<div class="container">
			<table>
				<tr>
					<td id="display" colspan="4"><jsp:getProperty property="result" name="object" /></td>
							
					<td><input class="operation" id="c" name="btn" type="submit" value="C" /></td>
				</tr>
				<tr>
					<td><input name="btn" type="submit" value="7" /></td>
					<td><input name="btn" type="submit" value="8" /></td>
					<td><input name="btn" type="submit" value="9" /></td>
					<td><input class="operation" name="btn" type="submit" value="/" /></td>
					<td><input class="operation" name="btn" type="submit" value="sqrt" /></td>
				</tr>
				<tr>
					<td><input name="btn" type="submit" value="4" /></td>
					<td><input name="btn" type="submit" value="5" /></td>
					<td><input name="btn" type="submit" value="6" /></td>
					<td><input class="operation" name="btn" type="submit" value="*" /></td>
					<td><input class="operation" name="btn" type="submit" value="%" /></td>
				</tr>
				<tr>
					<td><input name="btn" type="submit" value="1" /></td>
					<td><input name="btn" type="submit" value="2" /></td>
					<td><input name="btn" type="submit" value="3" /></td>
					<td><input class="operation" name="btn" type="submit" value="-" /></td>
					<td rowspan="2"><input class="operation" id="equals" name="btn" type="submit" value="=" /></td>
				</tr>
				<tr>
					<td><input name="btn" type="submit" value="0" /></td>
					<td><input name="btn" type="submit" value="." /></td>
					<td><input name="btn" type="submit" value="+/-" /></td>
					<td><input class="operation" name="btn" type="submit" value="+" /></td>
				</tr>
			</table>
		</div>

	</form>
</body>
</html>