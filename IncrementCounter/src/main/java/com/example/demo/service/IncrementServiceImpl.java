package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IncrementRepo;
import com.example.demo.entity.Number;

@Service
public class IncrementServiceImpl implements IncrementService {

	
	@Autowired
	IncrementRepo irepo; 
	@Override
	public synchronized void incrementCounter(int id) {
		// TODO Auto-generated method stub
		
		try {
			Optional<Number> optionalNumber = irepo.findById(id);
			if (optionalNumber.isPresent()) {
				Number number = irepo.findById(id).orElse(null);
				number.setCounter(number.getCounter()+1);
				irepo.save(number);
			}
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public void setInitialValue(int id) {
		// TODO Auto-generated method stub
		boolean isAlreadyExist = irepo.existsById(id);
		try {
		if(!isAlreadyExist) {
			Number number = new Number();
			number.setId(id);
			number.setCounter(0);
			irepo.save(number);
		}
		else {
			System.out.println("number allready exist with the id" + id);
		}
				
		} catch (Exception e) {
			throw e;
		}

	}

}
