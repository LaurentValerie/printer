package ru.starcompany.printer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.starcompany.printer.entities.Material;
import ru.starcompany.printer.repositories.MaterialRepository;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
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

    public void deleteMaterial(Long id) {
        if (!materialRepository.existsById(id)) {
            log.warn("Material with Id: {} doesn't exists", id);
            return;
        }
        materialRepository.deleteById(id);
    }

}
