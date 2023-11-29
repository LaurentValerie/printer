package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.Material;
import ru.starcompany.printer.entities.MaterialDto;
import ru.starcompany.printer.mappers.MaterialDtoMapper;
import ru.starcompany.printer.repositories.MaterialsRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MaterialPersistenceService {
    private final MaterialsRepository materialsRepository;
    private final MaterialDtoMapper materialDtoMapper;

    public MaterialDto saveMaterials(Material material){
        return materialDtoMapper.toMaterialsDto(materialsRepository.save(material));
    }
    public List<Material> getAllMaterials(){
        return materialsRepository.findAll();
    }
    public List<Material> getAllMaterialsByType(String materialType){
        return materialsRepository.findAllByMaterialTypeEqualsIgnoreCase(materialType);
    }

}
