package com.shgWebApp.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shgWebApp.project.model.Renters;

@Repository
public interface RentersRepository extends CrudRepository<Renters, Long>{

}
