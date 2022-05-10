package com.edwuin.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.edwuin.model.City;

@FeignClient(name="geography-microservice", path="/geography")
public interface IGeographyClient {
	@GetMapping(value="/city/{id}")
	public City GetCityById(@PathVariable (name="id") Long id);

}
