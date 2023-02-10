package com.example.padelstatsv2.repository;

import com.example.padelstatsv2.model.PlayersModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayersRepository extends JpaRepository<PlayersModel,Integer> {

    @Override
    Optional<PlayersModel> findById(Integer id);
}
