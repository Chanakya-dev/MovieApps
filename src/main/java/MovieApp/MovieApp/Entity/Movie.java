package MovieApp.MovieApp.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
    @NotNull(message = "Title is mandatory")
    private String title;

    @NotNull(message = "Genre is mandatory")
    @Pattern(regexp = "[A-Za-z]+", message = "Genre must contain only letters")
    private String genre;

    @JsonProperty("isPopular")
    @Column(name = "is_popular")
    private boolean isPopular;

    private String poster;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @NotNull(message = "Language is mandatory")
    private String language;  
}
