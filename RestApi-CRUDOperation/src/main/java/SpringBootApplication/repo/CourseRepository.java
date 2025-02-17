package SpringBootApplication.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBootApplication.binding.Course;

public interface CourseRepository extends JpaRepository<Course, Serializable>{

}
