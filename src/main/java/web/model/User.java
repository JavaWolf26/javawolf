package web.model;

//@Entity
//@Table(name = "users")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column
    private String firstName;

//    @Column
    private String lastName;

//    @Column
    private Byte age;

//    public User() {
//    }

    public User(Long id, String firstName, String lastName, Byte age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getFirstName() {
        return firstName;
    }

//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }

    public String getLastName() {
        return lastName;
    }

//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    public Byte getAge() {
        return age;
    }

//    public void setAge(Byte age) {
//        this.age = age;
//    }

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
