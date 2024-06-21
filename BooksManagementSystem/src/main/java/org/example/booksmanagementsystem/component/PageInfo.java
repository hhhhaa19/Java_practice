package org.example.booksmanagementsystem.component;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-21
 * Time: 15:49
 */

@Data
public class PageInfo {
    private Integer pageNumber = 1;//当前页面数
    private Integer pageSize = 10;//一页显示多少数据
    private Integer offset;
    private Integer totalRecords;

    public Integer getOffset() {
        return (pageNumber-1)*pageSize;
    }
}
