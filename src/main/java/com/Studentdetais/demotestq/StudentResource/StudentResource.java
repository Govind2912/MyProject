package com.Studentdetais.demotestq.StudentResource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.Studentdetais.demotestq.Student.Student;

@Component
public class StudentResource {
	
private static List<Student> ll=new ArrayList<Student>	();

static
{
ll.add(new Student(1,"Govinda Raj ",25,"ECE"));
ll.add(new Student(2,"Govinda Raj ",28,"CSE"));
ll.add(new Student(3,"Govinda Raj ",29,"CIVIL"));
ll.add(new Student(5,"Govinda Raj ",27,"MECH"));
ll.add(new Student(6,"Govinda Raj ",26,"IT"));
ll.add(new Student(6,"Govinda Raj ",26,"IT"));
ll.add(new Student(6,"Govinda Raj ",26,"IT"));
ll.add(new Student(6,"Govinda Raj ",26,"IT"));
ll.add(new Student(6,"Govinda Raj ",26,"IT"));
ll.add(new Student(6,"Govinda Raj ",26,"IT"));
ll.add(new Student(6,"Govinda Raj ",26,"IT"));


	}

public List<Student> listofallstudents(){
	return ll;
}

public Student findbyid(int id) {
	return ll.stream().filter(i -> (i.getId()==id)).findFirst().orElseThrow(() -> new RuntimeException("No such "+id+" found"));
	
}
public Student addstudent(Student student) {
	 ll.add(student);
	return student;
	
}
public void updatestudent(int id, Student updatedstudent) {
	
	for(Student s:ll) {
		if(s.getId()==id) {
			s.setId(updatedstudent.getId());
		s.setName(updatedstudent.getName());
		s.setAge(updatedstudent.getAge());
		s.setGroup(updatedstudent.getGroup());
		}
	}
}
public Student  updatepartial(Student student) {
	return ll.stream().filter(e -> e.getId()==student.getId()).findFirst().map(d ->{
		if(student.getId()!=null) {
			d.setId(student.getId());
		}
			if(student.getAge()!=null) {
				d.setAge(student.getAge());
			}
				if(student.getName()!=null) {
					d.setName(student.getName());
				}
					if(student.getGroup()!=null) {
						d.setGroup(student.getGroup());
					}
					return d;
				}).orElseThrow(()->new RuntimeException("Student not found"));
	
	
	
}
public void deleteuserbyid(int id) {
	ll.removeIf(e ->e.getId()==id);
}
public void deleteall() {
	ll.removeAll(ll);
}
}

