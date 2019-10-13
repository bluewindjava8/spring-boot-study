package com.bluewind.demo.component;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class ProdBean {
	@Override
	public String toString() {
		return "this is ProdBean";
	}
}
