package com.karios.core.infrastructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.karios.core.domain.model.Publication;
import com.karios.core.infrastructure.entity.PublicationEntity;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PublicationMapper {

    Publication toPublication(PublicationEntity publicationEntity);
    List<Publication> toPublications(List<PublicationEntity> publicationEntities);


    PublicationEntity toPublicationEntity(Publication publication);
    List<PublicationEntity> toPublicationEntities(List<Publication> publications);

}
