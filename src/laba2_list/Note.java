package laba2_list;

public class Note {

    private String lastName;
    private String phoneNumber;
    private int yearOfBirth;

    Note(String lastName, String phoneNumber, int yearOfBirth){
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.yearOfBirth = yearOfBirth;
    }

    int getYearOfBirth() {
        return yearOfBirth;
    }

    String getLastName(){
        return this.lastName;
    }

    public String toString(){

        return "Note is: " + lastName + " , phone number: " + phoneNumber + " , year of Birth: " + yearOfBirth;
    }
}
