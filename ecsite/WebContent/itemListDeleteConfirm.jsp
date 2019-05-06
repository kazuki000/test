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
	<meta http-equiv="description" content=""/>
	<meta http-equiv="keywords" content=""/>
	 <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<title>Insert title here</title>

	<style type="text/css">

	body{
		margin:0;
		padding:0;
		letter-spacing:1px;
		line-height:1.6;
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
		height:480px;
		text-align:center;


	}

	#footer{
		width:100%;
		height:80px;
		background-color:black;
	}




	}





	}

	</style>
	 <script type="text/javascript">
              function submitAction(url){
                       $('form').attr('action',url);
                       $('form').submit();
              }
      </script>
</head>
<body>
	<div id="header">
			<div id="pr">
			</div>
	</div>
	<div id="main">
			<div id="top">
					<p>ItemListDeleteConfirm</p>
			</div>
					<p>すべての商品を削除します。よろしいですか？</p>
			<s:form>

				<td><input type="button" value="OK" onclick="submitAction('ItemListDeleteCompleteAction')"/></td>

				<td><input type="button" value="キャンセル" onclick="submitAction('AdminAction')"/></td>

			</s:form>


		</div>

		<div id="footer">
				<div id="pr">
				</div>
		</div>


</body>
</html>