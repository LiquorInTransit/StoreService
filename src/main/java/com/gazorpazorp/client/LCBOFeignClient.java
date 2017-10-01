package com.gazorpazorp.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gazorpazorp.model.StoreListResult;

import feign.Headers;

@FeignClient(name="lcbo-client"/*, url="${lcbo-client.url}"*/) //Name can be custom name defined in bootstrap.yml, or the name of a service registered with eureka
public interface LCBOFeignClient {
	
	@GetMapping(value="/stores", consumes = "application/json")
	@Headers(value = { "Authorization: Token ${lcbo-client.key}", "Content-Type: application/json"})
	StoreListResult getStoresNearPoints(@RequestParam("lat")double latitude, @RequestParam("lon")double longitude);
}

