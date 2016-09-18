 * ----------------------------------------------------------------------------------------------------
 * ---------- Configuration ---------------------------------------------------------------------------
 * ----------------------------------------------------------------------------------------------------
 *
 * BDD créer la BDD: 
 *
 *		"base_galeriePhoto"
 * 
 * ----------------------------------------------------------------------------------------------------
 *
 * FileStorageManager:
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
 * Créer le répertoire "C:\stockage" en local s'il n'existe pas( comme définit dans le fichier "applicationContext.xml" )
 * 
 * ----------------------------------------------------------------------------------------------------
 *
 * Automatiser les DAO:
 *
 *
 * Ajouter dans "pom.xml":
 * <!-- spring data jpa permet d'automatiser les DAO -->
 * <dependency>
 * 		<groupId>org.springframework.data</groupId>
 * 		<artifactId>spring-data-jpa</artifactId>
 * 		<version>1.9.4.RELEASE</version>
 * </dependency>
 *
 *
 *
 *
 * "applicationContext.xml":
 * Ajouter à "<beans"
 *
 *		L'attribut: xmlns:jpa="http://www.springframework.org/schema/data/jpa"
 *
 *		Dans l'attribut "xsi:schemaLocation" les lignes:
 *			http://www.springframework.org/schema/data/jpa
 *			http://www.springframework.org/schema/data/jpa/spring-jpa.xsd
 *
 *	Puis ajouter dans les beans:
 *
 *			<!-- indique à spring où chercher les repository/DAO spring-data à générer -->
 *			<jpa:repositories base-package="com.bensiali.cote.pouchoy.galeriePhoto.repositories"></jpa:repositories>
 *
 *
 *	Ajouter à web.xml le filtre:
 *
 *		<!-- ce filtre autorise les requettes ajax cross domaine -->
  <filter>
  	<filter-name>CorsFilter</filter-name>
  	<filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
  	<init-param>
  		<param-name>cors.allowed.origins</param-name>
  		<param-value>http://localhost, http://localhost:8080</param-value>
  	</init-param>
</filter>
 * 
 * ----------------------------------------------------------------------------------------------------