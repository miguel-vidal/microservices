package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
