package com.greatlearning.springcrm.service;

import org.springframework.ui.Model;

import com.greatlearning.springcrm.model.Customer;

public interface CustomerService {

	String getListOfCustomers(Model model);

	String showFormForAddUpdate(Integer customerId, Model model);

	String saveCustomer(Customer customer);

	String delete(Integer customerId);

}
