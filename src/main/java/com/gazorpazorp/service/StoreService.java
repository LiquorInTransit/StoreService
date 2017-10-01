package com.gazorpazorp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gazorpazorp.client.LCBOFeignClient;
import com.gazorpazorp.model.Store;

@Service
public class StoreService {

	@Autowired
	LCBOFeignClient lcboClient;
	
	public Store locateClosestStoreToCoords(double latitude, double longitude) {
		return lcboClient.getStoresNearPoints(latitude, longitude).getResult().stream().findFirst().get();
	}
}
