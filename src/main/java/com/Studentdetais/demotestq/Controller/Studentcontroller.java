package com.Studentdetais.demotestq.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Studentdetais.demotestq.Student.Student;
import com.Studentdetais.demotestq.StudentResource.StudentResource;

@Controller
//@RequestMapping("index")
public class Studentcontroller {

	@Autowired
	private StudentResource resource;
	
@GetMapping("/Students")	
public ResponseEntity<List<Student>> listofallstudents() {
	
	return new  ResponseEntity<> (resource.listofallstudents(),HttpStatus.OK);
}	
@GetMapping("Students/{id}")
public ResponseEntity<Student> findstudent(@PathVariable int id) {
	return new ResponseEntity<>(resource.findbyid(id),HttpStatus.OK);
	
}

@PostMapping("Students")
public ResponseEntity<Student> createstudent(@RequestBody Student student){
	
	return new ResponseEntity<>(resource.addstudent(student),HttpStatus.CREATED);
	
	
}
@PutMapping("Students/{id}")
public ResponseEntity<String> updatestudent(@PathVariable int id, @RequestBody Student student) {
	resource.updatestudent(id, student);
	return new ResponseEntity<>("createdsuccesfully",HttpStatus.OK);
}
@PatchMapping("Students")
public ResponseEntity<Student> updatepartial(@RequestBody Student student) {
	
	return new  ResponseEntity<>(resource.updatepartial(student),HttpStatus.CREATED);
	
}
@DeleteMapping("Students/{id}")
public ResponseEntity<String> deletestudentbyid(@PathVariable int id){
	resource.deleteuserbyid(id);
	
	return new ResponseEntity<>("deleted succesfully",HttpStatus.OK);
	}
@DeleteMapping("Students")
public ResponseEntity<String> deleteallstudent() {
	resource.deleteall();
	return new ResponseEntity<>("Deleted all user",HttpStatus.OK);
}

@GetMapping("Studentsview")
public String allstudents(Model model) {
	resource.listofallstudents();
	model.addAttribute("Students",resource.listofallstudents());
	return "Home";
}
@GetMapping("Addstudent")
public String addNewEmployee(Model model) {
    Student st = new Student();
  model.addAttribute("Student",st);
    return "AddNew";
}
@PostMapping("save")
public String saveemployee(@ModelAttribute("Student") Student st ) {
	resource.addstudent(st);
	return "redirect:Studentsview";
	
}
}

