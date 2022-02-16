package com.userservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", length=50, unique=true)
	private String name;
	
	@Column(name="age")
	private int age;
	
	@Column(name="address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	@JsonIgnoreProperties("users")
	private Company company;
	
	public User() {}

}
