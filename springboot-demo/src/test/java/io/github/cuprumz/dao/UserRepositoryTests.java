package io.github.cuprumz.dao;

import io.github.cuprumz.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author cuprumz
 * @date 2019/08/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void save() throws Exception {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
        String formattedDate = dateFormat.format(date);

        userRepository.save(new User("aa1", "aa123456", "aa@126.com", "aa", formattedDate));
        userRepository.save(new User("bb2", "bb123456", "bb@126.com", "bb", formattedDate));
        userRepository.save(new User("cc3", "cc123456", "cc@126.com", "cc", formattedDate));

    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals(3, userRepository.findAll().size());
        System.out.println("------c-u-p-r-u-m------   = " + userRepository.findByUserNameOrEmail("bb", "cc@126.com"));
        Assert.assertEquals("cc", userRepository.findByUserNameOrEmail("bb", "cc@126.com").getNickName());
//        userRepository.delete(userRepository.findByUserName("aa1"));
    }
}
