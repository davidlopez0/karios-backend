package com.karios.core.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karios.core.application.service.PublicationService;
import com.karios.core.domain.model.Publication;
import com.karios.core.infrastructure.entity.PublicationEntity;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    @Autowired
    private PublicationService publicationService;

    @GetMapping("/")
    public ResponseEntity<List<Publication>> getAll(){
        List<Publication> publications = publicationService.getAll();
        if(publications != null){
            return new ResponseEntity<>(publications, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user-id/{id}")
    public ResponseEntity<List<Publication>> getAllByUserId(@PathVariable Integer id){
        List<Publication> publications = publicationService.getAllByUserId(id);
        if(publications != null){
            return new ResponseEntity<>(publications, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Publication> getById(@PathVariable Integer id){
        Publication publication = publicationService.getById(id);
        if(publication instanceof Publication){
            return new ResponseEntity<>(publication, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Publication> createPublication(@RequestBody PublicationEntity publication){
        Publication publicationSaved = publicationService.createPublication(publication);
        if(publicationSaved instanceof Publication){
            return new ResponseEntity<>(publicationSaved, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Publication> updatePublication(@PathVariable Integer id, @RequestBody Publication publication){
        Publication publicationUpdated = publicationService.updatePublication(id, publication);
        if(publicationUpdated instanceof Publication){
            return new ResponseEntity<>(publicationUpdated, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        publicationService.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
