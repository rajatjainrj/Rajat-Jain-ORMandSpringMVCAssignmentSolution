package com.greatlearning.springcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.greatlearning.springcrm.model.Customer;
import com.greatlearning.springcrm.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String getListOfCustomers(Model model) {
		List<Customer> customerList = customerRepository.findAll();
		model.addAttribute("customers", customerList);
		return "list-customers";
	}

	@Override
	public String showFormForAddUpdate(Integer customerId, Model model) {
		Customer customer;
		if (customerId != null && customerId > 0) {
			customer = customerRepository.findById(customerId);
		} else {
			customer = new Customer();
		}
		model.addAttribute("customer", customer);
		return "customer-update-form";
	}

	@Override
	public String saveCustomer(Customer customer) {
		if (customer.getId() != null) {
			Customer customerDb = customerRepository.findById(customer.getId());
			customerDb.setEmail(customer.getEmail());
			customerDb.setFirstName(customer.getFirstName());
			customerDb.setLastName(customer.getLastName());
			customerRepository.save(customerDb);
		} else {
			customerRepository.save(customer);
		}
		return "redirect:/customer/list";
	}

	@Override
	public String delete(Integer customerId) {
		customerRepository.deleteById(customerId);
		return "redirect:/customer/list";
	}

}
