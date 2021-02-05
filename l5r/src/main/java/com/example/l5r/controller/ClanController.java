package com.example.l5r.controller;

import com.example.l5r.dto.ClanDTO;
import com.example.l5r.dto.mapper.ClanMapper;
import com.example.l5r.service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clan")
public class ClanController {

    @Autowired
    private ClanService clanService;

    /*@Autowired
    private ClanMapper clanMapper;
*/
    @GetMapping
    public ResponseEntity<List<ClanDTO>> getAllClans(){
        return ResponseEntity.ok(clanService.getAllClans().get());
    }

    @GetMapping("/active")
    public ResponseEntity<List<ClanDTO>> getActiveClans(){
        return ResponseEntity.ok(clanService.getActiveClans().get());
    }

    @GetMapping("/major")
    public ResponseEntity<List<ClanDTO>> getMajorClans(){
        return ResponseEntity.ok(clanService.getMajorClans().get());
    }

    @GetMapping("/minor")
    public ResponseEntity<List<ClanDTO>> getMinorClans(){
        return ResponseEntity.ok(clanService.getMinorClans().get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClanDTO> getClanById(@PathVariable Long id){
        return ResponseEntity.ok(clanService.getClanById(id).get());
    }

    @GetMapping("/name={name}")
    public ResponseEntity<ClanDTO> getClanByName(@PathVariable String name){
        return ResponseEntity.ok(clanService.getClanByName(name).get());
    }

    @PostMapping
    public ResponseEntity<ClanDTO> postClan(@RequestBody ClanDTO clanDTO){
        clanService.createClan(clanDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClanDTO> putClan(@PathVariable Long id, @RequestBody ClanDTO clanDTO){
        clanService.updateClan(id, clanDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClanDTO> deleteClan(@PathVariable Long id){
        clanService.removeClan(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/revive/{id}")
    public ResponseEntity<ClanDTO> reviveClan(@PathVariable Long id){
        clanService.reviveClan(id);
        return ResponseEntity.ok().build();
    }
}
