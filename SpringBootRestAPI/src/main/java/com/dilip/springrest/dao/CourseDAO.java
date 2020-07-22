package com.dilip.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dilip.springrest.entities.Course;

public interface CourseDAO extends JpaRepository<Course, Integer> {

}
