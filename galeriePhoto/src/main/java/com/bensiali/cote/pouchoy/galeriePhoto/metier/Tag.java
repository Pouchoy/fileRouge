package com.bensiali.cote.pouchoy.galeriePhoto.metier;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Tag
 * -----
 * id
 * libelle
 * 
 * Tag n)------(n Photo
 * 
 * @author Bertrand COTE
 */
@Entity
public class Tag {
	
	private int id;
	private String libelle;
	private Set<Photo> photos; // Tag n)------(n Photo
	
	@Id
	@GeneratedValue
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getLibelle() { return libelle; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	
	@ManyToMany(mappedBy="tags")
	public Set<Photo> getPhotos() { 
		if( this.photos == null )
			this.photos = new HashSet<>();
		return photos; 
	}
	public void setPhotos(Set<Photo> photos) { this.photos = photos; }
	
	public Tag() { this( 0, "", null ); }
	public Tag(int id, String libelle, Set<Photo> photos) {
		this.id = id;
		this.libelle = libelle;
		this.photos = photos;
	}
	
	@Override
	public String toString() {
		return "Tag [id=" + id + ", libelle=" + libelle + "]";
	}

}
