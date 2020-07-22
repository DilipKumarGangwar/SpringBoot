package com.dilip.springrest.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.dilip.springrest.entities.Course;
import com.dilip.springrest.services.CourseService;
import com.dilip.springrest.services.CourseServiceImp;

@RestController
public class Mycontroller {
	
	
        @Autowired
	CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		
		return "this is home";
	}
	
	//Get all the courses
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		//Instead of below line , we have used Autowired 
		//CourseService courseService = new CourseServiceImp();
		List<Course> list = courseService.getCourses();
		return list;
	}

	
	//Returns the single Course matching the given CourseId
	
	@GetMapping("/courses/{courseid}")
	public Course getCourse(@PathVariable("courseid") String courseId) {
		
		return courseService.getCourse(Integer.parseInt(courseId));
	}
	
	
	//Add new course
	
	@PostMapping(path="/courses",consumes="application/json",produces="application/json")
	//@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return courseService.addCourse(course);
		
	}
	
	
	//update the details of asked course via id
	@PutMapping(path="/courses/{id}",consumes="application/json",produces="application/json")
	public Course updateCourse(@PathVariable String id,@RequestBody Course course) {
		
		return courseService.updateCourse(Integer.parseInt(id),course);
	}
	
	
	//Delete a course via id
	
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String id) {
		try {
		   courseService.deleteCourse(Integer.parseInt(id));
		   return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
		  return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
