package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.IncrementService;

@RestController
public class IncrementController {
	
	@Autowired
	IncrementService incrementService;
	
	@PostMapping("/setinitialvalue")
	public  ResponseEntity<String> setInitialValue(@RequestParam(value = "id") int id) {
			
			try {
				incrementService.setInitialValue(id);
			} catch (Exception e) {
				return new ResponseEntity<String>("Exception occurred while setting the initial value of Number", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>("Initial value set for Number ", HttpStatus.OK);
	}

	@PostMapping("/increase")
	public ResponseEntity<String> increase(@RequestParam(value = "id") int id) {
			
			try {
				incrementService.incrementCounter(id);
			} catch (Exception e) {
				return new ResponseEntity<String>("Exception occurred while setting the initial value of Number", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>("Increment Successful", HttpStatus.OK);
}
}
