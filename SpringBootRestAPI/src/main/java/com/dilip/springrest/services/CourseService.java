package com.dilip.springrest.services;

import java.util.List;

import com.dilip.springrest.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();

	public Course getCourse(int courseId);

	public Course addCourse(Course course);

	public Course updateCourse(int id,Course course);

	public void deleteCourse(int parseInt);

}
