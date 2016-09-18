package com.bensiali.cote.pouchoy.galeriePhoto.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.bensiali.cote.pouchoy.galeriePhoto.metier.Galerie;
import com.bensiali.cote.pouchoy.galeriePhoto.repositories.GalerieRepository;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author Bertrand COTE
 *
 */
public class GalerieAction extends ActionSupport  implements ModelDriven<Galerie>{
	
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger( ActionSupport.class ); 
	
	@Autowired
	private GalerieRepository galerieRepository;
	private Iterable<Galerie> galeries;
	private String searchTerm;
	private Galerie model;
	
	// =====================================================================
	// ========== Getters et setters =======================================
	// =====================================================================
	
	public GalerieRepository getGalerieRepository() { return galerieRepository; }
	public void setGalerieRepository( GalerieRepository galerieRepository) { this.galerieRepository = galerieRepository; }

	public Iterable<Galerie> getGaleries() { return this.galeries; }
	public void setGalerie( Galerie model ) { this.model = model; }
	
	public String getSearchTerm() { return this.searchTerm; }
	public void setSearchTerm(String searchTerm) { this.searchTerm = searchTerm; }
	
	/**
	 * Appelé automatiquement par struts2 car ici en ModelDriven architecture
	 */
	@Override
	public Galerie getModel() {
		if( this.model == null )
			this.model = new Galerie();
		return this.model;
	}
	
	// =====================================================================
	// ========== Actions ==================================================
	// =====================================================================
	
	// ********** JSON **********
	
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
	
	// ********** CRUD **********
	

	public String liste() {
		
		log.info( this.getClass().getName() + ": appel de 'String index()'");
		
		this.galeries = this.galerieRepository.findAll();
		
		return SUCCESS;
	}
	
	public String edit() {
		log.info( this.getClass().getName() + ": appel de 'String edit()'");
		
		Galerie galerie = this.galerieRepository.findOne( this.getModel().getId() );
		if( galerieRepository == null )
			return "notFound";
		
		this.getModel().setTitre( galerie.getTitre() );
		
		return SUCCESS;
	}

	
	public String save() {
		
		log.info( this.getClass().getName() + ": appel de 'String save()'");
		
		Galerie galerie = this.getModel();
		galerie = this.galerieRepository.save( galerie );
		
		return SUCCESS;
	}
	
	public String create() {
		log.info( this.getClass().getName() + ": appel de 'String create()'");
		
		return SUCCESS;
	}
	
	public String remove() {
		log.info( this.getClass().getName() + ": appel de 'String remove()'");
		
		Galerie galerie = this.getModel();
		this.galerieRepository.delete( galerie.getId() );
		
		return SUCCESS;
	}

}














