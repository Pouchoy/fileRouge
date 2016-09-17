BDD créer la BDD: 
	base_galeriePhoto




 * FileStorageManager:
 * ----------------------------------------------------------------------------------------------------
 * ---------- Configuration ---------------------------------------------------------------------------
 * ----------------------------------------------------------------------------------------------------
 * 
 * 
 * Ajouter dans "applicationContext.xml":
 * 
 * 		<bean id="fileStorageManager"
 * 			  class="com.bensiali.cote.pouchoy.galeriePhoto.utils.FileStorageManager">
 * 			<property name="storageRoot"  value="C:\stockage"/>
 * 		</bean>
 * 
 * 
 * Ajouter dans "pom.xml"
 * 
 * 		<dependency>
 * 			<groupId>commons-codec</groupId>
 * 			<artifactId>commons-codec</artifactId>
 * 			<version>1.10</version>
 * 		</dependency>
 * 
 * 
 * Créer le répertoire "C:\stockage" en local s'il n'existe pas
 * 
 * ----------------------------------------------------------------------------------------------------