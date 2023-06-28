package com.edwuin.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Person {
	
	private Long id;
	
	private String name;
	private String lastName;
	private Date birtday;
	private Long identification;
	private Long idCity;
	private String email;
	private String password;
}
