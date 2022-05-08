package com.edwuin.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Basic(optional=false)
	private String name;
	
	private String code;

}
