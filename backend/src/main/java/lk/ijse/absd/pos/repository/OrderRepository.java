package lk.ijse.absd.pos.repository;

import lk.ijse.absd.pos.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-22
 * Time: 12:03 PM
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {
//    @Query("SELECT count(orderId) FROM Orders")
//    long getTotalOrders();
}
