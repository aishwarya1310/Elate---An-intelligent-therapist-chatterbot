package com.example.hp.elate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question_secBAck extends AppCompatActivity {

    Button submitbutton;
    private RadioButton radbutton3;
    private RadioButton radbutton4;
    Button nextButton;


    String mystring,olp;
    int quest3ans,quest4ans,secAres,secBres;

    int answer,secBresget,casevalue;



    public void init()
    {
        nextButton=(Button)findViewById(R.id.nextbutton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(casevalue==10 || casevalue==20){
                    Intent questionact=new Intent(Question_secBAck.this,ChatActivity.class);

//                Bundle bundle=new Bundle();
//
                    //              bundle.putString("secavalue",olp);
//
//                questionact.putExtras(bundle);

                    startActivity(questionact);}
                else if (casevalue==30 || casevalue==40){

                    Intent questionact=new Intent(Question_secBAck.this,negative_chat.class);

//                Bundle bundle=new Bundle();
//
                    //              bundle.putString("secavalue",olp);
//
//                questionact.putExtras(bundle);

                    startActivity(questionact);
                }else {

                    Intent questionact=new Intent(Question_secBAck.this,neutral_chat.class);

//                Bundle bundle=new Bundle();
//
                    //              bundle.putString("secavalue",olp);
//
//                questionact.putExtras(bundle);

                    startActivity(questionact);

                }
            }
        });
    }


    public int getValues()
    {
        final RadioGroup quest3=(RadioGroup)findViewById(R.id.question3);
        final   RadioGroup quest4=(RadioGroup)findViewById(R.id.question4);


        Button submitbutton=(Button)findViewById(R.id.nextsubmit);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedID3 = quest3.getCheckedRadioButtonId();

                radbutton3 = (RadioButton) findViewById(selectedID3);

                mystring = (String) radbutton3.getText();

                if (mystring.equals("+ve")) {
                    quest3ans = 2;
                } else if (mystring.equals("-ve")) {
                    quest3ans = 6;
                } else {
                    quest3ans = 4;
                }

                int selectedID4 = quest4.getCheckedRadioButtonId();

                radbutton4 = (RadioButton) findViewById(selectedID4);

                mystring = (String) radbutton4.getText();

                if (mystring.equals("+ve")) {
                    quest4ans = 2;
                } else if (mystring.equals("-ve")) {
                    quest4ans = 6;
                } else {
                    quest4ans = 4;
                }


                secBres = quest3ans + quest4ans;
                olp = String.valueOf(secBres);

                Toast.makeText(Question_secBAck.this, "SecBresult" + secBres, Toast.LENGTH_SHORT).show();

                getResults(secAres, secBres);



            }

        });

        return secBres;
    }

    public void getResults(final int secAres,int secBres) {

        final int myres = secBres;


        Button resultbutton = (Button) findViewById(R.id.results);

        resultbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Question_secBAck.this, "My result" + myres, Toast.LENGTH_SHORT).show();

                getMycase(secAres, myres);


            }
        });
    }

            public void getMycase(int secAres,int myres)
    {

 //           Toast.makeText(Question_secBAck.this,""+myres,Toast.LENGTH_SHORT).show();
        if(secAres<8 &&myres<8 )
        {
                    Toast.makeText(Question_secBAck.this,"Hello Section A result"+secAres,Toast.LENGTH_SHORT).show();

                    Toast.makeText(Question_secBAck.this,"Hello Section B result"+myres,Toast.LENGTH_SHORT).show();
                    casevalue = 10;
        }
        if(secAres<8 && myres>8)
        {
            casevalue=20;
        }
        if (secAres>8 && myres<8)
        {
            casevalue=30;
        }
        if(secAres>8 && myres>8)
        {
            casevalue=40;
        }


        switch (casevalue)
        {
            case 10:
                Toast.makeText(Question_secBAck.this, "I am in PP case", Toast.LENGTH_SHORT).show();
                break;
            case 20:
                Toast.makeText(Question_secBAck.this, "I am in PN case", Toast.LENGTH_SHORT).show();
                break;
            case 30:
                Toast.makeText(Question_secBAck.this, "I am in NP case", Toast.LENGTH_SHORT).show();
                break;
            case 40:
                Toast.makeText(Question_secBAck.this, "I am in NN case", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(Question_secBAck.this, "I am in Nuetral case", Toast.LENGTH_SHORT).show();
                break;
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_sec_back);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.elate);

        Bundle bundle=getIntent().getExtras();

        String mysecARes=bundle.getString("secavalue");

        try
        {
            secAres=Integer.parseInt(mysecARes);

        }
        catch(NumberFormatException ex)
        {
            Toast.makeText(Question_secBAck.this,""+ex,Toast.LENGTH_SHORT).show();
        }

       secBresget=getValues();


  //      Toast.makeText(Question_secBAck.this,"Section B result "+secBres,Toast.LENGTH_LONG).show();

//        getResults(secAres,secBresget);






//        Toast.makeText(Question_secBAck.this,"My Section result: "+mysecARes,Toast.LENGTH_SHORT).show();


        init();

    }
}
