package com.chenxing.book.rest.internal;

import com.chenxing.book.models.Book;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> getBook(@PathVariable("bookId") Integer bookId, @RequestParam(required = false) Integer sleep) throws InterruptedException {
        log.info("GET /v5/book/{} sleep:{}", bookId, sleep);
        if (sleep != null) {
            Thread.sleep(sleep);
        }
        Book book = books.get(bookId);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @Data
    private static class CreateBookBodyData extends Book {

        private Integer sleep;

    }

    @RequestMapping(path = "/{bookId}", method = RequestMethod.POST)
    public Object createBook(@PathVariable("bookId") Integer bookId, @RequestBody CreateBookBodyData body) throws InterruptedException {
        log.info("POST /v5/book/{} body:{}", bookId, body);
        if (body.getSleep() != null) {
            Thread.sleep(body.getSleep());
        }
        return body;
    }

    @RequestMapping(path = "/{bookId}", method = RequestMethod.PUT)
    public Object putBook(@PathVariable("bookId") Integer bookId, @RequestBody CreateBookBodyData body) throws InterruptedException {
        log.info("PUT /v5/book/{} body:{}", bookId, body);
        if (body.getSleep() != null) {
            Thread.sleep(body.getSleep());
        }
        return body;
    }

}
