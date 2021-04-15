/////////////////////////////////////////////////////////////////////////////
//
// � 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [OVERVIEW] Book Item Response.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/15      LinhDT       	  Create new
*/
public class BookItemResponse extends BookResponse {

    @JsonProperty("barcode")
    private String barcode;
    @JsonProperty("date_of_purchase")
    private String dateOfPurchase;
    @JsonProperty("date_added_to_library")
    private String dateAddedToLibrary;
    @JsonProperty("location")
    private String location;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("book_status_name")
    private String bookStatusName;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getDateAddedToLibrary() {
        return dateAddedToLibrary;
    }

    public void setDateAddedToLibrary(String dateAddedToLibrary) {
        this.dateAddedToLibrary = dateAddedToLibrary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBookStatusName() {
        return bookStatusName;
    }

    public void setBookStatusName(String bookStatusName) {
        this.bookStatusName = bookStatusName;
    }

    public BookItemResponse(Integer bookId, String bookName, String description, String language, String bookAuthor, String categoryName, String departmentName,
            Integer quantity, String bookTypeName, String publicationDate, String barcode, String dateOfPurchase, String dateAddedToLibrary, String location,
            Double price, String bookStatusName) {
        super(bookId, bookName, description, language, bookAuthor, categoryName, departmentName, quantity, bookTypeName, publicationDate);
        this.barcode = barcode;
        this.dateOfPurchase = dateOfPurchase;
        this.dateAddedToLibrary = dateAddedToLibrary;
        this.location = location;
        this.price = price;
        this.bookStatusName = bookStatusName;
    }

    public BookItemResponse(Integer bookId, String bookName, String description, String language, String bookAuthor, String categoryName, String departmentName,
            Integer quantity, String bookTypeName, String publicationDate) {
        super(bookId, bookName, description, language, bookAuthor, categoryName, departmentName, quantity, bookTypeName, publicationDate);
    }

    @Override
    public String toString() {
        return "BookItemResponse [barcode=" + barcode + ", dateOfPurchase=" + dateOfPurchase + ", dateAddedToLibrary=" + dateAddedToLibrary + ", location="
                + location + ", price=" + price + ", bookStatusName=" + bookStatusName + ", bookId=" + bookId + ", bookName=" + bookName + ", description="
                + description + ", language=" + language + ", bookAuthor=" + bookAuthor + ", categoryName=" + categoryName + ", departmentName="
                + departmentName + ", quantity=" + quantity + ", bookTypeName=" + bookTypeName + ", publicationDate=" + publicationDate + "]";
    }

}
