package com.edwuin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class City {

	private Long id;
	
	private String name;
	
	private String code;
	
	private Department department;
}
