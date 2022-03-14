package com.greatlearning.springcrm.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.springcrm.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	CustomerRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = session.createQuery("from Customer").list();
		return customers;
	}

	@Override
	public Customer findById(int id) {
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void save(Customer customer) {
		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(customer);

		tx.commit();
	}

	@Override
	public void deleteById(int id) {
		Transaction tx = session.beginTransaction();

		// get transaction
		Customer customer = findById(id);

		// delete record
		session.delete(customer);

		tx.commit();
	}

}
