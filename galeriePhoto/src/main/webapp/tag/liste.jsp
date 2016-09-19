<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Liste des tags</title>
	</head>
	<body>
		<div>
			<h2>Liste des tags</h2>
			
			<table border="1">
			
				<tr>
					<th>ID</th>
					<th>Libelle</th>
					<th>Actions</th>
				</tr>
				
				<s:iterator value="tags">
				<tr>
					<td><s:property value="id" /></td>
					<td><s:property value="libelle" /></td>
					<td>
						<s:a action="tag/edit/%{id}">Edition</s:a>
						<s:a action="tag/remove/%{id}" onclick="return confirm('Etes-vous sur?');">Suppression</s:a>
					</td>
				</tr>
				</s:iterator>
				
			</table>
			
			<s:a action="tag/create">Nouveau tag</s:a>
		</div>
	
	</body>
</html>