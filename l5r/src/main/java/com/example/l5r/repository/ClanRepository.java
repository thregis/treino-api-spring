package com.example.l5r.repository;

import com.example.l5r.model.Clan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClanRepository extends JpaRepository <Clan, Long> {
    List<Clan> findByMajor(Boolean major);

    List<Clan> findByActive(Boolean active);

    Optional<Clan> findByName(String name);
}
