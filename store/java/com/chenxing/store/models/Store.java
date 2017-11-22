package com.chenxing.store.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Store
 *
 * @author Chenxing Li
 * @date 2017/11/22 16:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    private Integer storeId;

    private Integer bookId;

    private Integer num;

}
