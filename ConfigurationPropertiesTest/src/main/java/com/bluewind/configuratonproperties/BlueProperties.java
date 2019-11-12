package com.bluewind.configuratonproperties;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:blueprops.properties")
@ConfigurationProperties(prefix = "blue")
public class BlueProperties {
	String name;
	int age;
	double salary;
	
	List<String> courses;
	Map<String, String> books;
	Department department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public Map<String, String> getBooks() {
		return books;
	}

	public void setBooks(Map<String, String> books) {
		this.books = books;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "BlueProperties [name=" + name + ", age=" + age + ", salary=" + salary + ", courses=" + courses
				+ ", books=" + books + ", department=" + department + "]";
	}

}
