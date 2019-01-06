package com.shgWebApp.project.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shgWebApp.project.model.Owners;

@Repository
public interface OwnersRepository extends CrudRepository<Owners, Long>{

}
