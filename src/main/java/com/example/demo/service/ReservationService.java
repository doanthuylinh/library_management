package com.example.demo.service;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;

import com.example.demo.bean.ReservationEntity;
import com.example.demo.bean.ResultBean;
import com.example.demo.data.ReservationStatus;
import com.example.demo.exception.ApiValidateException;
import com.example.demo.exception.AuthenticateException;
import com.example.demo.exception.LibException;

public interface ReservationService {
	public ResultBean addReservation(ReservationEntity entity) throws ApiValidateException;
	
	public ResultBean updateReservation(ReservationEntity entity) throws ApiValidateException;

	@PreAuthorize("hasAuthority('ADMIN')")
	ResultBean getReservationWithStatus(Integer status) throws ApiValidateException, AccessDeniedException;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	ResultBean getReservationWithStatus(ReservationStatus status) throws ApiValidateException, AccessDeniedException;
	
	@PreAuthorize("hasAuthority('MEMBER')")
	ResultBean borrowReservation(Integer reservationId) throws LibException, AccessDeniedException;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	ResultBean issueReservation(Integer reservationId) throws LibException, AccessDeniedException;
	
	@PreAuthorize("hasAuthority('ADMIN')")
	ResultBean returnReservation(Integer reservationId) throws LibException, AccessDeniedException;
	
	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MEMBER')")
	ResultBean cancelBorrowingReservation(Integer reservationId) throws LibException, AccessDeniedException;
	
	ResultBean addItemReservation(ReservationEntity entity, Integer bookId) throws ApiValidateException;
	
	ResultBean addItemReservation(Integer userId, Integer bookId) throws LibException;
	
	ResultBean removeItemReservation(Integer userId, Integer bookId, Integer amount) throws ApiValidateException, AuthenticateException;

	ResultBean removeItemReservation(ReservationEntity entity, Integer bookId, Integer amount)
			throws ApiValidateException;
	
	ResultBean removeItemReservation(ReservationEntity entity, Integer bookId) throws ApiValidateException;

	ResultBean getReservationByUserId(Integer userId) throws ApiValidateException;
	
	ResultBean getReservationWithStatusByUserId(Integer userId, ReservationStatus status) throws ApiValidateException;

	ResultBean getReservationWithStatusByUserId(Integer userId, Integer status) throws ApiValidateException;
}
