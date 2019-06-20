package com.cadmoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadmoney.api.model.Category;

public interface CategoriesRepository extends JpaRepository<Category, Long> 
{

}
