package com.bluewind.demo.component;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class DevBean {
	@Override
	public String toString() {
		return "this is DevBean";
	}
}
