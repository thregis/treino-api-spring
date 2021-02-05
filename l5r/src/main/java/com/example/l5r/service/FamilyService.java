package com.example.l5r.service;

import com.example.l5r.dto.FamilyDTO;
import com.example.l5r.dto.mapper.FamilyMapper;
import com.example.l5r.model.Family;
import com.example.l5r.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private FamilyMapper familyMapper;

    @Transactional(readOnly = true)
    public Optional<List<FamilyDTO>> getAllFamilies(){
        return Optional.of(familyRepository.findAll().stream().map(familyMapper::toFamilyDTO).collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public Optional<FamilyDTO> getFamilyById(Long id){
        return Optional.of(familyRepository.findById(id).map(familyMapper::toFamilyDTO).get());
    }

    @Transactional(readOnly = true)
    public Optional<FamilyDTO> getFamilyByName(String name){
        return Optional.of(familyRepository.findByName(name).map(familyMapper::toFamilyDTO).get());
    }

    @Transactional
    public Optional<FamilyDTO> createFamily(FamilyDTO familyDTO){
        familyDTO.setActive(true);
        return Optional.of(familyMapper.toFamilyDTO(familyRepository.save(familyMapper.toFamily(familyDTO))));
    }

    @Transactional
    public Optional<FamilyDTO> updateFamily(Long id, FamilyDTO familyDTO){
        familyDTO.setId(id);
        familyDTO.setActive(true);
        return Optional.of(familyMapper.toFamilyDTO(familyRepository.save(familyMapper.toFamily(familyDTO))));
    }

    @Transactional
    public Optional<FamilyDTO> deleteFamily(Long id){
        Optional<Family> family = familyRepository.findById(id);
        family.get().setActive(false);
        return Optional.of(familyMapper.toFamilyDTO(familyRepository.save(family.get())));
    }

    @Transactional
    public Optional<FamilyDTO> reviveFamily(Long id){
        Optional<Family> family = familyRepository.findById(id);
        family.get().setActive(true);
        return Optional.of(familyMapper.toFamilyDTO(familyRepository.save(family.get())));
    }
}
