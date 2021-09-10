package com.phoenixnap.bmc.pojos;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class CustomerEntity {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private Long createdTimestamp;

    public CustomerEntity() {
    }

    public CustomerEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdTimestamp = new Date().getTime();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity customerEntity = (CustomerEntity) o;

        if (id != null ? !id.equals(customerEntity.id) : customerEntity.id != null) return false;
        if (firstName != null ? !firstName.equals(customerEntity.firstName) : customerEntity.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customerEntity.lastName) : customerEntity.lastName != null) return false;
        return createdTimestamp != null ? createdTimestamp.equals(customerEntity.createdTimestamp) : customerEntity.createdTimestamp == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (createdTimestamp != null ? createdTimestamp.hashCode() : 0);
        return result;
    }
}
