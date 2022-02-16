package com.userservice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name="companies")
public class Company {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_id")
	private Long id;
	
	@Column(name="company_name")
	private String company;
	
	@Column(name="address")
	private String addresss;
	
	@OneToMany(mappedBy="company")
	@JsonIgnoreProperties("users")
	private List<User> users;
	
	public Company() {}
}
