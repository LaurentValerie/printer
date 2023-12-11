package ru.starcompany.printer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.starcompany.printer.entities.Order;
import ru.starcompany.printer.entities.OrderStatus;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findAllByExecutorUuidAndOrderStatus(String executorId, OrderStatus orderStatus);
}
