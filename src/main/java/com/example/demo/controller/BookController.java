/////////////////////////////////////////////////////////////////////////////
//
// � 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ResultBean;
import com.example.demo.service.BookService;
import com.example.demo.utils.ApiValidateException;

/**
 * [OVERVIEW] Book Controller.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/09      LinhDT       	  Create new
*/
@RestController
@RequestMapping(value = "/api")
public class BookController {

    @Autowired
    private BookService bookService;

    private static final Logger LOGGER = LogManager.getLogger(BookController.class);

    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    public ResponseEntity<ResultBean> getBookById(@PathVariable Integer bookId) {
        LOGGER.info("----------getBookById START----------");
        ResultBean entity = null;
        try {
            entity = bookService.getBookById(bookId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ResultBean>(entity, HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("----------getBookById END----------");
        return new ResponseEntity<ResultBean>(entity, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbookbyname", method = RequestMethod.GET)
    public ResponseEntity<ResultBean> getBookByName(@RequestBody String bookName) {
        LOGGER.info("----------getBookByName START----------");
        ResultBean resultBean = null;
        try {
            resultBean = bookService.getBookByName(bookName);
        } catch (ApiValidateException e) {
            return new ResponseEntity<ResultBean>(new ResultBean(e.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ResultBean>(new ResultBean("500", "Internal server error"), HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("----------getBookByName END----------");
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbookbyauthor", method = RequestMethod.GET)
    public ResponseEntity<ResultBean> getBookByAuthor(@RequestBody String author) {
        LOGGER.info("----------getBookByAuthor START----------");
        ResultBean resultBean = null;
        try {
            resultBean = bookService.getBookByAuthor(author);
        } catch (ApiValidateException e) {
            return new ResponseEntity<ResultBean>(new ResultBean(e.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ResultBean>(new ResultBean("500", "Internal server error"), HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("----------getBookByAuthor END----------");
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbookbycategory", method = RequestMethod.GET)
    public ResponseEntity<ResultBean> getBookByCategory(@RequestBody String category) {
        LOGGER.info("----------getBookByCategory START----------");
        ResultBean resultBean = null;
        try {
            resultBean = bookService.getBookByCategory(category);
        } catch (ApiValidateException e) {
            return new ResponseEntity<ResultBean>(new ResultBean(e.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ResultBean>(new ResultBean("500", "Internal server error"), HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("----------getBookByCategory END----------");
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }

    @RequestMapping(value = "/getbookbypublicationdate", method = RequestMethod.GET)
    public ResponseEntity<ResultBean> getBookByPublicationDate(@RequestBody String publicationDate) {
        LOGGER.info("----------getBookByPublicationDate START----------");
        ResultBean resultBean = null;
        try {
            resultBean = bookService.getBookByPublicationDate(publicationDate);
        } catch (ApiValidateException e) {
            return new ResponseEntity<ResultBean>(new ResultBean(e.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ResultBean>(new ResultBean("500", "Internal server error"), HttpStatus.BAD_REQUEST);
        }
        LOGGER.info("----------getBookByPublicationDate END----------");
        return new ResponseEntity<ResultBean>(resultBean, HttpStatus.OK);
    }
}
