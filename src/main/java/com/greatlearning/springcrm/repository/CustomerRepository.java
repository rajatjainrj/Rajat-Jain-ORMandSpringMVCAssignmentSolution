package com.greatlearning.springcrm.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.greatlearning.springcrm.model.Customer;

@Repository
public interface CustomerRepository {

	List<Customer> findAll();

	public Customer findById(int id);

	public void save(Customer customer);

	public void deleteById(int id);

}
