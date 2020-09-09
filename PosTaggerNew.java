package LanguageGeneration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;


import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;


public class PosTaggerNew {
    public String myV;
    public static String writeVari;
    public static String demonvariable;
    public String demovar;

    public PosTaggerNew()
    {

    }
    public PosTaggerNew(String message)
    {
        this.demonvariable=message;
        System.out.println("demon variable is "+demonvariable);
    }




    public String getmyvariable() {

        String myJJ;
        InputStream tokenModelIn = null;
        InputStream posModelIn = null;

 //       System.out.println("getMyMessage is null"+demonvariable);

        try {
            String sentence = demonvariable;
            // tokenize the sentence
            tokenModelIn = new FileInputStream("getInput/en-token.bin");
            TokenizerModel tokenModel = new TokenizerModel(tokenModelIn);
            Tokenizer tokenizer = new TokenizerME(tokenModel);
            //(tokenModel);
            String tokens[] = tokenizer.tokenize(sentence);

            // Parts-Of-Speech Tagging
            // reading parts-of-speech model to a stream
            posModelIn = new FileInputStream("getInput/en-pos-maxent.bin");
            // loading the parts-of-speech model from stream
            POSModel posModel = new POSModel(posModelIn);
            // initializing the parts-of-speech tagger with model
            POSTaggerME posTagger = new POSTaggerME(posModel);
            // Tagger tagging the tokens
            String tags[] = posTagger.tag(tokens);

            for (int i = 0; i < tokens.length; i++) {
                if (tags[i].equalsIgnoreCase("JJ")) {
                    myJJ = tokens[i];
                    writeVari = tokens[i];
                }
                if (tags[i].equalsIgnoreCase("VB")) {
                    myJJ = tokens[i];
                    writeVari = tokens[i];
                }
                if (tags[i].equalsIgnoreCase("VBD")) {
                    myJJ = tokens[i];
                    writeVari = tokens[i];
                }
                if (tags[i].equalsIgnoreCase("VBG")) {
                    myJJ = tokens[i];
                    writeVari = tokens[i];
                }

                if (tags[i].equalsIgnoreCase("VBN")) {
                    myJJ = tokens[i];
                    writeVari = tokens[i];
                }
                if (tags[i].equalsIgnoreCase("VBP")) {
                    myJJ = tokens[i];
                    writeVari = tokens[i];
                }
                if (tags[i].equalsIgnoreCase("VBZ")) {
                    myJJ = tokens[i];
                    writeVari = tokens[i];
                }


            }

        } catch (IOException e) {
            // Model loading failed, handle the error
            e.printStackTrace();
        } finally {
            if (tokenModelIn != null) {
                try {
                    tokenModelIn.close();
                } catch (IOException e) {
                }
            }
            if (posModelIn != null) {
                try {
                    posModelIn.close();
                } catch (IOException e) {
                }
            }
        }
        return writeVari;

    }
}
