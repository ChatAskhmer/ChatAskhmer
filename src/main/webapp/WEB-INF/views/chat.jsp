<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WebSockets Chat App</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">

<link href='${pageContext.request.contextPath}/resources/css/longdy_style.css' media='screen' rel='stylesheet' type='text/css'/>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,300,700' rel='stylesheet' type='text/css'>
	
<script src='${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js' type='text/javascript'></script>
<script src='${pageContext.request.contextPath}/resources/js/main.js' type='text/javascript'></script>

</head>
<body>
<div class="body_container">

		<div id="header">
			<h1>Android WebSockets Chat Application</h1>
			<p class='online_count'>
				<b>23</b> people online right now
			</p>
		</div>

		<div id="prompt_name_container" class="box_shadow">
			<p>Enter your name</p>
			<form id="form_submit" method="post">
				<input type="text" id="input_name" /> <input type="submit"
					value="JOIN" id="btn_join">
			</form>
		</div>

		<div id="message_container" class="box_shadow">

			<ul id="messages">
			</ul>


			<div id="input_message_container">
				<form id="form_send_message" method="post" action="#">
					<input type="text" id="input_message"
						placeholder="Type your message here..." /> 
						<input type="submit"
						id="btn_send" onclick="send();" value="Send" />
					<div class="clear"></div>
				</form>
			</div>
			<div>

				<input type="button" onclick="closeSocket();"
					value="Leave Chat Room" id="btn_close" />
			</div>

		</div>

	</div>
</body>
</html>