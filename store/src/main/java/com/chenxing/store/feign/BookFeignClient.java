package com.chenxing.store.feign;

import com.chenxing.store.models.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

}
