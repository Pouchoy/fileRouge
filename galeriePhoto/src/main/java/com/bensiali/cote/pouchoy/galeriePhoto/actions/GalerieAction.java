package com.bensiali.cote.pouchoy.galeriePhoto.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bensiali.cote.pouchoy.galeriePhoto.metier.Galerie;
import com.bensiali.cote.pouchoy.galeriePhoto.repositories.GalerieRepository;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author Bertrand COTE
 *
 */
public class GalerieAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LogManager.getLogger( ActionSupport.class ); 
	
	@Autowired
	private GalerieRepository galerieRepository;
	public GalerieRepository getGalerieRepository() { return galerieRepository; }
	public void setGalerieRepository( GalerieRepository galerieRepository) { this.galerieRepository = galerieRepository; }

	private Iterable<Galerie> galeries;
	public Iterable<Galerie> getProduits() {
		return this.galeries;
	}
	
	private String searchTerm;
	public String getSearchTerm() { return this.searchTerm; }
	public void setSearchTerm(String searchTerm) { this.searchTerm = searchTerm; }
	
	//  GET -> galerie
	public String findAll() {
		
		log.info( "GalerieAction.findAll()");
		
		
		this.galeries = this.galerieRepository.findAll(); 
		
		for( Galerie g : this.galeries )
			log.info( "\t" + g );
		
		
		return SUCCESS;
	}
	
	//  GET -> galerie/search/:searchterm
	public String searchByTitre() {
		
		log.info( "GalerieAction.searchByTitre(" + this.getSearchTerm() + ")");
		
		this.galeries = this.galerieRepository.findByTitreContaining( this.getSearchTerm() );
		
		for( Galerie g : this.galeries )
			log.info( "\t" + g );
		
		return SUCCESS;
	}

}
