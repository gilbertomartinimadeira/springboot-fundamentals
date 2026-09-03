package crossmade.example.Students;

import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public StudentResponse Post(@RequestBody() @Valid StudentDto studentDto) {
                
        return studentService.createStudent(studentDto);
    }

    @GetMapping("/students/{studentId}")
    public StudentResponse getStudent(@PathVariable Integer studentId) {
        var studentResponse = studentService.getStudentById(studentId);
        if(studentResponse == null){
            throw new IllegalArgumentException("Student with id " + studentId + " not found");
        }
        return studentResponse;
    }

    @GetMapping("/students")
    public Iterable<StudentResponse> findAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/search/{student-name}")
    public Iterable<StudentResponse> findStudentsByName(@PathVariable("student-name") String studentName){
        return studentService.findStudentsByName(studentName);
    }

    @DeleteMapping("/students/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("id") Integer studentId){
        
        studentService.getStudentById(studentId);
    }
}
