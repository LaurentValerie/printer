package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.dto.MaterialTypeDto;
import ru.starcompany.printer.entities.Material;
import ru.starcompany.printer.dto.MaterialDto;
import ru.starcompany.printer.mappers.Material2MaterialDtoMapper;
import ru.starcompany.printer.mappers.MaterialDto2MaterialMapper;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MaterialService {
    private final Material2MaterialDtoMapper material2MaterialDtoMapper;
    private final MaterialDto2MaterialMapper materialDto2MaterialMapper;
    private final MaterialPersistenceService materialPersistenceService;

    public MaterialDto postMaterials(MaterialDto materialDto){
        Material material = material2MaterialDtoMapper.toMaterials(materialDto);
        return materialDto2MaterialMapper.toMaterialsDto(materialPersistenceService.saveMaterials(material));
    }
    public Set<MaterialTypeDto> getAllMaterialTypes(){
        return materialPersistenceService.getAllMaterials().stream()
                .distinct()
                .map(this::getMaterialTypeDto)
                .collect(Collectors.toSet());
    }
    public Set<String> getAllMaterialColourByType(String materialType){
        return materialPersistenceService.getAllMaterialsByType(materialType).stream()
                .map(materialDto2MaterialMapper::toMaterialsDto)
                .map(MaterialDto::getMaterialColour)
                .collect(Collectors.toSet());
    }

    private MaterialTypeDto getMaterialTypeDto(Material material) {
        return MaterialTypeDto.builder()
                .materialType(material.getMaterialType())
                .materialTypeDesc(material.getMaterialTypeDesc())
                .build();
    }

}
