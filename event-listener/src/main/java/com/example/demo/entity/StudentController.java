package com.example.demo.entity;

import com.example.demo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.RootResourceInformation;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RepositoryRestController
public class StudentController {
    private final StudentRepo repository;
    PagedResourcesAssembler<Object> assembler;
    private static final String BASE_MAPPING="/{repository}/updateChilds";
    @Autowired
    public StudentController(StudentRepo repo,PagedResourcesAssembler<Object> assembler) {
        repository = repo;
        this.assembler=assembler;
    }

    @RequestMapping(value = BASE_MAPPING, method = RequestMethod.GET)
    public HttpEntity<?> optionsForSearches(RootResourceInformation resourceInformation) {
       // resourceInformation.getInvoker().invoke

        return ResponseEntity.ok().build();
    }

}
