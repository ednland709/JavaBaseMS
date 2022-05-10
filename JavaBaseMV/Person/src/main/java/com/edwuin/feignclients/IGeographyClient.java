package com.edwuin.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edwuin.model.City;

@FeignClient(name="geography-service", path="/geography")
public interface IGeographyClient {
	@GetMapping(value="/{id}")
	public City GetCityById(@RequestParam (name="id", required = true) Long id);

}
