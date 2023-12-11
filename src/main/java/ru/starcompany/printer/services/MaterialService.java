package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.dto.MaterialTypeDto;
import ru.starcompany.printer.entities.Material;
import ru.starcompany.printer.dto.MaterialDto;
import ru.starcompany.printer.mappers.MaterialMapper;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaterialService {
    private final MaterialMapper materialMapper;
    private final MaterialPersistenceService materialPersistenceService;

    public MaterialDto postMaterials(MaterialDto materialDto){
        Material material = materialMapper.toMaterials(materialDto);
        return materialMapper.toMaterialsDto(materialPersistenceService.saveMaterials(material));
    }
    public Set<MaterialTypeDto> getAllMaterialTypes(){
        return materialPersistenceService.getAllMaterials().stream()
                .map(this::getMaterialTypeDto)
                .collect(Collectors.toSet());
    }
    public Set<String> getAllMaterialColourByType(String materialType){
        return materialPersistenceService.getAllMaterialsByType(materialType).stream()
                .map(materialMapper::toMaterialsDto)
                .map(MaterialDto::getMaterialColour)
                .collect(Collectors.toSet());
    }

    public void deleteMaterial(Long id) {
        materialPersistenceService.deleteMaterial(id);
    }

    private MaterialTypeDto getMaterialTypeDto(Material material) {
        return MaterialTypeDto.builder()
                .materialType(material.getMaterialType())
                .materialTypeDesc(material.getMaterialTypeDesc())
                .build();
    }

}
