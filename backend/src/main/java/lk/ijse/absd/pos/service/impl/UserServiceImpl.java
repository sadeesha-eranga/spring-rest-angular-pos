package lk.ijse.absd.pos.service.impl;

import lk.ijse.absd.pos.entity.User;
import lk.ijse.absd.pos.repository.UserRepository;
import lk.ijse.absd.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IntelliJ IDEA.
 * User: sadeesha
 * Date: 2018-08-22
 * Time: 11:53 AM
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticateUser(String username, String password) {
        boolean exists = userRepository.existsById(username);

        if (!exists) {
            return false;
        }

        User user = userRepository.findById(username).get();

        return user.getPassword().equals(password);

    }
}
