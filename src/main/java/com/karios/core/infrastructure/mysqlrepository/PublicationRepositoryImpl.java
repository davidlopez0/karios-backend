package com.karios.core.infrastructure.mysqlrepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karios.core.domain.model.Publication;
import com.karios.core.domain.repository.PublicationRepository;
import com.karios.core.infrastructure.entity.PublicationEntity;
import com.karios.core.infrastructure.mapper.PublicationMapper;

@Repository
public class PublicationRepositoryImpl implements PublicationRepository {

    @Autowired
    private PublicationCrudRepository publicationCrudRepository;
    @Autowired
    private PublicationMapper mapper;

    @Override
    public List<Publication> getAll() {
        return mapper.toPublications((List<PublicationEntity>) publicationCrudRepository.findAll());
    }

    @Override
    public Optional<PublicationEntity> getById(Integer id){
        return publicationCrudRepository.findById(id);
    }

    @Override
    public List<Publication> getAllByUserId(Integer id){
        return mapper.toPublications((List<PublicationEntity>)publicationCrudRepository.findAllByUserId(id));
    }

    @Override
    public Publication save(PublicationEntity publication) {
        return mapper.toPublication(publicationCrudRepository.save(publication));
    }

    @Override
    public void deleteById(Integer id) {
        publicationCrudRepository.deleteById(id);
    }
}