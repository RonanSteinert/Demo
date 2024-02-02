package com.example.demo1.Repository;

import com.example.demo1.Model.Preferiti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferitiRepo extends JpaRepository<Preferiti, Long> {
}
