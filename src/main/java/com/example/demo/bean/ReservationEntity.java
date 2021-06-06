/////////////////////////////////////////////////////////////////////////////
//
// © 2021 IDTU-CS3332IRFA-21TSP
//
/////////////////////////////////////////////////////////////////////////////

package com.example.demo.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.example.demo.data.ReservationStatus;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * [OVERVIEW] Reservation Entity.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/04/21      LinhDT             Create new
*/
@Entity
@Table(name = "Reservation")
public class ReservationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    @SerializedName("reservation_id")
    @JsonProperty("reservation_id")
    private Integer reservationId;

    @Column(name = "user_id")
    @SerializedName("user_id")
    @JsonProperty("user_id")
    private Integer userId;

    @Column(name = "reserved_time")
    @SerializedName("reserved_time")
    @JsonProperty("reserved_time")
    private Date reservedTime;

    @Column(name = "expected_return_date")
    @SerializedName("expected_return_date")
    @JsonProperty("expected_return_date")
    private Date expectedReturnDate;

    @Column(name = "returned_date")
    @SerializedName("returned_date")
    @JsonProperty("returned_date")
    private Date returnedDate;

    @Column(name = "total_fee", columnDefinition = "double default 0")
    @SerializedName("total_fee")
    @JsonProperty("total_fee")
    private Double totalFee;

    @Column(name = "created_time")
    @SerializedName("created_time")
    @JsonProperty("created_time")
    private Date createdTime;

    @Column(name = "status")
    @SerializedName("status")
    @JsonProperty("status")
    private Integer status;
    
    @Column(name = "is_extended")
    @SerializedName("is_extended")
    @JsonProperty("is_extended")
    private Boolean isExtended;

	@ManyToMany
    @JoinColumn(name = "book_item_id")
    @SerializedName("book_items")
    @JsonProperty("book_items")
    private List<BookItemEntity> bookItemEntities;

    @SerializedName("book_entities")
    @Transient
    @JsonIgnore
    private List<BookEntity> bookEntities;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @JsonProperty("user")
    @JsonInclude(Include.NON_NULL)
    private UserEntity userEntity;

    public List<BookEntity> getBookEntities() {
        return bookEntities;
    }

    public void setBookEntities(List<BookEntity> bookEntities) {
        this.bookEntities = bookEntities;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public List<BookItemEntity> getBookItemEntities() {
        return bookItemEntities;
    }

    public void setBookItemEntities(List<BookItemEntity> bookItemEntities) {
        this.bookItemEntities = bookItemEntities;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getReservedTime() {
        return reservedTime;
    }

    @JsonGetter("reserved_time")
    public String getReservedTimeValue() {
    	if (reservedTime == null) return null;
    	
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateValue = df.format(reservedTime);
        return dateValue;
    }

    public void setReservedTime(Date reservedTime) {
        this.reservedTime = reservedTime;
    }

    public Date getExpectedReturnDate() {
        return expectedReturnDate;
    }
    
    @JsonGetter("expected_return_date")
    public String getExpectedReturnDateValue() {
    	if (expectedReturnDate == null) return null; 
    	
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateValue = df.format(expectedReturnDate);
        return dateValue;
    }

    public void setExpectedReturnDate(Date expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }
    
    @JsonGetter("returned_date")
    public String getReturnedDateValue() {
    	if (returnedDate == null) return null;
    	
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateValue = df.format(returnedDate);
        return dateValue;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    public Date getCreatedTime() {
		if (this.createdTime == null) {
			this.createdTime = new Date();
		}
    	
        return this.createdTime;
    }
    
    @JsonGetter("created_time")
    public String getCreatedTimeValue() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateValue = df.format(getCreatedTime());
        return dateValue;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public ReservationStatus getStatus() {
        return ReservationStatus.parse(this.status);
    }
    
    @JsonGetter("status")
    public Integer getStatusValue() {
    	return this.status; 
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status.value();
    }

    public Boolean getIsExtended() {
    	if (isExtended == null)
    		return false;
    	
		return isExtended;
	}

	public void setIsExtended(Boolean isExtended) {
		this.isExtended = isExtended;
	}
    
    public ReservationEntity(Integer reservationId, Integer userId, Date reservedTime, Date expectedReturnDate, Date returnedDate, Double totalFee,
            Date createdTime, Integer status) {
        super();
        this.reservationId = reservationId;
        this.userId = userId;
        this.reservedTime = reservedTime;
        this.expectedReturnDate = expectedReturnDate;
        this.returnedDate = returnedDate;
        this.totalFee = totalFee;
        this.createdTime = createdTime;
        this.status = status;
    }

    public ReservationEntity() {
        super();
    }

}
