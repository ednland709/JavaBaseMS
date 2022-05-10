package com.edwuin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="{user.required}")
	private Long userId;
	
	@NotNull(message="{name.required}")
	private int type;
	
	@NotNull(message="{name.required}")
	private String description;
	
}
