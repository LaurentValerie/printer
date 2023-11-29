package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.Material;
import ru.starcompany.printer.entities.MaterialDto;
import ru.starcompany.printer.mappers.MaterialMapper;
import ru.starcompany.printer.mappers.MaterialDtoMapper;

import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MaterialService {
    private final MaterialMapper materialMapper;
    private final MaterialDtoMapper materialDtoMapper;
    private final MaterialPersistenceService materialPersistenceService;

    public MaterialDto postMaterials(MaterialDto materialDto){
        Material material = materialMapper.toMaterials(materialDto);
        return materialPersistenceService.saveMaterials(material);
    }
    public Set<String> getAllMaterialTypes(){
        return materialPersistenceService.getAllMaterials().stream()
                .map(materialDtoMapper::toMaterialsDto)
                .map(MaterialDto::getMaterialType)
                .collect(Collectors.toSet());
    }
    public Set<String> getAllMaterialColourByType(String materialType){
        return materialPersistenceService.getAllMaterialsByType(materialType).stream()
                .map(materialDtoMapper::toMaterialsDto)
                .map(MaterialDto::getMaterialColour)
                .collect(Collectors.toSet());
    }
}
