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
			
			<div>
				<s:hidden name="id" />
				<s:textfield name="nom" label="Nom photo" />
				<s:textfield name="description" label="Description photo" />
			</div>
			
			<div>
				<select name="choixGalerie">
					<s:iterator value="allGaleries">
				    <option value=${galerie.id}>${galerie.titre}</option>
					</s:iterator>
				</select>
			</div>
			
			<div>
				<s:iterator value="allTags">
					<input type="checkbox" name="tag.id" value=${tag.id}>${tag.libelle}</input>
				</s:iterator>
			</div>
			
			<s:file name="image" label="fichier image"/>
			
			<s:submit value="uploader" />
		</s:form>
	</body>
	
</html>