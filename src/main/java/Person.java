public class Person implements Comparable{
    private String firstName;
    private String lastName;

    public Person(String fName, String lName) {
        this.lastName = lName;
        this.firstName = fName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }


    @Override
    public String toString() {
        return "firstName: " + this.firstName + " | lastName: " + this.lastName;
    }

    @Override
    public int compareTo(Object o) {
        Person p2 = (Person)o;
        if(firstName!=p2.firstName){
            return firstName.compareTo(p2.firstName);
        }
        else return lastName.compareTo(p2.lastName);
    }

}
