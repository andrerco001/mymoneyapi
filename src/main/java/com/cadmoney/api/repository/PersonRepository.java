package com.cadmoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadmoney.api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long>
{

}
