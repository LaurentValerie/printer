package ru.starcompany.printer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.starcompany.printer.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {


}
