package crossmade.example.Students;

public record StudentResponse(String firstname, String lastname, String email) {

    public static StudentResponse fromEntity(Student student) {
        return new StudentResponse(
            student.getFirstname(),
            student.getLastname(),
            student.getEmail()
        );
    }

}
