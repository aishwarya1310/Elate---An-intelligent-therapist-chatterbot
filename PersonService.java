package service;

import ApplicationTestData.API;
import ApplicationTestData.GetMessages;
import ApplicationTestData.TrainingModel;
import LanguageGeneration.*;
import SentimentAnalyzer.OpenNLPCategorizer;
import ServerConfig.ConfigurationClass;
import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import db.PersonDB;
import jdk.nashorn.internal.parser.JSONParser;
import models.Message;
import models.Person;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import javax.annotation.Generated;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.stream.Location;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Path("/person")
public class PersonService {

    PersonDB person=new PersonDB();
    int showingValue;
    String mymessage,MymessageObject;
OpenNLPCategorizer sentimentanalyzer=new OpenNLPCategorizer();
boolean sentiments=true;
int oneval,myval;
Message message,msg1;
int pos=0;
    GetMessages initialization=new GetMessages();
    GetMessages getMessages=new GetMessages();
   PosTaggerNew posTaggerNew;//=new PosTaggerNew();
    int i=0,f=1;
    int m,g,val,randnum;
    String initialmessage,listmessage,showSentimentVal;

        FetchingVaues fetchingVaues=new FetchingVaues();
    List<String> list=new ArrayList<String>();
    List<String> poslist=new ArrayList<String>();
    PositiveChatGeneration positiveChatGeneration=new PositiveChatGeneration();


    public int getListSize()
    {
        list=fetchingVaues.getData();
        return list.size();
    }

    public int getPoslistSize()
    {
        poslist=positiveChatGeneration.getData();
        return poslist.size();
    }

    public int generateRandomNumber()
    {
        Random rand=new Random();

        int x=rand.nextInt(7);

        return x;
    }

    String ServerMessages;
    String showValue;

    public PersonService() {

    }




    @POST
    @Timed
    @Path("/posts")
     @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMyMessage(Message messageObj)
    {
        String oneString;
        System.out.println(messageObj.getMessage());
        String intentmessage=messageObj.getMessage();
            TrainingModel trainingModel;
            //poslist=getPoslist();


            if(f==1)
            {
                OpenNLPCategorizer.callfunction();
                System.out.println("Call function");
                f++;
            }
            if(!intentmessage.equalsIgnoreCase("bye"))
            {
                if (sentiments == true) {
                    showingValue = sentimentanalyzer.classifyNewTweet(intentmessage);
                    showValue = Integer.toString(showingValue);
                    System.out.println("I am in showvalue"+showValue);
                    sentiments = false;
                }
                if (showValue.equalsIgnoreCase("1"))
                {
                    posTaggerNew=new PosTaggerNew(intentmessage);
                     m=getPoslistSize();
                     if(i==0) {
                         System.out.println("" + intentmessage);
                       //  initialmessage = initialization.getInitializationMessages();
                         mymessage = poslist.get(i);
                         ServerMessages = mymessage;
                         message = new Message(ServerMessages);
                         System.out.println("i ka value"+i);
                         System.out.println(poslist.get(i));
                     }
                    if(i<m)
                    {
                        System.out.println("i ka value "+i);
                        System.out.println("m ka value "+m);
                        ServerMessages = poslist.get(i);
                        System.out.println(ServerMessages);
                        message = new Message(ServerMessages);
                    }
                    if(i==m)
                    {
                        message=new Message("i think i should go now!!!!Bye.See you soon :) ");
                    }
                    if(i>=m)
                    {
                        showingValue = sentimentanalyzer.classifyNewTweet(intentmessage);
                        showValue = Integer.toString(showingValue);

                    }
                    i++;
                    return message;
                }
                else
                    {
                    oneString = "negative" + showValue;
    negChat:        posTaggerNew=new PosTaggerNew(intentmessage);
                    m=getListSize();
                    if (i == 0) {
                        System.out.println("Print intent Message "+intentmessage);
                        initialmessage = initialization.getInitializationMessages();
                        mymessage=list.get(i);
                        ServerMessages=initialmessage+"\n"+mymessage;
                        message = new Message(ServerMessages);
                        System.out.println(list.get(i));
                    }
                    else if(i<m)
                        {
//                            val=i-1;
//                        System.out.println("m ka value "+m);
                        ServerMessages = list.get(i);
                        System.out.println(ServerMessages);
                        message = new Message(ServerMessages);
                        System.out.println("I ka value "+i);
                    }
                    else
                    {
                        System.out.println("i ka value "+i);
                        if (i % 6 == 0) {
                           showingValue = sentimentanalyzer.classifyNewTweet(intentmessage);
                            showSentimentVal = Integer.toString(showingValue);
                            System.out.println("Value is"+showingValue);

                                       }
                            if(i%2!=0)
                            {
                                if(!intentmessage.equalsIgnoreCase("no"))
                                {
                                    randnum=generateRandomNumber();

                                    switch (randnum)
                                    {
                                        case 0:
                                            MymessageObject="Let me tell you one motivational story "+"\n";
                                            ServerMessages=MymessageObject+"\n"+getMessages.getstoryMessages()+"\n are you satisfied with this tell me yes or no\n";
                                            message=new Message(ServerMessages);
                                            break;
                                        case 1:
                                            MymessageObject="Let me give you one motivational video links "+"\n";
                                            ServerMessages=MymessageObject+"\n"+getMessages.getmovieMessages()+"\nare you satisfied with this tell me yes or no\n";
                                            message=new Message(ServerMessages);

                                            break;
                                        case 2:
                                            MymessageObject="Let me tell you some motivational quotes "+"\n";
                                            ServerMessages=MymessageObject+"\n"+getMessages.getquotesMessages()+"\nare you satisfied with this tell me yes or no\n";
                                            message=new Message(ServerMessages);

                                            break;
                                        case 3:
                                            MymessageObject="Let me tell you some jokes "+"\n";
                                            ServerMessages=MymessageObject+"\n"+getMessages.getJokesMessages()+"\nare you satisfied with this tell me yes or no\n";
                                            message=new Message(ServerMessages);
                                            break;
                                        case 4:
                                            MymessageObject="Let me tell you some interesting movies "+"\n";
                                            ServerMessages=MymessageObject+"\n"+getMessages.getmovieMessages()+"\n are you satisfied with this tell me yes or no\n";
                                            message=new Message(ServerMessages);
                                            break;
                                        case 5:
                                            MymessageObject="Let me tell you about some interesting books "+"\n";
                                            ServerMessages=MymessageObject+"\n"+getMessages.getBookMessages()+"\nare you satisfied with this tell me yes or no\n";
                                            message=new Message(ServerMessages);
                                            break;
                                        case 6:
                                            MymessageObject="Let me tell you some places to travel"+"\n";
                                            ServerMessages=MymessageObject+"\n"+getMessages.gettravellingMessages()+"\nare you satisfied with this tell me...yes or no\n";
                                            message=new Message(ServerMessages);
                                            break;
                                    }

                                }
                                else if(intentmessage.equalsIgnoreCase("no"))
                                {
                                                ServerMessages="i think i should leave now";
                                                message=new Message(ServerMessages);
                                }

                            }
                            else
                            {
                                randnum=generateRandomNumber();
                                if(!intentmessage.equalsIgnoreCase("no")) {
                                    switch (randnum) {
                                        case 0:
                                            MymessageObject = "Let me tell you one motivational story "+"\n";
                                            ServerMessages = MymessageObject+"\n"+ getMessages.getstoryMessages();
                                            message = new Message(ServerMessages);
                                            break;
                                        case 1:
                                            MymessageObject = "Let me give you one motivational video links "+"\n";
                                            ServerMessages = MymessageObject+"\n"+ getMessages.getvideoMessages();
                                            message = new Message(ServerMessages);

                                            break;
                                        case 2:
                                            MymessageObject = "Let me tell you some motivational quotes "+"\n";
                                            ServerMessages = MymessageObject+"\n"+ getMessages.getquotesMessages();
                                            message = new Message(ServerMessages);

                                            break;
                                        case 3:
                                            MymessageObject = "Let me tell you some jokes "+"\n";
                                            ServerMessages = MymessageObject +"\n"+ getMessages.getJokesMessages();
                                            message = new Message(ServerMessages);
                                            break;
                                        case 4:
                                            MymessageObject = "Let me tell you some interesting movies "+"\n";
                                            ServerMessages = MymessageObject +"\n"+ getMessages.getmovieMessages();
                                            message = new Message(ServerMessages);
                                            break;
                                        case 5:
                                            MymessageObject = "Let me tell you about some interesting books "+"\n";
                                            ServerMessages = MymessageObject +"\n"+ getMessages.getBookMessages();
                                            message = new Message(ServerMessages);
                                            break;
                                        case 6:
                                            MymessageObject = "Let me tell you some places to travel"+"\n";
                                            ServerMessages = MymessageObject +"\n"+getMessages.gettravellingMessages();
                                            message = new Message(ServerMessages);
                                            break;


                                    }
                                }
                                else if(intentmessage.equalsIgnoreCase("no"))
                                {
                                    ServerMessages="oops i am sorry,i think i have only these many options if you still want to know more options you can type yes else say bye";
                                    message=new Message(ServerMessages);
                                }

                            }

                    }
                    i++;
                    return message;
                }
            }
            else
            {
                message=new Message("Okez.Take care.Good bye.See you soon");
                return message;
            }

    }


/*    @POST
    @Timed
    @Path("/save")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String addPerson(Person person) {
        return PersonDB.save(person);
    }*/
}