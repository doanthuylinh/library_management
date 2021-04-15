/////////////////////////////////////////////////////////////////////////////
//
// � 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [OVERVIEW] BookResponse.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/15      LinhDT       	  Create new
*/
public class BookResponse {

    @JsonProperty("book_id")
    protected Integer bookId;
    @JsonProperty("book_name")
    protected String bookName;
    @JsonProperty("description")
    protected String description;
    @JsonProperty("language")
    protected String language;
    @JsonProperty("book_author")
    protected String bookAuthor;
    @JsonProperty("category_name")
    protected String categoryName;
    @JsonProperty("department_name")
    protected String departmentName;
    @JsonProperty("quantity")
    protected Integer quantity;
    @JsonProperty("book_type_name")
    protected String bookTypeName;
    @JsonProperty("publication_date")
    protected String publicationDate;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public BookResponse() {
        super();
    }

    public BookResponse(Integer bookId, String bookName, String description, String language, String bookAuthor, String categoryName, String departmentName,
            Integer quantity, String bookTypeName, String publicationDate) {
        super();
        this.bookId = bookId;
        this.bookName = bookName;
        this.description = description;
        this.language = language;
        this.bookAuthor = bookAuthor;
        this.categoryName = categoryName;
        this.departmentName = departmentName;
        this.quantity = quantity;
        this.bookTypeName = bookTypeName;
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "BookResponse [bookId=" + bookId + ", bookName=" + bookName + ", description=" + description + ", language=" + language + ", bookAuthor="
                + bookAuthor + ", categoryName=" + categoryName + ", departmentName=" + departmentName + ", quantity=" + quantity + ", bookTypeName="
                + bookTypeName + ", publicationDate=" + publicationDate + "]";
    }

}
