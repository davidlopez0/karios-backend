package com.karios.core.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karios.core.domain.model.Publication;
import com.karios.core.domain.repository.PublicationRepository;
import com.karios.core.infrastructure.entity.PublicationEntity;
import com.karios.core.infrastructure.mapper.PublicationMapper;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository publicationRepository;
    @Autowired
    private PublicationMapper mapper;

    public List<Publication> getAll(){
        List<Publication> publications = publicationRepository.getAll();
        if (publications.size() > 0){
            return publications;
        }

        return null;
    }

    public List<Publication> getAllByUserId(Integer id){
        List<Publication> publications = publicationRepository.getAllByUserId(id);
        if(publications.size() > 0){
            return publications;
        }

        return null;
    }

    public Publication getById(Integer id){
        Optional<Publication> publication = publicationRepository.getById(id).map(
                publicationEntity -> mapper.toPublication(publicationEntity)
        );
        if(publication.isPresent()){
            return publication.get();
        }

        return null;
    }

    public Publication createUser(PublicationEntity publicationEntity){
        Publication publicationSaved = publicationRepository.save(publicationEntity);
        if(publicationSaved instanceof Publication){
            return publicationSaved;
        }

        return null;
    }

    public Publication updateUser(Integer id, Publication publication){
        Optional<PublicationEntity> publicationSearched = publicationRepository.getById(id);
        if(publicationSearched.isPresent()){
            PublicationEntity publicationEntity = publicationSearched.get();
            if(publication.getDescription() != null){
                publicationEntity.setDescription(publication.getDescription());
            }
            return publicationRepository.save(publicationEntity);
        }

        return null;
    }

    public void deleteById(Integer id){
        publicationRepository.deleteById(id);
    }

}