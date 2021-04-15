/////////////////////////////////////////////////////////////////////////////
//
// � 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * [OVERVIEW] Book Status.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/09      LinhDT       	  Create new
*/
@Entity
@Table(name = "book_status")
public class BookStatusEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_status_id")
    private Integer bookStatusId;

    @Column(name = "book_status_name")
    private String bookStatusName;

    public Integer getBookStatusId() {
        return bookStatusId;
    }

    public void setBookStatusId(Integer bookStatusId) {
        this.bookStatusId = bookStatusId;
    }

    public String getBookStatusName() {
        return bookStatusName;
    }

    public void setBookStatusName(String bookStatusName) {
        this.bookStatusName = bookStatusName;
    }

    public BookStatusEntity(Integer bookStatusId, String bookStatusName) {
        super();
        this.bookStatusId = bookStatusId;
        this.bookStatusName = bookStatusName;
    }

    public BookStatusEntity() {
        super();
    }

}
