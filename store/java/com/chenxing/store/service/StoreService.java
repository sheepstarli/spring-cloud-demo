package com.chenxing.store.service;

import com.chenxing.store.models.Store;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * StoreService
 *
 * @author Chenxing Li
 * @date 2017/11/22 16:29
 */
@Service
public class StoreService {

    private static final Map<Integer, Store> stores = new HashMap<>();

    static {

        stores.put(1, new Store(1, 1, 2));
        stores.put(2, new Store(2, 2, 10));
        stores.put(3, new Store(3, 3, 1));
        stores.put(4, new Store(4, 4, 10));
        stores.put(5, new Store(5, 5, 10));
        stores.put(6, new Store(6, 6, 10));
        stores.put(7, new Store(7, 7, 10));

    }


    public Store getStore(Integer storeId) {
        return stores.get(storeId);
    }
}
