package org.ben.mybatisxml.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.ben.mybatisxml.model.UserInfo;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-18
 * Time: 22:55
 */
@Mapper
public interface MapperXml {
    Integer selectCount();
    Integer insertByCondition(UserInfo userInfo);
    Integer updateByCondition(UserInfo userInfo);
    List<UserInfo> selectByIds(List<UserInfo> userInfos);
}
