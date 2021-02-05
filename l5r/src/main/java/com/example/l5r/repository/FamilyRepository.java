package com.example.l5r.repository;

import com.example.l5r.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {

//List<Family> findByActive(Boolean active);
Optional<Family> findByName(String name);
}
