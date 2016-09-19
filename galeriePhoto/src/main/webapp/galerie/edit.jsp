<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Edition de galerie</title>
	</head>
	
	<body>
		<h2>Edition de galerie</h2>
		
		<s:form action="galerie/save" method="post" >
			<s:hidden name="id" />
			<s:textfield name="titre" label="Titre de la galerie" />
			<s:submit value="sauvegarder" />
		</s:form>
	
	</body>
	
</html>