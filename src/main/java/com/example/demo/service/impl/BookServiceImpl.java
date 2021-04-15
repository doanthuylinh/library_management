/////////////////////////////////////////////////////////////////////////////
//
// � 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.service.impl;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.bean.BookEntity;
import com.example.demo.bean.ResultBean;
import com.example.demo.dao.BookDao;
import com.example.demo.response.BookResponse;
import com.example.demo.service.BookService;
import com.example.demo.utils.ApiValidateException;
import com.example.demo.utils.ConstantColumn;
import com.example.demo.utils.DataUtils;
import com.example.demo.utils.MessageUtils;
import com.example.demo.utils.Regex;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * [OVERVIEW] Book Service Implementation.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/15      LinhDT       	  Create new
*/
@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    private static final Logger LOGGER = LogManager.getLogger(BookServiceImpl.class);

    /**
     * getBookById
     * @author: LinhDT
     * @return
     */
    @Override
    public ResultBean getBookById(Integer bookId) {
        LOGGER.info("----------getBookById START----------");
        BookResponse entity = bookDao.getBookById(bookId);
        if (Objects.isNull(entity)) {
            return new ResultBean("ERR14", MessageUtils.getMessage("ERR14"));
        }
        LOGGER.info("----------getBookById END----------");
        return new ResultBean(entity, "200", MessageUtils.getMessage("MSG01", new Object[] { "book by ID" }));
    }

    /**
     * getBookByName
     * @author: LinhDT
     * @param json
     * @return
     * @throws ApiValidateException
     */
    public ResultBean getBookByName(String json) throws ApiValidateException {
        LOGGER.info("----------getBookByName START----------");
        JsonObject jObject = new Gson().fromJson(json, JsonObject.class);

        //Check whether book_name is null.
        if (DataUtils.isNullWithMemberNameByJson(jObject, ConstantColumn.BOOK_NAME)) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", new Object[] { ConstantColumn.BOOK_NAME }));
        }

        String bookName = DataUtils.getAsStringByJson(jObject, ConstantColumn.BOOK_NAME);

        BookResponse entity = bookDao.getBookByName(bookName);

        if (Objects.isNull(entity)) {
            return new ResultBean("ERR14", MessageUtils.getMessage("ERR14"));
        }

        LOGGER.info("----------getBookByName END----------");
        return new ResultBean(entity, "200", MessageUtils.getMessage("MSG01", new Object[] { "book by name" }));
    }

    /**
     * getBookByAuthor
     * @author: LinhDT
     * @param json
     * @return
     * @throws ApiValidateException
     */
    public ResultBean getBookByAuthor(String json) throws ApiValidateException {
        LOGGER.info("----------getBookByAuthor START----------");
        JsonObject jObject = new Gson().fromJson(json, JsonObject.class);

        //Check whether author is null.
        if (DataUtils.isNullWithMemberNameByJson(jObject, ConstantColumn.AUTHOR)) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", new Object[] { ConstantColumn.AUTHOR }));
        }

        String author = DataUtils.getAsStringByJson(jObject, ConstantColumn.AUTHOR);

        List<BookEntity> entity = bookDao.getBookByAuthor(author);
        if (Objects.isNull(entity)) {
            return new ResultBean("ERR14", MessageUtils.getMessage("ERR14"));
        }

        LOGGER.info("----------getBookByAuthor END----------");
        return new ResultBean(entity, "200", MessageUtils.getMessage("MSG01", new Object[] { "book(s) by author" }));
    }

    /**
     * getBookByCategory
     * @author: LinhDT
     * @param json
     * @return
     * @throws ApiValidateException
     */
    public ResultBean getBookByCategory(String json) throws ApiValidateException {
        LOGGER.info("----------getBookByCategory START----------");
        JsonObject jObject = new Gson().fromJson(json, JsonObject.class);

        //Check whether category is null.
        if (DataUtils.isNullWithMemberNameByJson(jObject, ConstantColumn.CATEGORY)) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", new Object[] { ConstantColumn.CATEGORY }));
        }

        String category = DataUtils.getAsStringByJson(jObject, ConstantColumn.CATEGORY);

        List<BookEntity> entity = bookDao.getBookByCategory(category);
        if (Objects.isNull(entity)) {
            return new ResultBean("ERR14", MessageUtils.getMessage("ERR14"));
        }

        LOGGER.info("----------getBookByCategory END----------");
        return new ResultBean(entity, "200", MessageUtils.getMessage("MSG01", new Object[] { "book(s) by category" }));
    }

    /**
     * getBookByPublicationDate
     * @author: LinhDT
     * @param json
     * @return
     * @throws ApiValidateException
     */
    public ResultBean getBookByPublicationDate(String json) throws ApiValidateException {
        LOGGER.info("----------getBookByPublicationDate START----------");
        JsonObject jObject = new Gson().fromJson(json, JsonObject.class);

        // Check whether publication date is null.
        if (DataUtils.isNullWithMemberNameByJson(jObject, ConstantColumn.PUBLICATION_DATE)) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", new Object[] { ConstantColumn.PUBLICATION_DATE }));
        }

        // Get publication date and check validation.
        String publicationDate = DataUtils.getAsStringByJson(jObject, ConstantColumn.PUBLICATION_DATE);
        if (!publicationDate.matches(Regex.DATE_PATTERN)) {
            throw new ApiValidateException("ERR10", MessageUtils.getMessage("ERR10", new Object[] { ConstantColumn.PUBLICATION_DATE }));
        }

        List<BookEntity> entity = bookDao.getBookByPublicationDate(publicationDate);
        if (Objects.isNull(entity)) {
            return new ResultBean("ERR14", MessageUtils.getMessage("ERR14"));
        }

        LOGGER.info("----------getBookByPublicationDate END----------");
        return new ResultBean(entity, "200", MessageUtils.getMessage("MSG01", new Object[] { "book(s) by publication date" }));
    }

}
