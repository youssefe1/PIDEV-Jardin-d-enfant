package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entities.Jdf;
@Repository
public interface IJdfRepository extends JpaRepository<Jdf,Long> {

}
