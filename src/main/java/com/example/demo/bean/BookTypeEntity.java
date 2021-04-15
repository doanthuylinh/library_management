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
 * [OVERVIEW] Category Entity.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/09      LinhDT       	  Create new
*/
@Entity
@Table(name = "book_type")
public class BookTypeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_type_id")
    private Character bookTypeId;

    @Column(name = "book_type_name")
    private String bookTypeName;

    public Character getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(Character bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    public String getBookTypeName() {
        return bookTypeName;
    }

    public void setBookTypeName(String bookTypeName) {
        this.bookTypeName = bookTypeName;
    }

    @Override
    public String toString() {
        return "BookTypeEntity [bookTypeId=" + bookTypeId + ", bookTypeName=" + bookTypeName + "]";
    }

    public BookTypeEntity(Character bookTypeId, String bookTypeName) {
        super();
        this.bookTypeId = bookTypeId;
        this.bookTypeName = bookTypeName;
    }

    public BookTypeEntity() {
        super();
    }

}
