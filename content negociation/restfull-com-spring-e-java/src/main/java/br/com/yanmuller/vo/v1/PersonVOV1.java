package br.com.yanmuller.vo.v1;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;


public class PersonVOV1 implements Serializable {
 private static final long serialVersionUID = 1L;

 private Long id;
 private String firstName;
 private String lastName;
 private String address;
 private String gender;

 public PersonVOV1() {}
 public PersonVOV1(Long id, String firstName, String lastName, String address, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof PersonVOV1 that)) return false;

        return getId().equals(that.getId()) && getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getAddress().equals(that.getAddress()) && getGender().equals(that.getGender());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getGender().hashCode();
        return result;
    }
}
