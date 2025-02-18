package SpringBootApplication.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import SpringBootApplication.binding.Course;
import SpringBootApplication.service.CourseService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
@Autowired
	private CourseService courseService;
	
@PostMapping("/course")
	public ResponseEntity<String >createCourse( @RequestBody Course course){
		String status =courseService.upsert(course);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
@GetMapping("/course/{cid}")
	public ResponseEntity<Course>getCourse(@PathVariable Integer cid){
	Course course=	courseService.getById(cid);
	return new ResponseEntity<>(course,HttpStatus.OK);
	}

@GetMapping("/course")
public ResponseEntity<List<Course>>getAllCourses(){
	List<Course>allCourses=courseService.getAllCourses();
	return new ResponseEntity<>(allCourses,HttpStatus.OK);
}


@PutMapping("/course")
public ResponseEntity<String >UpdateCourse( @RequestBody Course course){
	String status =courseService.upsert(course);
	return new ResponseEntity<>(status,HttpStatus.CREATED);
}

@DeleteMapping("/course/{cid}")
public ResponseEntity<String>deleteCourse(@PathVariable Integer cid){
String status=	courseService.deleteById(cid);
return new ResponseEntity<>(status,HttpStatus.OK);
}



}
