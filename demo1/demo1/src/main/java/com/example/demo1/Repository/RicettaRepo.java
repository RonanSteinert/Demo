package com.example.demo1.Repository;

import com.example.demo1.Model.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RicettaRepo extends JpaRepository<Ricetta, Long> {
}
