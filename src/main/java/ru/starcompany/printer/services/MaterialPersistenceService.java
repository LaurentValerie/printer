package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.Material;
import ru.starcompany.printer.repositories.MaterialRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MaterialPersistenceService {
    private final MaterialRepository materialRepository;

    public Material saveMaterials(Material material){
        return materialRepository.save(material);
    }
    public List<Material> getAllMaterials(){
        return materialRepository.findAll();
    }
    public List<Material> getAllMaterialsByType(String materialType){
        return materialRepository.findAllByMaterialTypeEqualsIgnoreCase(materialType);
    }

}
