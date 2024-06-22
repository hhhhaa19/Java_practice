package org.example.booksmanagementsystem.model;

import lombok.Data;
import org.example.booksmanagementsystem.Enum.BookStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 10:28
 */
@Data
@Component
public class Book {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    private BigDecimal price;
    private String publish;
    private Integer status;
    private String statusCH;
    private Date createTime;
    private Date updateTime;
}
