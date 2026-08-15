package crossmade.example;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }    

    @PostMapping("/students")
    public String Post(@RequestBody() Student student) {
        studentRepository.save(student);
        return "received: " + student.getFirstname() + " " + student.getLastname();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @GetMapping("/students")
    public Iterable<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/students/search/{student-name}")
    public Iterable<Student> findStudentsByName(@PathVariable("student-name") String studentName){
        return studentRepository.findAllByFirstnameContaining(studentName);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("id") Integer studentId){
        
        studentRepository.deleteById(studentId);
        return;
    }
}
