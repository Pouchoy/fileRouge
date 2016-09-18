package com.bensiali.cote.pouchoy.galeriePhoto.repositories;

import java.io.File;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bensiali.cote.pouchoy.galeriePhoto.metier.Photo;
import com.bensiali.cote.pouchoy.galeriePhoto.utils.FileStorageManager;

/**
 * 
 * 
 * @author Bertrand COTE
 *
 */
public class PhotoRepository implements PhotoRepositoryInterface {
	
	private static Logger log = LogManager.getLogger(PhotoRepository.class); 

	// ceci indique a spring d'injecter ici l'entity manager en provenance
	// de l'entity manager factory (grace a annotationDriven)
	@PersistenceContext
	private EntityManager em;
	public EntityManager getEm() {return em;}
	public void setEm(EntityManager em) {this.em = em;}
	
	private FileStorageManager fileStorageManager;
	public FileStorageManager getFileStorageManager() {return fileStorageManager;}
	public void setFileStorageManager(FileStorageManager fileStorageManager) {this.fileStorageManager = fileStorageManager;}
	@Override
	@Transactional
	public Photo save( Photo photo, File file ) {
		Photo existing = em.find( Photo.class, photo.getId() );
		if ( existing == null ) {
			em.persist(photo);
			// stockage effectif du fichier
			fileStorageManager.saveFile( Photo.class.getName(), photo.getId(), file);
			return photo;
		}
		else {
			existing = em.merge(photo);
			fileStorageManager.saveFile( Photo.class.getName(), existing.getId(), file);
			return existing;
		}

	}
	
	@Override
	@Transactional
	public Photo findById( int id ) {
		return em.find( Photo.class, id );
	}
	
	@Override
	public File getPhotoFile( Photo photo ) {
		Optional<File> file = fileStorageManager.getFile( Photo.class.getName(), photo.getId());
		if( file.isPresent())
			return file.get();
		else
			return null;
	}
	
	@Override
	@Transactional
	public List<Photo> findAll() {
		return em.createQuery("FROM Photo", Photo.class).getResultList();
	}

	
}












