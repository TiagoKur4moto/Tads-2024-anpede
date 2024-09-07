package com.anpede.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anpede.entities.Fralda;

@Repository
public interface FraldaRepository extends  JpaRepository<Fralda, Long> {

}
