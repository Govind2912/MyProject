package com.Studentdetais.demotestq.Student;

public class Student {

	private Integer id;
	private String name;
	private Integer age;
	private String group;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public Student(Integer id, String name, Integer age, String group) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.group = group;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
}
