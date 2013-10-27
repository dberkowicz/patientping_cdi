package com.patientping.snf.ejb;

import javax.ejb.Stateful;

@Stateful
public class GreeterEJB {
	public String sayHello(String name) {
		return "Hello " + name;
	}
}
