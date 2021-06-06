/////////////////////////////////////////////////////////////////////////////
//
// © 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.utils;

import com.example.demo.bean.BookEntity;
import com.example.demo.bean.BookItemEntity;
import com.example.demo.bean.UserEntity;
import com.example.demo.exception.ApiValidateException;
import com.google.gson.JsonObject;

/**
 * [OVERVIEW] Validate Utils.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/09      LinhDT             Create new
 * 001       1.1       2021/06/01      LinhDT             Update validations
*/
public class ValidateUtils {

    /**
     * validateDataBody
     * @author: LinhDT
     * @param data
     * @throws ApiValidateException
     */
    public static void validateDataBody(String data) throws ApiValidateException {
        if (DataUtils.isNullOrEmpty(data)) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", "Data is not null"));
        }
    }

    /**
     * validateUpdateBook
     * @author: LinhDT
     * @param book
     * @throws ApiValidateException
     */
    public static void validateUpdateBook(BookEntity book) throws ApiValidateException {
        if (DataUtils.isNullOrEmpty(book.getBookId())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", "book_id"));
        }

        validateAddBook(book);
    }

    /**
     * validateAddBook
     * @author: LinhDT
     * @param book
     * @throws ApiValidateException
     */
    public static void validateAddBook(BookEntity book) throws ApiValidateException {

        if (DataUtils.isNullOrEmpty(book.getBookName())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", "book_name"));
        }

        if (DataUtils.isNullOrEmpty(book.getDescription())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", "description"));
        }

        if (DataUtils.isNullOrEmpty(book.getAuthor())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", "author"));
        }
    }

    /**
     * validateUpdateBookItem
     * @author: LinhDT
     * @param bookItem
     * @throws ApiValidateException
     */
    public static void validateUpdateBookItem(BookItemEntity bookItem) throws ApiValidateException {
        if (DataUtils.isNullOrEmpty(bookItem.getBookItemId())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", "book__item_id"));
        }

        validateAddBookItem(bookItem);
    }

    /**
     * validateAddBookItem
     * @author: LinhDT
     * @param bookItem
     * @throws ApiValidateException
     */
    public static void validateAddBookItem(BookItemEntity bookItem) throws ApiValidateException {
        if (DataUtils.isNullOrEmpty(bookItem.getBookId())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", "book_id"));
        }

        if (DataUtils.isNullOrEmpty(bookItem.getBarcode())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", "barcode"));
        }
    }

    /**
     * validateAddUser
     * @author: LinhDT
     * @param userEntity
     * @param userRole
     * @throws ApiValidateException
     */
    public static void validateAddUser(UserEntity userEntity) throws ApiValidateException {

        if (DataUtils.isNullOrEmpty(userEntity.getUsername())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", ConstantColumn.USERNAME));
        }

        if (!userEntity.getUsername().matches(Regex.NAME_PATTERN)) {
            throw new ApiValidateException("ERR06", MessageUtils.getMessage("ERR06"));
        }

        if (DataUtils.isNullOrEmpty(userEntity.getPassword())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", ConstantColumn.PASSWORD));
        }

        if (!userEntity.getPassword().matches(Regex.PASSWORD_PATTERN)) {
            throw new ApiValidateException("ERR07", MessageUtils.getMessage("ERR07"));
        }

        if (DataUtils.isNullOrEmpty(userEntity.getEmail())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", ConstantColumn.EMAIL));
        }

        if (!userEntity.getEmail().matches(Regex.EMAIL_PATTERN)) {
            throw new ApiValidateException("ERR08", MessageUtils.getMessage("ERR08"));
        }

        if (DataUtils.isNullOrEmpty(userEntity.getPhone())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", ConstantColumn.PHONE));
        }

        if (!userEntity.getPhone().matches(Regex.PHONE_PATTERN)) {
            throw new ApiValidateException("ERR09", MessageUtils.getMessage("ERR09"));
        }

        if (userEntity.getRole() == null) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", ConstantColumn.ROLE));
        }
    }

    /**
     * validateUpdateUser
     * @author: LinhDT
     * @param userEntity
     * @throws ApiValidateException
     */
    public static void validateUpdateUser(UserEntity userEntity) throws ApiValidateException {

        if (DataUtils.isNullOrEmpty(userEntity.getEmail())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", ConstantColumn.EMAIL));
        }

        if (!userEntity.getEmail().matches(Regex.EMAIL_PATTERN)) {
            throw new ApiValidateException("ERR08", MessageUtils.getMessage("ERR08"));
        }

        if (DataUtils.isNullOrEmpty(userEntity.getPhone())) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", ConstantColumn.PHONE));
        }

        if (!userEntity.getPhone().matches(Regex.PHONE_PATTERN)) {
            throw new ApiValidateException("ERR09", MessageUtils.getMessage("ERR09"));
        }
    }

    /**
     * validateIssueBook
     * @author: LinhDT
     * @param obj
     * @throws ApiValidateException
     */
    public static void validateIssueBook(JsonObject obj) throws ApiValidateException {
        if (DataUtils.isNullOrEmpty(obj.get(ConstantColumn.RESERVATION_ID))) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", ConstantColumn.RESERVATION_ID));
        }
    }

    /**
     * validateCancelBorrowingReservation
     * @author: LinhDT
     * @param obj
     * @throws ApiValidateException
     */
    public static void validateCancelBorrowingReservation(JsonObject obj) throws ApiValidateException {
        if (DataUtils.isNullOrEmpty(obj.get(ConstantColumn.RESERVATION_ID))) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", ConstantColumn.RESERVATION_ID));
        }
    }

    /**
     * validateAddReservationItem
     * @author: LinhDT
     * @param obj
     * @throws ApiValidateException
     */
    public static void validateReservationItem(JsonObject obj) throws ApiValidateException {

        if (DataUtils.isNullOrEmpty(obj.get(ConstantColumn.USER_ID))) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", ConstantColumn.USER_ID));
        }

        if (DataUtils.isNullOrEmpty(obj.get(ConstantColumn.BOOK_ID))) {
            throw new ApiValidateException("ERR04", MessageUtils.getMessage("ERR04", ConstantColumn.BOOK_ID));
        }
    }
}
