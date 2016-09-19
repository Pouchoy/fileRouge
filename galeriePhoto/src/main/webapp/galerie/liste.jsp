<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Liste des galeries</title>
	</head>
	<body>
		<div>
			<h2>Liste des galeries</h2>
			
			<table border="1">
			
				<tr>
					<th>ID</th>
					<th>Titre</th>
					<th>Date de création</th>
					<th>Actions</th>
				</tr>
				
				<s:iterator value="galeries">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="titre" /></td>
					<td><s:property value="dateCreation" /></td>
					<td>
						<s:a action="galerie/edit/%{id}">Edition</s:a>
						<s:a action="galerie/remove/%{id}" onclick="return confirm('Etes-vous sur?');">Suppression</s:a>
					</td>
				</tr>
				</s:iterator>
				
			</table>
			
			<s:a action="galerie/create">Nouvelle galerie</s:a>
		</div>
	
	</body>
</html>