package org.example.booksmanagementsystem;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Benjamin
 * Date: 2024-06-12
 * Time: 10:28
 */
@Data
public class Book {
    private Integer id;
    private String bookName;
    private String author;
    private Integer count;
    private BigDecimal price;
    private String publish;
    private Integer status;
}
