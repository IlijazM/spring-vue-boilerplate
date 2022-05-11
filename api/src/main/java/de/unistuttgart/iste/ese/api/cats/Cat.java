package de.unistuttgart.iste.ese.api.cats;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cats")
@Data
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @Size(min = 1, max = 40)
    private String name;
    @Min(0)
    @Max(42)
    private int ageInYears;
    private String picUrl;

    // empty default constructor is necessary for JPA
    public Cat() {}

    public Cat(String name, int ageInYears, String picUrl) {
        this.name = name;
        this.ageInYears = ageInYears;
        this.picUrl = picUrl;
    }

}
