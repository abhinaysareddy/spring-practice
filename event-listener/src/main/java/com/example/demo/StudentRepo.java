package com.example.demo;

import com.example.demo.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "student")
public interface StudentRepo extends PagingAndSortingRepository<Student,Long> {

    List<Student> findByNameStartsWith(@Param("name") String name);
}
