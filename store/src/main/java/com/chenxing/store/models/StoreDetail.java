package com.chenxing.store.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * StoreDetail
 *
 * @author Chenxing Li
 * @date 2017/11/22 16:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDetail {

    private Integer storeId;
    private Integer availableNum;

    private Integer bookId;
    private String bookName;
    private String bookAuthor;

}
