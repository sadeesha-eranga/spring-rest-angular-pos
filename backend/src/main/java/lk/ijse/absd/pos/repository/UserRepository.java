package lk.ijse.absd.pos.repository;

import lk.ijse.absd.pos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-22
 * Time: 11:51 AM
 */
public interface UserRepository extends JpaRepository<User, String> {
}
