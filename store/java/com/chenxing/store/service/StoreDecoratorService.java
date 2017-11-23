package com.chenxing.store.service;

import com.chenxing.store.feign.BookFeignClient;
import com.chenxing.store.models.Book;
import com.chenxing.store.models.Store;
import com.chenxing.store.models.StoreDetail;
import lombok.extern.slf4j.Slf4j;
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

    public Object getStoreDetail(Integer storeId) {
        StoreDetail storeDetail = new StoreDetail();
        Store store = storeService.getStore(storeId);
        if (store == null || store.getBookId() == null) {
            log.error("store or bookId is null storeId:{}", storeId);
            return null;
        }
        storeDetail.setStoreId(storeId);
        storeDetail.setAvailableNum(store.getNum());

        Book book = bookFeignClient.getBook(store.getBookId());
        if (book!= null) {
            storeDetail.setBookId(book.getBookId());
            storeDetail.setBookName(book.getName());
            storeDetail.setBookAuthor(book.getAuthor());
        }
        return storeDetail;
    }
}
