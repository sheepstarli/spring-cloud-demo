package com.chenxing.store.rest.external;

import com.chenxing.store.service.StoreDecoratorService;
import com.chenxing.store.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * StoreDecoratorController
 *
 * @author Chenxing Li
 * @date 2017/11/22 16:27
 */
@Slf4j
@RestController
@RequestMapping("/v1/store")
public class StoreDecoratorController {


    @Autowired
    private StoreDecoratorService storeDecoratorService;

    @RequestMapping(path = "/{id}/delail", method = RequestMethod.GET)
    public Object storeDetail(@PathVariable("storeId") Integer storeId) {
        log.info("GET /v1/store/{}/detail", storeId);
        return storeDecoratorService.getStoreDetail(storeId);
    }
}
