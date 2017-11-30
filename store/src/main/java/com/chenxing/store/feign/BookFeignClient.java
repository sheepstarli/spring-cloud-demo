package com.chenxing.store.feign;

import com.chenxing.store.models.Book;
import com.chenxing.store.models.CreateBookBodyData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * BookFeignClient
 *
 * @author Chenxing Li
 * @date 2017/11/22 16:37
 */
@FeignClient(value = "${feign.book}")
public interface BookFeignClient {

    @RequestMapping(path = "/v5/book/{bookId}", method = RequestMethod.GET)
    Book getBook(@PathVariable("bookId") Integer bookId, @RequestParam(name = "sleep", required = false) Integer sleep);

    @RequestMapping(path = "/v5/book/{bookId}", method = RequestMethod.POST)
    CreateBookBodyData createBook(@PathVariable("bookId") Integer bookId, @RequestBody CreateBookBodyData body);

    @RequestMapping(path = "/v5/book/{bookId}", method = RequestMethod.PUT)
    CreateBookBodyData putBook(@PathVariable("bookId") Integer bookId, @RequestBody CreateBookBodyData body);

}
