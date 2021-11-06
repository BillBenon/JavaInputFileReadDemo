package inputReadFile;

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    public EGender gender;
    public Person () {

    }
    public Person(String fName, String lName, Integer ages, EGender genders) {
        this.firstName = fName;
        this.lastName = lName;
        this.age = ages;
        this.gender = genders;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }
}
