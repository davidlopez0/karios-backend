package com.karios.core.domain.repository;

import java.util.List;
import java.util.Optional;

import com.karios.core.domain.model.Publication;
import com.karios.core.infrastructure.entity.PublicationEntity;

public interface PublicationRepository {
	List<Publication> getAll();
    Optional<PublicationEntity> getById(Integer id);
    List<Publication> getAllByUserId(Integer id);
    Publication save(PublicationEntity publication);
    void deleteById(Integer id);
}
