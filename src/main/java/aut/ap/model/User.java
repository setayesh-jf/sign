package aut.ap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "singing")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Basic(optional = false)
    private String firstname;

    @Basic(optional = false)
    private String lastname;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Basic(optional = false)
    private String email;

    @Basic(optional = false)
    private String password;


    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public Integer getAge(){
        return age;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setLastname(String lastname){
        this.lastname = lastname;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Weak password");
        }

        this.password = password;
    }

    public User() {
    }
    public User(String firstname, String lastname, Integer age, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "user{" +
                "firstname=" + firstname +
                ", lastname='" + lastname + '\'' +
                ", age=" + age + ", email=" + email + ", password=" + password +
                '}';
    }
}
