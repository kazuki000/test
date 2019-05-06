<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="text/css"/>
	<meta http-equiv="Content-Script-Type" content="text/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta http-equiv="keywords" content=""/>
	<meta http-equiv="description" content=""/>
	<title>itemCreateComfirm.jsp</title>

	<style type="text/css">

	body{
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing;1px;
		font-family:Verdana,Helvetica,sans-serif;
		font-size:12px;
		color:#333;
		background:#fff;
	}

	table{
		text-align:center;
		margin:0 auto;
	}

	#top{
		width:780px;
		margin:30px auto;
		border:1px solid black;
	}

	#header{
		width:100%;
		height:80px;
		background-color:black;
	}

	#main{
		width:100%;
		height:500px;
		text-align:center;
	}

	#footer{
		width:100%;
		height:80px;
		border:1px solid black;
	}

	</style>
</head>
<body>
	<div id="header">
			<div id="pr">
			</div>
	</div>
	<div id="main">
			<div id="top">
					<p>itemCreateConfirm</p>
			</div>
			<div>
				<s:form action="ItemCreateCompleteAction">
				<table>
						<tr>
							<td>アイテムの名前</td>
							<td><s:property value="session.itemName"/></td>
						</tr>
						<tr>
							<td>値段</td>
							<td>
								<s:property value="session.itemPrice"/>
											<span>円</span>
							</td>
						</tr>
						<tr>
							<td>数</td>
							<td>
								<s:property value="session.itemStock"/>
											<span>個</span>
							</td>
						</tr>
						<tr>
							<td><s:submit value="完了"/></td>
						</tr>
					</table>
				</s:form>
			</div>
	</div>
	<div id="footer">
			<div id="pr">
			</div>
	</div>


</body>
</html>