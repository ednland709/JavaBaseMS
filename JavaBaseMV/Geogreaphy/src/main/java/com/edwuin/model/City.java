package com.edwuin.model;


import javax.persistence.*;

import lombok.*;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String name;
	
	private String code;
	
	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name="IdDepartment")
	private Department department;
	
	@Transient
	private String CodeCompose;
}
