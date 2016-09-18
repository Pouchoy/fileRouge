package com.bensiali.cote.pouchoy.galeriePhoto.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bensiali.cote.pouchoy.galeriePhoto.metier.Tag;
import com.bensiali.cote.pouchoy.galeriePhoto.repositories.TagRepository;
import com.opensymphony.xwork2.ActionSupport;

public class TagAction  extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LogManager.getLogger( ActionSupport.class ); 
	
	@Autowired
	private TagRepository tagRepository;
	public TagRepository getTagRepository() { return tagRepository; }
	public void setTagRepository( TagRepository tagRepository) { this.tagRepository = tagRepository; }

	private Iterable<Tag> tags;
	public Iterable<Tag> getTags() {
		return this.tags;
	}
	
	private String searchTerm;
	public String getSearchTerm() { return this.searchTerm; }
	public void setSearchTerm(String searchTerm) { this.searchTerm = searchTerm; }
	
	//  GET -> galerie
	public String findAll() {
		
		log.info( "GalerieAction.findAll()");
		
		
		this.tags = this.tagRepository.findAll(); 
		
		for( Tag g : this.tags )
			log.info( "\t" + g );
		
		
		return SUCCESS;
	}
	
	//  GET -> galerie/search/:searchterm
	public String searchByLibelle() {
		
		log.info( "GalerieAction.searchByTitre(" + this.getSearchTerm() + ")");
		
		this.tags = this.tagRepository.findByLibelleContaining( this.getSearchTerm() );
		
		for( Tag g : this.tags )
			log.info( "\t" + g );
		
		return SUCCESS;
	}
	
}



