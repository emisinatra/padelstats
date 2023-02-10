package com.example.padelstatsv2.repository;

import com.example.padelstatsv2.model.MatchsModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchsRepository extends JpaRepository<MatchsModel,Integer> {

    Optional<MatchsModel>findById(Integer id);


}
