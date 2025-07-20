package com.example.Blind_Box.repository;

import com.example.Blind_Box.entity.BlindBoxes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlindBoxRepository extends JpaRepository<BlindBoxes, Integer> {

}
