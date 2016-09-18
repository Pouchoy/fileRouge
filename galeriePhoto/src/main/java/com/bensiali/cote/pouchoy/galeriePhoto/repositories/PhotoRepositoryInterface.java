package com.bensiali.cote.pouchoy.galeriePhoto.repositories;

import java.io.File;
import java.util.List;

import com.bensiali.cote.pouchoy.galeriePhoto.metier.Photo;

public interface PhotoRepositoryInterface {
	
	public List<Photo> findAll();
	
	public Photo save( Photo photo, File file );
	
	public Photo findById( int id );
	
	// cette fonction permet de récupérer le fichier associé a un avatar dans la base
	public File getPhotoFile( Photo Photo );

}
