package com.example.zadanie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Meno je povinné")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Priezvisko je povinné")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Dátum narodenia je povinný")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @NotBlank(message = "Email je povinný")
    @Email(message = "Neplatný email")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Email musí mať správny formát (napr. meno@domena.sk)")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Telefón je povinný")
    @Size(max = 15, message = "Telefón môže mať najviac 15 znakov")
    @Column(name = "phone", length = 15)
    private String phone;

    @NotBlank(message = "Pracovná pozícia je povinná")
    @Column(name = "job_title")
    private String jobTitle;

    @NotNull(message = "Plat je povinný")
    @Positive(message = "Plat musí byť kladný")
    @Column(name = "salary")
    private BigDecimal salary;

    @NotNull(message = "Úväzok je povinný")
    @Column(name = "full_time")
    private Boolean fullTime;

    public Employee() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    public Boolean getFullTime() { return fullTime; }
    public void setFullTime(Boolean fullTime) { this.fullTime = fullTime; }
}