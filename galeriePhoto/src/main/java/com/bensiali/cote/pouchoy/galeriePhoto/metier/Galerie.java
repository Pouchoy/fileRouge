package com.bensiali.cote.pouchoy.galeriePhoto.metier;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Gallerie
 * --------
 * id
 * titre
 * dateCreation
 * 
 * Photo n)-----(1 Galerie
 * 
 * @author Bertrand COTE
 *
 */
@Entity
public class Galerie {
	
	private int id;
	private String titre;
	private Date dateCreation;
	private Set<Photo> photos;
	
	@Id
	@GeneratedValue
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getTitre() { return titre; }
	public void setTitre(String titre) { this.titre = titre; }
	
	public Date getDateCreation() { return dateCreation; }
	public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }
	
	@OneToMany(mappedBy="galerie")
	public Set<Photo> getPhotos() { 
		if( this.photos == null )
			this.photos = new HashSet<>();
		return photos; 
	}
	public void setPhotos(Set<Photo> photos) { this.photos = photos; }
	
	public Galerie(){ this( 0, "", null, null); }
	public Galerie(int id, String titre, Date dateCreation, Set<Photo> photos) {
		this.id = id;
		this.titre = titre;
		this.dateCreation = dateCreation;
		this.photos = photos;
	}
	
	@Override
	public String toString() {
		return "Galerie [id=" + id + ", titre=" + titre + ", dateCreation=" + dateCreation + "]";
	}

}
