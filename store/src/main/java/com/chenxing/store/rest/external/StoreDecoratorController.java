package com.chenxing.store.rest.external;

import com.chenxing.store.service.StoreDecoratorService;
import com.chenxing.store.service.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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

    @RequestMapping(path = "/{storeId}/detail", method = RequestMethod.GET)
    public Object storeDetail(@PathVariable("storeId") Integer storeId) {
        log.info("GET /v1/store/{}/detail", storeId);
        return storeDecoratorService.getStoreDetail(storeId);
    }

    @RequestMapping(path = "/test1", method = RequestMethod.GET)
    public Object test1() {
        return storeDecoratorService.test1();
    }

    @RequestMapping(path = "/test2", method = RequestMethod.GET)
    public Object test2(@RequestParam(required = false, name = "time", defaultValue = "600") int time) throws InterruptedException {
        return storeDecoratorService.test2(time);
    }
}
