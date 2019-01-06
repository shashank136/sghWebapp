package com.shgWebApp.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shgWebApp.project.model.Workers;

@Repository
public interface WorkersRepository extends CrudRepository<Workers, Long>{

}
