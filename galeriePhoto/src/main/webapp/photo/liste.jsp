<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Liste photos</title>
		<style type="text/css">
		div.imagediv {
			position: relative;
			float: left;
			border: black solid 2px;
		}
		</style>
	</head>
	<body>
		<h2>Liste des photos</h2>
		
		<table border="1">
			<tr>
				<th>Photo</th>
				<th>Nom</th>
				<th>Description</th>
				<th>Date de création</th>
				<th>Actions</th>
			</tr>
			<s:iterator value="photos">
			<tr>
				<td><img src="affiche/<s:property value='id' />" width="150" height="150"/></td>
				<td><s:property value="nom" /></td>
				<td><s:property value="description" /></td>
				<td><s:property value="dateCreation" /></td>
				<td>
					<s:a action="photo/edit/%{id}">Edition</s:a>
					<s:a action="photo/remove/%{id}" onclick="return confirm('Etes-vous sur?');">Suppression</s:a>
				</td>
			</tr>
			</s:iterator>
			
		</table>
		<s:a action="photo/edit">Nouvelle photo</s:a>
	</body>
</html>