package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.esprit.spring.entities.JDF;

@Repository
public interface IJDFRepository extends JpaRepository<JDF, Long> {

}
