/////////////////////////////////////////////////////////////////////////////
//
// © 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.ResultBean;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * [OVERVIEW] Reservation Controller.
 *
 * @author: LinhDT
 * @version: 1.1
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/26      LinhDT             Create new
*/
@RestController
@RequestMapping(value = "/api")
public class HealthCheckController {

    private static final Logger LOGGER = LogManager.getLogger(HealthCheckController.class);

    /**
     * showWelcome
     * @author: LinhDT
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ResultBean> showWelcome() {
        ResultBean result = new ResultBean("200", "Library Management System API");

        return new ResponseEntity<ResultBean>(result, HttpStatus.OK);
    }

    /**
     * ping
     * @author: LinhDT
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<ResultBean> ping() throws InterruptedException {
        LOGGER.info("-----Some one PING me-----");
        ResultBean result = new ResultBean("200", "pong");
        return new ResponseEntity<ResultBean>(result, HttpStatus.OK);
    }
}
