package ApplicationTestData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.FileHandler;

public class GetMessages
{
    String randomLine;
    int getRandnum;

    public String getBookMessages()
    {

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Dataset/books.txt"));
            String line = reader.readLine();
            List<String> lines = new ArrayList<String>();
             while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }
            Random r = new Random();
             randomLine = lines.get(r.nextInt(lines.size()));
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
     //   randomLine="hell";
        return randomLine;
}
    public String getJokesMessages()
    {

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Dataset/jokes.txt"));
            String line = reader.readLine();
            List<String> lines = new ArrayList<String>();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            Random r = new Random();
            randomLine = lines.get(r.nextInt(lines.size()));
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        //   randomLine="hell";
        return randomLine;
    }
    public String getmovieMessages()
    {

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Dataset/movies_suggestion.txt"));
            String line = reader.readLine();
            List<String> lines = new ArrayList<String>();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            Random r = new Random();
            randomLine = lines.get(r.nextInt(lines.size()));
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        //   randomLine="hell";
        return randomLine;
    }
    public String getquotesMessages()
    {

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Dataset/quotes.txt"));
            String line = reader.readLine();
            List<String> lines = new ArrayList<String>();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            Random r = new Random();
            randomLine = lines.get(r.nextInt(lines.size()));
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        //   randomLine="hell";
        return randomLine;
    }
    public String getsongsMessages()
    {

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Dataset/songs.txt"));
            String line = reader.readLine();
            List<String> lines = new ArrayList<String>();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            Random r = new Random();
            randomLine = lines.get(r.nextInt(lines.size()));
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        //   randomLine="hell";
        return randomLine;
    }
    public String getstoryMessages()
    {

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Dataset/story.txt"));
            String line = reader.readLine();
            List<String> lines = new ArrayList<String>();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            Random r = new Random();
            randomLine = lines.get(r.nextInt(lines.size()));
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        //   randomLine="hell";
        return randomLine;
    }
    public String gettravellingMessages()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Dataset/travelling.txt"));
            String line = reader.readLine();
            List<String> lines = new ArrayList<String>();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            Random r = new Random();
            randomLine = lines.get(r.nextInt(lines.size()));
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        //   randomLine="hell";
        return randomLine;
    }
    public String getvideoMessages()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("Dataset/video_links.txt"));
            String line = reader.readLine();
            List<String> lines = new ArrayList<String>();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            Random r = new Random();
            randomLine = lines.get(r.nextInt(lines.size()));
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        //   randomLine="hell";
        return randomLine;
    }

    public String getInitializationMessages()
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("input/initialization.txt"));
            String line = reader.readLine();
            List<String> lines = new ArrayList<String>();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            Random r = new Random();
            randomLine = lines.get(r.nextInt(lines.size()));
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        //   randomLine="hell";
        return randomLine;
    }
}
