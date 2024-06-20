package org.example.messageboard.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.messageboard.model.MessageInfo;

import java.util.ArrayList;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-21
 * Time: 0:09
 */
@Mapper
public interface MessageMapper {
    @Insert("insert into message_info (`from`,`to`,message) values (#{from},#{to},#{message})")
    public Integer insertMessage(MessageInfo message);

    @Select("select * from message_info")
    ArrayList<MessageInfo> selectAllMessage();
}
