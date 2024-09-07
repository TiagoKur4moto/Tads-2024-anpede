package com.anpede.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anpede.entities.RetiradaFralda;

@Repository
public interface RetiradaFraldaRepository extends JpaRepository<RetiradaFralda, Long> {

}
