package LanguageGeneration;

import javafx.geometry.Pos;
import simplenlg.features.Feature;
import simplenlg.features.InterrogativeType;
import simplenlg.framework.LexicalCategory;
import simplenlg.framework.NLGElement;
import simplenlg.framework.NLGFactory;
import simplenlg.framework.WordElement;
import simplenlg.lexicon.Lexicon;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.realiser.english.Realiser;

import java.util.ArrayList;
import java.util.List;

public class PositiveChatGeneration extends PosTaggerNew {
//    Paragraph p = new Paragraph();
    static SPhraseSpec p1;
    static SPhraseSpec p2;
    static SPhraseSpec p3;

    Realiser r1;
    String output1;
    String output2;

    PosTaggerNew ps = new PosTaggerNew();

    public List<String> getData() {
        String[] array = new String[5];

        String demovar = ps.getmyvariable();
        System.out.println("Got verb==" + demovar);


        Lexicon lexicon = Lexicon.getDefaultLexicon();
        NLGFactory nlgFactory = new NLGFactory(lexicon);
        Realiser realiser = new Realiser(lexicon);


        p1 = nlgFactory.createClause();
        p3 = nlgFactory.createClause();

        p1.setSubject("you");
        p1.setVerb("are");
        p1.addModifier(demovar);
        p1.setFeature(Feature.INTERROGATIVE_TYPE, InterrogativeType.WHY);

        Realiser r1 = new Realiser();
        String output2 = r1.realiseSentence(p1);


        p3.setSubject("I");
        p3.setVerb("am");
        p3.setObject("happy for you");

        Realiser r2 = new Realiser();
        String output3 = r1.realiseSentence(p3);


        System.out.println(output3);


        WordElement word = new WordElement(demovar, LexicalCategory.ADJECTIVE);


        SPhraseSpec p1 = nlgFactory.createClause();

        NLGElement s2 = nlgFactory.createSentence("That's great");
        p1.addComplement("keep it up!!!!!!!!");
        p1.addComplement("Just stay positive:)   ");

        String ops = realiser.realiseSentence(s2);
        String myget = realiser.realiseSentence(p1);


        String oops = ops + myget;
  //      String message = p.getParagraph();

        SPhraseSpec p11 = nlgFactory.createClause();
        p11.setSubject("I");
        p11.setVerb("am");
        p11.setObject("wishing you great days ahead");


        List<String> list = new ArrayList<String>();

        Realiser r = new Realiser();


        array[0] = output2;
        array[1] = output3;
        array[2] = oops;
       array[3] = r.realiseSentence(p11);

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null)
                list.add(array[i]);
        }

        return list;

    }
}