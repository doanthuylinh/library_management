/////////////////////////////////////////////////////////////////////////////
//
// © 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * [OVERVIEW] E-Book Entity.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/09      LinhDT       	  Create new
*/
@Entity
@Table(name = "e_book")
public class EBookEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "date_added_to_library")
    private String dateAddedToLibrary;

    @Column(name = "count_download")
    private Integer countDownload;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getDateAddedToLibrary() {
        return dateAddedToLibrary;
    }

    public void setDateAddedToLibrary(String dateAddedToLibrary) {
        this.dateAddedToLibrary = dateAddedToLibrary;
    }

    public Integer getCountDownload() {
        return countDownload;
    }

    public void setCountDownload(Integer countDownload) {
        this.countDownload = countDownload;
    }

    public EBookEntity() {
    }

}
