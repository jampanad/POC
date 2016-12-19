package com.nisum.test.dataRest.dao;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableAutoConfiguration
@RepositoryRestResource(path = "student")
@ComponentScan(basePackages = {"com.nisum.test.dataRest.*"})
public interface StudentRepo extends CrudRepository<Student, String> {

}
