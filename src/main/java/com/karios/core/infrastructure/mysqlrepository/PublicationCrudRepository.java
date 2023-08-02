package com.karios.core.infrastructure.mysqlrepository;

import org.springframework.data.repository.CrudRepository;

import com.karios.core.infrastructure.entity.PublicationEntity;

public interface PublicationCrudRepository extends CrudRepository<PublicationEntity, Integer> {
    Iterable<PublicationEntity> findAllByUserId(Integer userId);
}
