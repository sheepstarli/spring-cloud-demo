package com.chenxing.store.service;

import com.chenxing.store.models.Store;
import com.chenxing.store.models.StoreDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StoreDecoratorService
 *
 * @author Chenxing Li
 * @date 2017/11/22 16:30
 */
@Service
public class StoreDecoratorService {

    @Autowired
    private StoreService storeService;

    public Object getStoreDetail(Integer storeId) {
        StoreDetail storeDetail = new StoreDetail();
        Store store = storeService.getStore(storeId);
        if (store == null) {
            return null;
        }
        storeDetail.setStoreId(storeId);
        storeDetail.setAvailableNum(store.getNum());
        return storeDetail;
    }
}
