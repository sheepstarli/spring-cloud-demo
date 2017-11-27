package com.chenxing.store.rest.internal;

import com.chenxing.store.models.Store;
import com.chenxing.store.service.StoreService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * StoreController
 *
 * @author Chenxing Li
 * @date 2017/11/22 16:07
 */
@Slf4j
@RestController
@RequestMapping(path = "/v5/store")
public class StoreController {


    @Autowired
    private StoreService storeService;

    @RequestMapping(path = "/{storeId}", method = RequestMethod.GET)
    public Object storeInfo(@PathVariable("storeId") Integer storeId) {
        log.info("GET /v5/store/{}", storeId);
        return storeService.getStore(storeId);
    }
}
