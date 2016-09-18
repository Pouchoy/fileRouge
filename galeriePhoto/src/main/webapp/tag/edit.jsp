<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edition de tag</title>
	</head>
	
	<body>
		<h2>Edition de tag</h2>
		
		<s:form action="tag/save" method="post" >
			<s:hidden name="id" />
			<s:textfield name="libelle" label="Libellé du tag" />
			<s:submit value="sauvegarder" />
		</s:form>
	
	</body>
	
</html>