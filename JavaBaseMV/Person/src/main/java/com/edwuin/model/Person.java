package com.edwuin.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
	@Pattern(regexp = """
            [A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.\
            [A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@\
            (?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9]\
            (?:[A-Za-z0-9-]*[A-Za-z0-9])?\
            """,
	        message = "{invalid.email}")
	private String email;
	
	private String password;
	
	@Transient
	private City city;
}
