package comben.blog.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-28
 * Time: 0:40
 */
@SpringBootTest
class UserMapperTest {
    @Autowired
    UserMapper userMapper;

    @Test
    void getUserByName() {
        System.out.println(userMapper.getUserByName("admin"));
        System.out.println(userMapper.getUserByName("lisi"));
    }

    @Test
    void getUserById() {
        System.out.println(userMapper.getUserById(1));
    }
}