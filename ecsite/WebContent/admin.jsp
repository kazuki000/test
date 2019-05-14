<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Style-Type" content="style/css"/>
	<meta http-equiv="Content-Script-Type" content="style/javascript"/>
	<meta http-equiv="imagetoolbar" content="no"/>
	<meta http-equiv="description" content=""/>
	<meta http-equiv="keywords" content=""/>
	<title>Admin</title>

	<style type="text/css">

	body{
		margin:0;
		padding:0;
		line-height:1.6;
		letter-spacing:1px;
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
		border:1px solid #333;
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
		font-size:30px;

	}

	#left{float:left;
		width:50%;
		height:500px;
		text-align:center;


	}

	#right{float:right;
		width:50%;
		height:500px;
		text-align:center;

	}

	#footer{
		width:100%;
		height:80px;
		background-color:black;
		clear:both;
	}




	</style>
</head>
<body>
	<div id="header">
	       <div id="pr">
	       </div>
	      >
	</div>
	<div id="main">
	 <div id="top">
					<p>管理者画面</p>
			</div>

			<div id="left">
						<p>商品</p>
				<s:form action="ItemCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				<s:form action="ItemListAction">
					<s:submit value="   一覧   "/>
				</s:form>
			</div>

			<div id="right">
					<p>ユーザー</p>
				<s:form action="UserCreateAction">
					<s:submit value="新規登録"/>
				</s:form>
				<s:form action="UserListAction">
					<s:submit value="   一覧   "/>
				</s:form>
			</div>
			<p>ログアウトする場合は
				<a href='<s:url action="LoginAction"/>'>こちら</a></p>

		</div>
		<div id="footer">
				<div id="pr">
				</div>
		</div>



</body>
</html>