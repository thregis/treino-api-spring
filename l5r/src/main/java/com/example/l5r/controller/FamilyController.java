package com.example.l5r.controller;

import com.example.l5r.dto.FamilyDTO;
import com.example.l5r.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @GetMapping
    public ResponseEntity<List<FamilyDTO>> getAllFamilies(){
        return ResponseEntity.ok(familyService.getAllFamilies().get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyDTO> getFamilyById(@PathVariable Long id){
        return ResponseEntity.ok(familyService.getFamilyById(id).get());
    }

    @GetMapping("/name={name}")
    public ResponseEntity<FamilyDTO> getFamilyByName(@PathVariable String name){
        return ResponseEntity.ok(familyService.getFamilyByName(name).get());
    }

    @PostMapping
    public ResponseEntity<FamilyDTO> postFamily(@RequestBody FamilyDTO familyDTO){
        familyService.createFamily(familyDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FamilyDTO> putFamily(@PathVariable Long id, @RequestBody FamilyDTO familyDTO){
        familyService.updateFamily(id, familyDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FamilyDTO> deleteFamily(@PathVariable Long id){
        familyService.deleteFamily(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<FamilyDTO> patchFamily(@PathVariable Long id){
        familyService.reviveFamily(id);
        return ResponseEntity.ok().build();
    }
}
