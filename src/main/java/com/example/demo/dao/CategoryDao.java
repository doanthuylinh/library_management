/////////////////////////////////////////////////////////////////////////////
//
// © 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.dao;

import java.util.List;

import com.example.demo.bean.CategoryEntity;

/**
 * [OVERVIEW] Book Item Data Object Access.
 *s
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/17      LinhDT       	  Create new
*/
public interface CategoryDao {

    /**
     * getListCategories
     * @author: LinhDT
     * @return
     */
    public List<CategoryEntity> getListCategories();
}