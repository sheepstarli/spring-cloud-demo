package com.chenxing.store.service;

import com.chenxing.store.feign.BookFeignClient;
import com.chenxing.store.models.Book;
import com.chenxing.store.models.CreateBookBodyData;
import com.chenxing.store.models.Store;
import com.chenxing.store.models.StoreDetail;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * StoreDecoratorService
 *
 * @author Chenxing Li
 * @date 2017/11/22 16:30
 */
@Slf4j
@Service
public class StoreDecoratorService {

    @Autowired
    private StoreService storeService;

    @Autowired
    private BookFeignClient bookFeignClient;

    public Object getStoreDetail(Integer storeId, Integer time) {
        StoreDetail storeDetail = new StoreDetail();
        Store store = storeService.getStore(storeId);
        if (store == null || store.getBookId() == null) {
            log.error("store or bookId is null storeId:{}", storeId);
            return null;
        }
        storeDetail.setStoreId(storeId);
        storeDetail.setAvailableNum(store.getNum());

        Integer sleep = time == null ? RandomUtils.nextInt(1000) : time;
        Book book = bookFeignClient.getBook(store.getBookId(), sleep);
        if (book!= null) {
            storeDetail.setBookId(book.getBookId());
            storeDetail.setBookName(book.getName());
            storeDetail.setBookAuthor(book.getAuthor());
        }
        return storeDetail;
    }

    public Object createStore(Integer storeId, Integer time) {
        StoreDetail storeDetail = new StoreDetail();
        Store store = storeService.getStore(storeId);
        if (store == null || store.getBookId() == null) {
            log.error("store or bookId is null storeId:{}", storeId);
            return null;
        }
        storeDetail.setStoreId(storeId);
        storeDetail.setAvailableNum(store.getNum());

        Integer sleep = time == null ? RandomUtils.nextInt(1000) : time;
        CreateBookBodyData body = new CreateBookBodyData();
        body.setSleep(sleep);
        body.setBookId(store.getBookId());
        body.setName("new book!");
        CreateBookBodyData book = bookFeignClient.createBook(store.getBookId(), body);
        if (book!= null) {
            storeDetail.setBookId(book.getBookId());
            storeDetail.setBookName(book.getName());
            storeDetail.setBookAuthor(book.getAuthor());
        }
        return storeDetail;
    }

    public Object updateStore(Integer storeId, Integer time) {
        StoreDetail storeDetail = new StoreDetail();
        Store store = storeService.getStore(storeId);
        if (store == null || store.getBookId() == null) {
            log.error("store or bookId is null storeId:{}", storeId);
            return null;
        }
        storeDetail.setStoreId(storeId);
        storeDetail.setAvailableNum(store.getNum());

        Integer sleep = time == null ? RandomUtils.nextInt(1000) : time;
        CreateBookBodyData body = new CreateBookBodyData();
        body.setSleep(sleep);
        body.setBookId(store.getBookId());
        body.setName("update book!");
        CreateBookBodyData book = bookFeignClient.putBook(store.getBookId(), body);
        if (book!= null) {
            storeDetail.setBookId(book.getBookId());
            storeDetail.setBookName(book.getName());
            storeDetail.setBookAuthor(book.getAuthor());
        }
        return storeDetail;
    }

    @HystrixCommand(groupKey = "Group-1", commandKey = "Test-1", threadPoolKey = "ThreadPool-1")
    public Object test1() {
        log.info("test1!!!!!!!!!!");
        return "test1";
    }

    @HystrixCommand(groupKey = "Group-2", commandKey = "Test-2", threadPoolKey = "ThreadPool-2")
    public Object test2(long time) throws InterruptedException {
        long sleep = RandomUtils.nextInt(200) + time;
        log.info("test2!!!!!!!!!! {}", sleep);
        Thread.sleep(sleep);
        return "test2 time:" + sleep;
    }
}
