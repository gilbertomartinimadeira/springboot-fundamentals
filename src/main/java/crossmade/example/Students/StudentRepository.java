package crossmade.example.Students;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByFirstnameContaining(String studentName);
    // Additional query methods can be defined here if needed

}
