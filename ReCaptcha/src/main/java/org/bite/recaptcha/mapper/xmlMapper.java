package org.bite.recaptcha.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.bite.recaptcha.model.UserInfo;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-18
 * Time: 23:38
 */
@Mapper
public interface xmlMapper {
    Integer count();
    Integer insertUserInfo(UserInfo userInfo);
    List<UserInfo> getUserInfo();
    UserInfo selectUserInfoByArticleId();
}
