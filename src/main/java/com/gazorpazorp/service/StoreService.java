package com.gazorpazorp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gazorpazorp.client.LCBOFeignClient;
import com.gazorpazorp.model.Store;

@Service
public class StoreService {
	Logger logger = LoggerFactory.getLogger(StoreService.class);

	@Autowired
	LCBOFeignClient lcboClient;
	
	public Store locateClosestStoreToCoords(double latitude, double longitude) {
		Store store = lcboClient.getStoresNearPoints(latitude, longitude).getResult().get(0);
		logger.warn("STORE_ID" + store.getId());
		return store;
	}
}
