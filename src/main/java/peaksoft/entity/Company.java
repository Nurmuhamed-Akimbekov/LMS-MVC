package peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Entity
@Table(name = "companies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ok_gen")
    @SequenceGenerator(name ="ok_gen",sequenceName = "ok_seq",allocationSize = 1,initialValue = 5)
    private Long id;
    @NotNull
    private String name;
    @Column(length = 20000)
    private String imageLink;
    @NotNull
    private String description;

    public Company(String name, String imageLink, String description) {
        this.name = name;
        this.imageLink = imageLink;
        this.description = description;
    }
}
