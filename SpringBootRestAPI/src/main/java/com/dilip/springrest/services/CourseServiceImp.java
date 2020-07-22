package com.dilip.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dilip.springrest.dao.CourseDAO;
import com.dilip.springrest.entities.Course;

@Service
public class CourseServiceImp implements CourseService {

	@Autowired
	private CourseDAO courseDAO;
	
	public  CourseServiceImp() {
		
	}
	
	@Override
	public List<Course> getCourses() {
		
		return courseDAO.findAll();
	}

	@Override
	public Course getCourse(int courseId) {
	
		
		return courseDAO.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		
		courseDAO.save(course);
		return course;
	}

	@Override
	public Course updateCourse(int id,Course course) {
       
		courseDAO.save(course);
	    return course;
	}

	@Override
	public void deleteCourse(int id) {
		Course entity=courseDAO.getOne(id);
		courseDAO.delete(entity);
	}
	
	
	
	
	/*
	List <Course> list;
	 
	public  CourseServiceImp() {
		list = new ArrayList<>();
		list.add(new Course(1,"C++","Object Oriented"));
		list.add(new Course(2,"Python","Scripting language"));
		list.add(new Course(3,"Spring Boot","A java Framework"));
	}
	
	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCourse(int courseId) {
	
		for (Course courseInfo : list) {
			
			if(courseId == courseInfo.getId()) {
				return courseInfo;
			}
		}
		return null;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(int id,Course course) {
       
		
		for (int i = 0; i < list.size(); i++) {
			Course c = list.get(i);
			if(c.getId() == id) {
				list.set(i,course);
				return course;
			}	
		} 
			
			
		
		return null;
	}

	@Override
	public void deleteCourse(int id) {
		for (int i = 0; i < list.size(); i++) {
			Course c = list.get(i);
			if(c.getId() == id) {
				list.remove(i);
				
			}	
		} 
		
	}
	
	
	*/
	
	

}
