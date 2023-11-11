package ru.starcompany.printer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.starcompany.printer.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
