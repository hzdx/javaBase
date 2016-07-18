package io;

import java.io.Serializable;

public class Person implements Serializable {
	public static final long serialVersionUID = 42L;
	static String country = "cn";
	private String name;
	transient int age;

	Person(String name, int age, String country) {
		this.name = name;
		this.age = age;
		Person.country = country;
	}

	@Override
	public String toString() {
		return name + "..." + age + "..." + country;
	}

}