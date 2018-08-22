package lk.ijse.absd.pos.repository;

import lk.ijse.absd.pos.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-21
 * Time: 10:42 AM
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("SELECT c FROM Item c WHERE c.description LIKE ?#{[0]}")
    List<Item> findItemsLike(String description);

}
