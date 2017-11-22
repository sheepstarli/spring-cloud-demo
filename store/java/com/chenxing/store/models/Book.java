package com.chenxing.store.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Book
 *
 * @author Chenxing Li
 * @date 2017/11/22 15:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private Integer bookId;

    private String name;

    private String author;

    private String coverImg;

}
