package com.example.l5r.service;

import com.example.l5r.dto.ClanDTO;
import com.example.l5r.dto.mapper.ClanMapper;
import com.example.l5r.model.Clan;
import com.example.l5r.repository.ClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClanService {

    @Autowired
    private ClanRepository clanRepository;

    @Autowired
    private ClanMapper clanMapper;

    @Transactional(readOnly = true)
    public Optional<List<ClanDTO>> getAllClans(){
        return Optional.of(clanRepository.findAll().stream().map(clanMapper::toClanDTO).collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public Optional<List<ClanDTO>> getActiveClans(){
        return Optional.of(clanRepository.findByActive(true).stream().map(clanMapper::toClanDTO).collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public Optional<List<ClanDTO>> getMajorClans(){
        return Optional.of(clanRepository.findByMajor(true).stream().map(clanMapper::toClanDTO).collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public Optional<List<ClanDTO>> getMinorClans(){
        return Optional.of(clanRepository.findByMajor(false).stream().map(clanMapper::toClanDTO).collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public Optional<ClanDTO> getClanById(Long id){
        return Optional.of(clanRepository.findById(id).map(clanMapper::toClanDTO).get());
    }

    @Transactional(readOnly = true)
    public Optional<ClanDTO> getClanByName(String name){
        name.toLowerCase(Locale.ROOT);
        return Optional.of(clanRepository.findByName(name).map(clanMapper::toClanDTO).get());
    }

    @Transactional
    public Optional<ClanDTO> createClan(ClanDTO clanDTO){
        clanDTO.setActive(true);
        return Optional.of(clanMapper.toClanDTO(clanRepository.save(clanMapper.toClan(clanDTO))));
    }

    @Transactional
    public Optional<ClanDTO> updateClan(Long id, ClanDTO clanDTO){
        clanDTO.setId(id);
        clanDTO.setActive(true);
        return Optional.of(clanMapper.toClanDTO(clanRepository.save(clanMapper.toClan(clanDTO))));
    }

    @Transactional
    public Optional<ClanDTO> removeClan(Long id){
        Optional<Clan> clan = clanRepository.findById(id);
        clan.get().setActive(false);
        return Optional.of(clanMapper.toClanDTO(clanRepository.save(clan.get())));
    }

    @Transactional
    public Optional<ClanDTO> reviveClan(Long id){
        Optional<Clan> clan = clanRepository.findById(id);
        clan.get().setActive(true);
        return Optional.of(clanMapper.toClanDTO(clanRepository.save(clan.get())));
    }
    }

