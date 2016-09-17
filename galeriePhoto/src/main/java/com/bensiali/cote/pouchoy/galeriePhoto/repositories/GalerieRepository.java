package com.bensiali.cote.pouchoy.galeriePhoto.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bensiali.cote.pouchoy.galeriePhoto.metier.Galerie;

/**
 * Config: Ajouter dans "pom.xml":
 * <!-- spring data jpa permet d'automatiser les DAO -->
 * <dependency>
 * 		<groupId>org.springframework.data</groupId>
 * 		<artifactId>spring-data-jpa</artifactId>
 * 		<version>1.9.4.RELEASE</version>
 * </dependency>
 * 
 * @author Bertrand COTE
 *
 */
public interface GalerieRepository extends PagingAndSortingRepository<Galerie, Integer> {
	
	public Iterable<Galerie> findByTitreContaining( String titre );

}
