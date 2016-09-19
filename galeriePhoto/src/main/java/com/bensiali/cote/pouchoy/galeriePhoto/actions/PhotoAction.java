package com.bensiali.cote.pouchoy.galeriePhoto.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.bensiali.cote.pouchoy.galeriePhoto.metier.Galerie;
import com.bensiali.cote.pouchoy.galeriePhoto.metier.Photo;
import com.bensiali.cote.pouchoy.galeriePhoto.metier.Tag;
import com.bensiali.cote.pouchoy.galeriePhoto.repositories.PhotoRepository;
import com.bensiali.cote.pouchoy.galeriePhoto.repositories.PhotoRepositoryInterface;
import com.opensymphony.xwork2.ActionSupport;

public class PhotoAction extends ActionSupport  {
	
	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(Photo.class); 

	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() { return em; }
	public void setEm(EntityManager em) { this.em = em; }
	
	private PhotoRepositoryInterface photoRepository;
	private int photoId;
	private String nom;
	private String description;
	
	
	public void setPhotoRepository( PhotoRepositoryInterface photoRepository ) { this.photoRepository = photoRepository; }
	
	public String getNom() { return nom; }
	public void setNom( String nom ) { this.nom = nom; }
	
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	public int getPhotoId() {return photoId;}
	public void setPhotoId(int photoId) {this.photoId = photoId;}
	
	/*
	 *  sert a interagir avec l'upload de fichier en provenance d'un champ de type File
	 * 
	 */
	// le champs file va s'appeler image
	private File image; // le fichier temporaire uploadé
	private String imageContentType; // type du fichier uploadé
	private String imageFileName; // le nom du fichier original
	private Galerie galerie;
	private Set<Tag> tags;
	private List<Photo> photos;
	
	private List<Galerie> allGaleries;
	private List<Tag> allTags;
	
	
	public List<Galerie> getAllGaleries() {
		this.allGaleries = em.createQuery("FROM Galerie", Galerie.class).getResultList();
		
		log.info( PhotoRepository.class.getName() + "getAllGaleries()" );
		for( Galerie g : this.allGaleries )
			log.info( "\t ==========" + g );
		
		return allGaleries;
		}
	public void setAllGaleries( List<Galerie> allGaleries ) {
		log.info( PhotoRepository.class.getName() + "setAllGaleries()" );
		this.allGaleries = allGaleries; }

	
	public List<Tag> getAllTags() {
		this.allTags = em.createQuery("FROM Tag", Tag.class).getResultList();
		
		log.info( PhotoRepository.class.getName() + "getAllTags()" );
		for( Tag g : this.allTags )
			log.info( "\t========== " + g );
		
		return this.allTags;
	}
	public void setAllTags( List<Tag> allTags ) { 
		log.info( PhotoRepository.class.getName() + "setAllTags()" );
		this.allTags = allTags; 
	}
	
	
	public void setImage(File image) {this.image = image;}

	public String getImageContentType() {return imageContentType;}
	public void setImageContentType(String imageContentType) {this.imageContentType = imageContentType;}

	public String getImageFileName() {return imageFileName;}
	public void setImageFileName(String imageFileName) {this.imageFileName = imageFileName;}

	public Galerie getGalerie() {return this.galerie;}
	public void setGalerie( Galerie galerie ) {this.galerie = galerie;}

	public Set<Tag> getTags() {return this.tags;}
	public void setTags( Set<Tag> tags ) {this.tags = tags;}
	
	public List<Photo> getPhotos() { return photos; }
	
	

	// l'objet renvoyant les données binaire de l'image
	private InputStream imageStream;
	public InputStream getImageStream() { return imageStream; }
	
	public String findAll() {
		this.photos = em.createQuery("FROM Photo", Photo.class).getResultList();

		
		log.info( PhotoRepository.class.getName() + "findAll()" );
		for( Photo g : this.photos )
			log.info( "\t========== " + g );
		
		return SUCCESS;
	}
	
	
	
	public String liste() {
		
		log.info(this.photoRepository);
		
		this.photos = this.photoRepository.findAll();
		return SUCCESS;
	}
	
	public String affiche() {
		Photo photo = photoRepository.findById( this.getPhotoId() );
		File f = photoRepository.getPhotoFile( photo );
		this.setImageContentType( photo.getContentType() );
		this.setImageFileName( photo.getFileName() );
		try {
			this.imageStream = new FileInputStream(f);
			return SUCCESS;
		} catch (FileNotFoundException e) {
			log.error(e);
		}
		return "error";
	}
	
	
	public String edit() {
		return SUCCESS;
	}
	
	public String save() {
		
		photoRepository.save( new Photo(0, nom, description, new Date(), imageFileName, imageContentType, galerie, tags ), image);
		return SUCCESS;
	}
	
	
}















