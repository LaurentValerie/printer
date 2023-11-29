package ru.starcompany.printer.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.starcompany.printer.entities.MaterialDto;
import ru.starcompany.printer.services.MaterialService;

import java.util.Set;

@RequiredArgsConstructor
@RestController
public class MaterialController {
    private final MaterialService materialService;


    @PostMapping("/material/new")
    public ResponseEntity<Long> postMaterial(@RequestBody @Valid MaterialDto materialDto){
        MaterialDto savedMaterial = materialService.postMaterials(materialDto);
        return ResponseEntity.ok().body(savedMaterial.getId());
    }

    @GetMapping("/material/types/all")
    public ResponseEntity<Set<String>> getAllMaterialTypes(){
        return ResponseEntity.ok().body(materialService.getAllMaterialTypes());
    }
    @GetMapping("/material/colours/{materialType}")
    public ResponseEntity<Set<String>> getAllMaterialColoursByType(@PathVariable String materialType){
        return ResponseEntity.ok().body(materialService.getAllMaterialColourByType(materialType));
    }
}
