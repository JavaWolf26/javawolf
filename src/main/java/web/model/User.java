package web.model;

//@Entity
//@Table(name = "users")
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column
    private String firstName;

//    @Column
    private String lastName;

//    @Column
    private String age;

    public User() {
    }

    public User(int id, String firstName/*, String lastName, String age*/) {
        this.id = id;
        this.firstName = firstName;
//        this.lastName = lastName;
//        this.age = age;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
