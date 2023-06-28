package com.edwuin.model;


import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class City implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String code;
	
	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name="IdDepartment")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Department department;
	
	@Transient
	private String CodeCompose;
}
