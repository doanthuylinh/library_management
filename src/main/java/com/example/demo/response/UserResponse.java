/////////////////////////////////////////////////////////////////////////////
//
// © 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.response;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.demo.bean.UserEntity;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * [OVERVIEW] User Response.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/15      LinhDT             Create new
*/
public class UserResponse {

    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("dob")
    private Date dob;
    @JsonProperty("address")
    private String address;
    @JsonProperty("role")
    private Integer role;
    @JsonProperty("token")
    private String token;
    @JsonProperty("token_type")
    private String tokenType;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    @JsonGetter("dob")
    public String getDobValue() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateValue = df.format(dob);
        return dateValue;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public UserResponse(Integer userId, String username, String email, String phone, Date dob, String address, Integer role) {
        super();
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.dob = dob;
        this.address = address;
        this.role = role;
    }

    public UserResponse(UserEntity entity) {
        this.userId = entity.getUserId();
        this.address = entity.getAddress();
        this.dob = entity.getDob();
        this.email = entity.getEmail();
        this.phone = entity.getPhone();
        this.username = entity.getUsername();
        this.role = entity.getRole().value();
    }

}
