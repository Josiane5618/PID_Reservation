package be.iccbxl.pid.reservationsspringboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="artists")
public class Artist {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The firstname must not be empty.")
    @Size(min=2, max=60, message = "The firstname must be between 2 and 60 characters long.")
    private String firstname;

    @NotEmpty(message = "The lastname must not be empty.")
    @Size(min=2, max=60, message = "The firstname must be between 2 and 60 characters long.")
    private String lastname;

    protected Artist() {}

    public Artist(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    //…

    public @NotEmpty(message = "The firstname must not be empty.") @Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.") String getFirstname() {
        return firstname;
    }

    public void setFirstname(@NotEmpty(message = "The firstname must not be empty.") @Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.") String firstname) {
        this.firstname = firstname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "The lastname must not be empty.") @Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.") String getLastname() {
        return lastname;
    }

    public void setLastname(@NotEmpty(message = "The lastname must not be empty.") @Size(min = 2, max = 60, message = "The firstname must be between 2 and 60 characters long.") String lastname) {
        this.lastname = lastname;
    }
}

