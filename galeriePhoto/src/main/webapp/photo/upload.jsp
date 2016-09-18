<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Upload photo</title>
	</head>
	
	<body>
		<h2>Upload photo</h2>
			<s:form action="photo/save" method="post" enctype="multipart/form-data">
			<s:textfield name="nom" label="Nom photo" />
			<s:textfield name="description" label="Description photo" />
			<s:file name="image" label="fichier image"/>
			<s:submit value="uploader" />
		</s:form>
	</body>
	
</html>