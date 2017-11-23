package com.chenxing.book.rest.internal;

import com.chenxing.book.models.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * BookController
 *
 * @author Chenxing Li
 * @date 2017/11/22 15:42
 */
@Slf4j
@RestController
@RequestMapping(path = "/v5/book")
public class BookController {

    private static final Map<Integer, Book> books = new HashMap<>();

    static {
        books.put(1, new Book(1, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", null));
        books.put(2, new Book(2, "Harry Potter and the Chamber of Secrets", "J.K. Rowling", null));
        books.put(3, new Book(3, "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", null));
        books.put(4, new Book(4, "Harry Potter and the Goblet of Fire", "J.K. Rowling", null));
        books.put(5, new Book(5, "Harry Potter and the Order of the Phoenix", "J.K. Rowling", null));
        books.put(6, new Book(6, "Harry Potter and the Half-Blood Prince", "J.K. Rowling", null));
        books.put(7, new Book(7, "Harry Potter and the Deathly Hallows", "J.K. Rowling", null));
    }


    @RequestMapping(path = "/{bookId}", method = RequestMethod.GET)
    public Object getBook(@PathVariable("bookId") Integer bookId, @RequestParam(required = false) Integer sleep) throws InterruptedException {
        log.info("GET /v5/book/{}", bookId);
        if (sleep != null) {
            Thread.sleep(sleep);
        }
        return books.get(bookId);
    }

}
