package comben.blog.service;

import comben.blog.mapper.UserMapper;
import comben.blog.model.Result;
import comben.blog.model.UserInfo;
import comben.blog.Utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-07-01
 * Time: 2:22
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public Result<String> login(UserInfo userInfo) {
        if (!StringUtils.hasLength(userInfo.getUserName())
                || !StringUtils.hasLength(userInfo.getPassword())) {
            return Result.fail("账号或密码为空");
        }
        UserInfo userInfoSQL = userMapper.getUserByName(userInfo.getUserName());
        if (userInfoSQL == null) {
            return Result.fail("账号不存在");
        }
        if (!userInfo.getPassword().equals(userInfoSQL.getPassword())) {
            return Result.fail("密码错误");
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userName", userInfo.getUserName());
        map.put("password", userInfo.getPassword());
        String taken = JWTUtils.generateToken(map);
        return Result.success(taken);
    }
}
