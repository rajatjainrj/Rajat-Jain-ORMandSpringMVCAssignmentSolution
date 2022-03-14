package com.greatlearning.springcrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.springcrm.model.Customer;
import com.greatlearning.springcrm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list")
	public String getListOfCustomers(Model model) {
		return customerService.getListOfCustomers(model);
	}

	@RequestMapping("/show/form/for/add/update")
	public String showFormForAddUpdate(@RequestParam(required = false) Integer customerId, Model model) {
		return customerService.showFormForAddUpdate(customerId, model);
	}

	@RequestMapping("/save")
	public String saveCustomer(@ModelAttribute Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("customerId") Integer customerId) {
		return customerService.delete(customerId);
	}

}
