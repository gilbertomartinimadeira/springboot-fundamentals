package crossmade.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    Iterable<Student> findAllByFirstnameContaining(String studentName);
    // Additional query methods can be defined here if needed

}
