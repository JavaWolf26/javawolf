package web.model;

import javax.validation.constraints.*;

//@Entity
//@Table(name = "users")
public class User {

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //    @Column
    @NotEmpty(message = "FirstName should no be empty")
    @Size(min = 2, max = 30, message = "FirstName should be between 2 and 30 characters")
    @Pattern(regexp = "[A-Z][a-zA-Z\\s\\-]*", message = "FirstName must begin with a capital letter")
    private String firstName;

    //    @Column
    @NotEmpty(message = "LastName should no be empty")
    @Size(min = 2, max = 30, message = "LastName should be between 2 and 15 characters")
    @Pattern(regexp = "[A-Z][a-zA-Z\\s\\-]*", message = "LastName must begin with a capital letter")
    private String lastName;

    //    @Column
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    @NotEmpty(message = "Email should no be empty")
    @Email(message = "Email should be valid")
    private String email;

    public User() {
    }

    public User(int id, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //    @Override
//    public String toString() {
//        return "\nUser {" +
//                "id = " + id +
//                ", firstName = '" + firstName + '\'' +
//                ", lastName = '" + lastName + '\'' +
//                ", age = '" + age + '\'' +
//                '}';
//    }
}
