package com.mrc.dogspring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationForm {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @Pattern(regexp = "[A-z]{3,15}")
    private String name;
    @Pattern(regexp = "[A-z]{3,20}")
    private String lastname;
    private String animalName;
    @Pattern(regexp = "[0-9]{9}")
    private String phoneNumber;
    private String decision;
}
