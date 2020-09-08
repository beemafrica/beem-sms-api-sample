package com.dp.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dp.api.constants.SystemConstants;
import com.dp.api.model.MessageDetail;
import com.dp.api.model.MessageDetailResponse;
import com.dp.api.model.ReceivedMessage;
import com.dp.api.model.AirtimeMessage;
import com.dp.api.model.ResponseMessage;
import com.dp.api.service.SmsIntegrationService;


/**
 * SmsController .
 * 
 * @author admin
 *
 */
@RestController
@CrossOrigin(exposedHeaders = "Content-Disposition")
public class SmsController {

    Logger logger = LoggerFactory.getLogger(SmsController.class);

    @Autowired
    private SmsIntegrationService smsIntegrationService;
    
    
	/**
	 * restApiCall.
	 *
	 * @param requestHeader the requestHeader
	 * @param request       the request
	 * @return ResponseEntity< CreateUserResponse >
	 * @throws Exception
	 */
	@RequestMapping(value = SystemConstants.SMS_INTEGRATION_CALL, method = RequestMethod.POST)
	public ResponseEntity<ResponseMessage> restApiCall(@RequestBody ReceivedMessage request) throws Exception {

		ResponseMessage response = new ResponseMessage();
		logger.info("Request Receiver from API : {}" ,request.getMessage());
		response = smsIntegrationService.getResponseFromDownstream(request);
		logger.info("Response sent from API : {}" ,response.getCode());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
	/**
	 * restApiCall.
	 *
	 * @param requestHeader the requestHeader
	 * @param request       the request
	 * @return ResponseEntity< CreateUserResponse >
	 * @throws Exception
	 */
	@RequestMapping(value = SystemConstants.SMS_CALLBACK, method = RequestMethod.POST)
	public ResponseEntity<MessageDetailResponse> saveSmsDetails(@RequestBody MessageDetail request) throws Exception {

		MessageDetailResponse response = new MessageDetailResponse();
		logger.info("Request Receiver from API : {}" ,request.getRequest_id());
		response = smsIntegrationService.saveMessage(request);
		logger.info("Response sent from API : {}" ,response.getId());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	

}
