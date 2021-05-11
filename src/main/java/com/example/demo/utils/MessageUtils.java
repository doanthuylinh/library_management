/////////////////////////////////////////////////////////////////////////////
//
// © 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.utils;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * [OVERVIEW] Get messages from file properties.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/06      LinhDT             Create new
*/
public class MessageUtils {

    /**
     * getMessage
     * @author: LinhDT
     * @param key
     * @param param
     * @return
     */
    public static String getMessage(String key, Object... param) {
        ResourceBundle rsMessages;
        // Load all message from message.properties
        rsMessages = ResourceBundle.getBundle("message");

        String message;
        try {
            // Get message from rsMessages
            message = rsMessages.getString(key);
            if (message.length() == 0) {
                return key;
            }
            // Replace param
            if (param != null && param.length > 0) {
                message = MessageFormat.format(message, param);
            }
        } catch (MissingResourceException e) {
            message = key;
        }
        // return content
        return message;
    }

    /**
     * getLink
     * @author: LinhDT
     * @param key
     * @param param
     * @return
     */
    public static String getLink(String key, Object... param) {
        ResourceBundle rsMessages;
        // Load all message from link.properties
        rsMessages = ResourceBundle.getBundle("link");

        String message;
        try {
            // Get message from rsMessages
            message = rsMessages.getString(key);
            if (message.length() == 0) {
                return key;
            }
            // Replace param
            if (param != null && param.length > 0) {
                message = MessageFormat.format(message, param);
            }
        } catch (MissingResourceException e) {
            message = key;
        }
        // return content
        return message;
    }

}
