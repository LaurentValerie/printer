package ru.starcompany.printer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.starcompany.printer.entities.Material;

import java.util.List;

public interface MaterialsRepository extends JpaRepository<Material,Long> {
    List<Material> findAllByMaterialTypeEqualsIgnoreCase(String materialType);

}
