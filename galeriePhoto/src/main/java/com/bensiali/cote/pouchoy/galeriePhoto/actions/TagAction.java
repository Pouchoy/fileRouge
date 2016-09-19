package com.bensiali.cote.pouchoy.galeriePhoto.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bensiali.cote.pouchoy.galeriePhoto.metier.Galerie;
import com.bensiali.cote.pouchoy.galeriePhoto.metier.Tag;
import com.bensiali.cote.pouchoy.galeriePhoto.repositories.TagRepository;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TagAction  extends ActionSupport implements ModelDriven<Tag> {
	
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger( ActionSupport.class ); 
	
	@Autowired
	private TagRepository tagRepository;
	private Iterable<Tag> tags;
	private String searchTerm;
	private Tag model;
	
	// =====================================================================
	// ========== Getters et setters =======================================
	// =====================================================================
	
	public TagRepository getTagRepository() { return tagRepository; }
	public void setTagRepository( TagRepository tagRepository) { this.tagRepository = tagRepository; }

	public Iterable<Tag> getTags() {
		return this.tags;
	}
	
	public String getSearchTerm() { return this.searchTerm; }
	public void setSearchTerm(String searchTerm) { this.searchTerm = searchTerm; }
	
	/**
	 * Appelé automatiquement par struts2 car ici en ModelDriven architecture
	 */
	@Override
	public Tag getModel() {
		if( this.model == null )
			this.model = new Tag();
		return this.model;
	}
	
	// =====================================================================
	// ========== Actions ==================================================
	// =====================================================================
	
	// ********** JSON **********
	
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
	
	// ********** CRUD **********
	

	public String liste() {
		
		log.info( this.getClass().getName() + ": appel de 'String index()'");
		
		this.tags = this.tagRepository.findAll();
		
		return SUCCESS;
	}
	
	public String edit() {
		log.info( this.getClass().getName() + ": appel de 'String edit()'");
		
		Tag tag = this.tagRepository.findOne( this.getModel().getId() );
		if( tag == null )
			return "notFound";
		
		this.getModel().setLibelle( tag.getLibelle() );
		
		return SUCCESS;
	}

	
	public String save() {
		
		log.info( this.getClass().getName() + ": appel de 'String save()'");
		
		Tag tag = this.getModel();
		tag = this.tagRepository.save( tag );
		
		return SUCCESS;
	}
	
	public String create() {
		log.info( this.getClass().getName() + ": appel de 'String create()'");
		
		return SUCCESS;
	}
	
	public String remove() {
		log.info( this.getClass().getName() + ": appel de 'String remove()'");
		
		Tag tag = this.getModel();
		this.tagRepository.delete( tag.getId() );
		
		return SUCCESS;
	}
	
}



