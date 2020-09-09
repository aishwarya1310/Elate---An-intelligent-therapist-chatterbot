package com.example.hp.elate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question_act extends AppCompatActivity {

    private RadioButton radbutton;
    private RadioButton radbutton2;

        public Button gobutton;
        public Button nextButton;

   public String mystring,olp;
    public int quest1ans,quest2ans,quest3ans,quest4ans,secAres,secBres;


    public void init()
    {
        nextButton=(Button)findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent questionact=new Intent(Question_act.this,Question_secBAck.class);

                Bundle bundle=new Bundle();

                bundle.putString("secavalue",olp);

                questionact.putExtras(bundle);

                startActivity(questionact);
            }
        });
    }

    public void getValues()
    {
        final RadioGroup quest1=(RadioGroup)findViewById(R.id.question1);
        final      RadioGroup quest2=(RadioGroup)findViewById(R.id.question2);

        quest1.clearCheck();
        quest2.clearCheck();

        Button questsub=(Button)findViewById(R.id.getButton);

        questsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int selectedID = quest1.getCheckedRadioButtonId();

                radbutton = (RadioButton) findViewById(selectedID);

                mystring = (String) radbutton.getText();

                if (mystring.equals("+ve")) {
                    quest1ans = 2;
                } else if (mystring.equals("-ve")) {
                    quest1ans = 6;
                } else {
                    quest1ans = 4;
                }

//                    quest1ans=sumup(mystring);

                int selectedID2 = quest2.getCheckedRadioButtonId();

                radbutton2 = (RadioButton) findViewById(selectedID2);

                mystring = (String) radbutton2.getText();

                if (mystring.equals("+ve"))
                {
                    quest2ans = 2;
                }
                else if (mystring.equals("-ve"))
                {
                    quest2ans = 6;
                }
                else
                {
                    quest2ans = 4;
                }

                secAres=quest2ans+quest1ans;

                olp=String.valueOf(secAres);

                Toast.makeText(Question_act.this,""+olp,Toast.LENGTH_SHORT).show();

            }
        });



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_act);

        getValues();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.elate);

        init();
    }
}
