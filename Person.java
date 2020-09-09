package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    private int inten;
    private String firstName;
    private  String intent;
    private String message;
//    private String lastName;
  //  private String email;

    public Person() {
        // Needed by Jackson deserialization
    }

    public Person(int inten, String firstName, String lastName, String email)
    {
        this.inten = inten;
        this.firstName = firstName;
    }

    public Person(String intent,String message)
    {
        this.intent=intent;
        this.message=message;
    }


    @JsonProperty
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty
    public String getMyFirstName() {
        return firstName;
    }

    @JsonProperty
    public String getSentiments()   {return intent;}

    @JsonProperty
    public String getMessage() {return  message;}


}