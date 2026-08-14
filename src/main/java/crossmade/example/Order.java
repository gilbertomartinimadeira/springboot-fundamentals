package crossmade.example;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Order(Long id, @JsonProperty("date") LocalDate createdAt) {
    @Override
    public final String toString() {
        
        return "# "+ id + ", created At: " + createdAt.toString();
    }
}
