package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "number")
public class Number {

@Id
int id ;
int counter;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getCounter() {
	return counter;
}
public void setCounter(int counter) {
	this.counter = counter;
}

}
