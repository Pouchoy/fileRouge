package com.bensiali.cote.pouchoy.galeriePhoto.metier;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Photo
 * -----
 * id
 * nom
 * description
 * dateCreation
 * fileName
 * content/type
 * 
 * Tag n)------(n Photo n)-----(1 Galerie
 * 
 * @author Bertrand COTE
 *
 */
@Entity
public class Photo {
	
	private int id;
	private String nom;
	private String description;
	private Date dateCreation;
	private String fileName;
	private String contentType;
	private Galerie galerie;
	private Set<Tag> tags;
	
	@Id
	@GeneratedValue
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	
	public Date getDateCreation() { return dateCreation; }
	public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }
	
	public String getFileName() { return fileName; }
	public void setFileName(String fileName) { this.fileName = fileName; }
	
	public String getContentType() { return contentType; }
	public void setContentType(String contentType) { this.contentType = contentType; }
	
	@ManyToOne
	public Galerie getGalerie() { return galerie; }
	public void setGalerie(Galerie galerie) { this.galerie = galerie; }
	
	@ManyToMany
	public Set<Tag> getTags() {
		if( this.tags == null )
			this.tags = new HashSet<>();
		return tags;
	}
	public void setTags(Set<Tag> tags) { this.tags = tags; }
	
	

	public Photo() { this( 0, "", "", null, "", "", null, null ); }
	public Photo(int id, String nom, String description, Date dateCreation, String fileName, String contentType,
			Galerie galerie, Set<Tag> tags) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.dateCreation = dateCreation;
		this.fileName = fileName;
		this.contentType = contentType;
		this.galerie = galerie;
		this.tags = tags;
	}
	
	
	@Override
	public String toString() {
		return "Photo [id=" + id + ", nom=" + nom + ", description=" + description + ", dateCreation=" + dateCreation
				+ ", fileName=" + fileName + ", contentType=" + contentType + "]";
	}

}
