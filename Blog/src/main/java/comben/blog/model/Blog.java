package comben.blog.model;

import comben.blog.Utils.DateUtils;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-27
 * Time: 22:54
 */
@Data
public class Blog {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;

    public String getCreateTime() {
        return DateUtils.dateToString(createTime);
    }
}
