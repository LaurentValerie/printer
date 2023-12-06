package ru.starcompany.printer.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.starcompany.printer.dto.MaterialDto;
import ru.starcompany.printer.dto.MaterialTypeDto;
import ru.starcompany.printer.services.MaterialService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/material")
@Tag(name = "Material Controller", description = "Allows to create and get materials info")
public class MaterialController {
    private final MaterialService materialService;

    @PostMapping("/new")
    @Operation(summary = "Добавление нового материала")
    public ResponseEntity<Long> postMaterial(@RequestBody @Valid MaterialDto materialDto){
        MaterialDto savedMaterial = materialService.postMaterials(materialDto);
        return ResponseEntity.ok().body(savedMaterial.getId());
    }

    @GetMapping("/types/all")
    @Operation(summary = "Получение всех доступных типов материала")
    public ResponseEntity<Set<MaterialTypeDto>> getAllMaterialTypes(){
        return ResponseEntity.ok().body(materialService.getAllMaterialTypes());
    }

    @GetMapping("/colours/{materialType}")
    @Operation(summary = "Получение всех доступных цветов для выбранного типа")
    public ResponseEntity<Set<String>> getAllMaterialColoursByType(@PathVariable String materialType){
        return ResponseEntity.ok().body(materialService.getAllMaterialColourByType(materialType));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление материала по его id")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.ok().build();
    }

}
