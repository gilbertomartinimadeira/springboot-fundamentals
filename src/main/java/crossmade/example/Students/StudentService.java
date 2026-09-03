package crossmade.example.Students;

import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse createStudent(StudentDto studentDto) {
    
        var student = studentDto.toEntity();
        studentRepository.save(student);
        return StudentResponse.fromEntity(student);
    }

    public StudentResponse getStudentById(Integer studentId) {
        var student = studentRepository.findById(studentId).orElse(null);
        return student != null ? StudentResponse.fromEntity(student) : null;
    }

    public List<StudentResponse> getAllStudents() {
        return studentRepository.findAll().stream().map(StudentResponse::fromEntity).toList()   ;
    }

    public List<StudentResponse> findStudentsByName(String studentName) {
        return studentRepository.findAllByFirstnameContaining(studentName).stream().map(StudentResponse::fromEntity).toList();
    }

}
