package lk.ijse.absd.pos.repository;

import lk.ijse.absd.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-21
 * Time: 10:41 AM
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.name LIKE ?#{[0]}")
    List<Customer> findCustomersLike(String name);

}
