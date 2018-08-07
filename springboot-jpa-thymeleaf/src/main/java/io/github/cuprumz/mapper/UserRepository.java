package io.github.cuprumz.mapper;

import io.github.cuprumz.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author cuprumz
 * @date 2018/08/06
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    void deleteById(Long id);
}
