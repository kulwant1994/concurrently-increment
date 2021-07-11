package com.example.demo.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
public interface IncrementService {

	/**
	 * Increasing the value of counter.
	 * Transactional annotation used to ensure all the process involved in the function executes as single transaction or it gets rollback.
	 * Pessimistic locking is used to ensure to get a write lock on the counter, while fetching it from database.
	 
	 * @param id
	 */
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void incrementCounter(int id);
	
	
	/**
	 * Sets the initial value for the counter.
	 * @param id
	 */
	public void setInitialValue(int id);
}
