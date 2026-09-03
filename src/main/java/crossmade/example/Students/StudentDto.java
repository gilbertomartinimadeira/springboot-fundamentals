package crossmade.example.Students;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(@NotEmpty String firstname, @NotEmpty String lastname, @NotEmpty String email, Integer schoolId) {
    
    public Student toEntity() throws IllegalArgumentException {
        
        return new Student(firstname, lastname, email, schoolId);
    }
} 
