package db;

import SentimentAnalyzer.OpenNLPCategorizer;
import models.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonDB
{
    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    String reply;
    int intent;
    Person person;
    int getValue;
    String showingValue;
    int showingvalue;


    OpenNLPCategorizer sentimentanalyzer=new OpenNLPCategorizer();

       //  String myval=getIntent();

    static {
        persons.put(1, new Person(1, "FN1", "LN1", "email1@email.com"));
        persons.put(3, new Person(3, "FN3", "LN3", "email3@email.com"));
        persons.put(4, new Person(4, "FN4", "LN4", "email4@email.com"));
    }






    public static Person getByIntent(int intent) {
        return persons.get(intent);
    }

    public  static  Person getByFirstName(String firstName)
    {
        return persons.get(firstName);
    }

    public void getSentiments()
    {
        sentimentanalyzer.callfunction();
    //   getValue=sentimentanalyzer.classifyNewTweet("I am feeling overwhelmed");

      // return getValue;

    }
/*    public String getIntent()
    {
        showingvalue=getSentiments();
        String showValue=Integer.toString(showingvalue);
        if(showValue.equalsIgnoreCase("1"))
            return "Tweet is positive"+showValue;
        else
            return "Tweet is negative"+showValue;
    }*/


    public static List<Person> getAll() {
        List<Person> result = new ArrayList<Person>();
        for (Integer key : persons.keySet()) {
            result.add(persons.get(key));
        }
        return result;
    }

    public static int getCount() {
        return persons.size();
    }

    public static void remove()
    {
        if (!persons.keySet().isEmpty()) {
            persons.remove(persons.keySet().toArray()[0]);
        }
    }

/*public static String giveFirstName()
{
    return  giveFirstName();
}*/




}
