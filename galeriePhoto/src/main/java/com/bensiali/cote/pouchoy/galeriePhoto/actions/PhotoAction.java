package com.bensiali.cote.pouchoy.galeriePhoto.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bensiali.cote.pouchoy.galeriePhoto.metier.Photo;
import com.bensiali.cote.pouchoy.galeriePhoto.repositories.PhotoRepository;
import com.opensymphony.xwork2.ActionSupport;

public class PhotoAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	
	private static Logger log = LogManager.getLogger( ActionSupport.class ); 
	
	@Autowired
	private PhotoRepository photoRepository;
	public PhotoRepository getPhotoRepository() { return photoRepository; }
	public void setPhotoRepository( PhotoRepository photoRepository) { this.photoRepository = photoRepository; }

	private Iterable<Photo> photos;
	public Iterable<Photo> getPhotos() {
		return this.photos;
	}
	
	private String searchTerm;
	public String getSearchTerm() { return this.searchTerm; }
	public void setSearchTerm(String searchTerm) { this.searchTerm = searchTerm; }
	
	//  GET -> galerie
	public String findAll() {
		
		log.info( this.getClass().getSimpleName() + ".findAll()");
		
		
		this.photos = this.photoRepository.findAll(); 
		
		for( Photo g : this.photos )
			log.info( "\t" + g );
		
		
		return SUCCESS;
	}
	
	//  GET -> galerie/search/:searchterm
	public String searchByNom() {
		
		log.info( this.getClass().getSimpleName() + ".searchByNom(" + this.getSearchTerm() + ")");
		
		this.photos = this.photoRepository.findByNomContaining( this.getSearchTerm() );
		
		for( Photo g : this.photos )
			log.info( "\t" + g );
		
		return SUCCESS;
	}

}
