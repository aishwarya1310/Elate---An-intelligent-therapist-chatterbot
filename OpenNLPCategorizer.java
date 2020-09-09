package SentimentAnalyzer;

import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSampleStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OpenNLPCategorizer {
   static DoccatModel model;
    int sentimentreturnvalue;




    public static void callfunction()
    {
        trainModel();

    }

    public static void trainModel() {
        InputStream dataIn = null;
        try {
            dataIn = new FileInputStream("input/amazon_cells_labelled.txt");
            ObjectStream lineStream = new PlainTextByLineStream(dataIn, "UTF-8");
            ObjectStream sampleStream = new DocumentSampleStream(lineStream);
            // Specifies the minimum number of times a feature must be seen
            int cutoff = 2;
            int trainingIterations = 30;
            model = DocumentCategorizerME.train("en", sampleStream, cutoff,
                    trainingIterations);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataIn != null) {
                try {
                    dataIn.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int classifyNewTweet(String tweet) {

            DocumentCategorizerME myCategorizer = new DocumentCategorizerME(model);
            double[] outcomes = myCategorizer.categorize(tweet);
            String category = myCategorizer.getBestCategory(outcomes);

            if (category.equalsIgnoreCase("1")) {
                System.out.println("The tweet is positive :) ");
                sentimentreturnvalue = 1;
            } else {
                System.out.println("The tweet is negative :( ");
                sentimentreturnvalue = 0;
            }
            return sentimentreturnvalue;
        }

}
