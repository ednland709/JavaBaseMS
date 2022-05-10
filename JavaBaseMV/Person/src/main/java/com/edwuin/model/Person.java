package com.edwuin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotNull(message="{name.required}")
	private String name;
	@NotNull(message="{lastname.required}")
	private String lastName;
	@NotNull(message="{birtdaty.required}")
	private Date birtday;
	@NotNull(message="{identification.required}")
	private Long identification;
	@NotNull(message="{city.required}")
	private Long idCity;

	@NotNull(message="{email.required}")
	@Pattern(regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
	        + "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
	        + "(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9]"
	        + "(?:[A-Za-z0-9-]*[A-Za-z0-9])?",
	        message = "{invalid.email}")
	private String email;
	
	private String password;
	
	@Transient
	private City city;
}
