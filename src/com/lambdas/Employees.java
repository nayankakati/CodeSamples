package com.lambdas;

/**
 * Created by nayan.kakati on 4/23/18.
 */
public class Employees {
	private String name;
	private int age;

	public Employees(String name, int age) {
		this.name = name;
		this.age = age;
	}

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
}
