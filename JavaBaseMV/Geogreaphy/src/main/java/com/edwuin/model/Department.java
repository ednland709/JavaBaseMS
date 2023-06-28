package com.edwuin.model;

import java.io.Serializable;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Department implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic(optional=false)
	private String name;
	
	private String code;

}
