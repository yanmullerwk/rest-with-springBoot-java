package br.com.yanmuller.estudospringbootcomjavaaula3.data.vo.v1;


import java.io.Serializable;
import java.util.Objects;


public class PersonVO implements Serializable {
    private static final long serialVersionUID = 1L;


    private Long id;

    private String firstName;

    private String surname;

    private String address;

    private String gender;

    // Construtor padrão
    public PersonVO() {
    }

    // Construtor com argumentos
    public PersonVO(Long id, String firstName, String surname, String address, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.gender = gender;
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Métodos equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PersonVO person)) return false;
        return getId() == person.getId() &&
                Objects.equals(getFirstName(), person.getFirstName()) &&
                Objects.equals(getSurname(), person.getSurname()) &&
                Objects.equals(getAddress(), person.getAddress()) &&
                Objects.equals(getGender(), person.getGender());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getSurname(), getAddress(), getGender());
    }
}
