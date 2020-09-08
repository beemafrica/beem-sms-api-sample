package com.dp.api.service;

import javax.management.ServiceNotFoundException;

import com.dp.api.model.MessageDetail;
import com.dp.api.model.MessageDetailResponse;
import com.dp.api.model.ReceivedMessage;
import com.dp.api.model.ResponseMessage;

import com.dp.api.model.AirtimeMessage;
import com.dp.api.model.AirtimeResponseMessage;

/**
 * SmsIntegrationService .
 * 
 * @author admin
 *
 */
public interface SmsIntegrationService {

	/**
	 *  getResponseFromDownstream .
	 *  
	 * @param request
	 * @return
	 */
	public ResponseMessage getResponseFromDownstream(ReceivedMessage request) throws ServiceNotFoundException;
	
	/**
	 * saveMessage .
	 * 
	 * @param request
	 * @return
	 */
	public MessageDetailResponse saveMessage(MessageDetail request);
	
}
