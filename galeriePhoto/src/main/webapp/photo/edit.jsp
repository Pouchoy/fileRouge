
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edit photo</title>
	</head>
	<body>
		<h2>Edition photo</h2>
		<s:form action="save" method="post">
			<s:hidden name="id" />
			<s:textfield name="nom" label="Nom de la photo" />
			<s:textfield name="description" label="Description de la photo" />
			<s:submit value="sauvegarder" />
		</s:form>
	</body>
</html>