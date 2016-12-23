package com.nisum.test.dataRest.dao;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@SpringBootApplication
@EnableAutoConfiguration
@RepositoryRestResource(path = "student")
@ComponentScan(basePackages = {"com.nisum.test.dataRest.*"})
@PreAuthorize("hasRole('ROLE_USER')")
public interface StudentRepo extends CrudRepository<Student, String> {

}
