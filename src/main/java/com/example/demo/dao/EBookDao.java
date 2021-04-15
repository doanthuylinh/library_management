/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.EBookEntity;
import com.example.demo.response.EBookResponse;

/**
 * [OVERVIEW] E-Book Data Object Access.
 *
 * @author: (VNEXT)LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2020/07/24      (VNEXT)LinhDT       Create new
*/
public interface EBookDao {

    /**
     * downloadEBookById
     * @author: (VNEXT)LinhDT
     * @param bookId
     * @return
     */
    public EBookResponse downloadEBookById(Integer bookId);

    /**
     * getListEBooks
     * @author: (VNEXT)LinhDT
     * @return
     */
    public List<EBookEntity> getListEBooks();
}
