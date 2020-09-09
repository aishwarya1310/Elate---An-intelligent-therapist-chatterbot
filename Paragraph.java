package LanguageGeneration;

import java.util.Arrays;


import simplenlg.features.Feature;
import simplenlg.features.Tense;
import simplenlg.framework.DocumentElement;
import simplenlg.framework.InflectedWordElement;
import simplenlg.framework.LexicalCategory;
import simplenlg.framework.NLGFactory;
import simplenlg.framework.WordElement;
import simplenlg.lexicon.Lexicon;
import simplenlg.lexicon.XMLLexicon;
import simplenlg.phrasespec.SPhraseSpec;
import simplenlg.realiser.english.Realiser;
import simplenlg.xmlrealiser.XMLRealiser;



public class Paragraph
{
    public String getParagraph()
    {
        Lexicon lexicon = Lexicon.getDefaultLexicon();
        NLGFactory nlgFactory = new NLGFactory(lexicon);
        Realiser realiser = new Realiser(lexicon);

        //SPhraseSpec p1 = NLGFactory.createClause("Mary", "chase", "the monkey");
        SPhraseSpec p2 = nlgFactory.createClause("I","can", "help you.");
        p2.addComplement(" You can tell me more about your feelings");

        //SPhraseSpec p1=nlgFactory.createClause("You can"," tell me more about your feelings");
        //p1.setFeature(Feature.TENSE, Tense.PAST);

        SPhraseSpec p3 = nlgFactory.createClause("I", "will", "try my best for you");

        // DocumentElement s1 = nlgFactory.createSentence(p1);
        DocumentElement s2 = nlgFactory.createSentence(p2);
        DocumentElement s3 = nlgFactory.createSentence(p3);

        DocumentElement par1 = nlgFactory.createParagraph(Arrays.asList(s2, s3));

        String output = realiser.realise(par1).getRealisation();
//	    System.out.println(output);

        return output;

    }


}
