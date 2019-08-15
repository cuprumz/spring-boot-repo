package io.github.cuprumz.dao;

import io.github.cuprumz.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cuprumz
 * @date 2019/08/15
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    User findByUserNameOrEmail(String username, String email);
}
