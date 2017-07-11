import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TopTen  implements TopTenInterface {

    public String getHtml(URL url) {
        InputStream is = null;
        BufferedReader br;
        String line;
        StringBuilder sb = new StringBuilder();

        try {
            // url = new URL("https://www.klix.ba/");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            //configure connection
            is = connection.getURL().openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
               sb.append(line);
                System.out.println(line);
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
        return sb.toString();
    }


    public String getBody(String html) {
        int startIndex = html.indexOf("<body");
        int endIndex = html.indexOf("</body>", startIndex);
        return html.substring(startIndex, endIndex);
    }

    public String removeHtmlTags(String body) {
        StringBuilder sb = new StringBuilder();

        int start = -1;
        //int end = -1;
        for(int i=0; i < body.length(); i++)
        {
            char c = body.charAt(i);
            if(c == '<') {
                start = i;
                continue;
            }

            if(c == '>') {
                start = -1;
                sb.append('-');
                continue;
            }

            if(start > -1) continue;
            sb.append(c);

        }
        return sb.toString();
    }

    // dodati kontrolu za duzinu rijeci
    // dodati ignorecase
    // dodati blacklist

     public List<String> parseText(String text, List<Character> delimiters){ //hashmap ili nesto samo za lookup!

        List<String> res = new ArrayList<String>();

        int d=0; //position of last delimiter
        for(int i=0; i < text.length(); i++){
            char c = text.charAt(i);
            if(delimiters.contains(c)) {
                String word = text.substring(d,i);
                if(word.length() > 0) res.add(word);
                d = i+1;
            }
        }
        return res;
    }

/*
    public List<String> parseText(String text, List<Character> delimiters){ //hashmap ili nesto samo za lookup!

        List<String> res = new ArrayList<String>();
        HashMap<Integer, Character> delimiteri = new HashMap <Integer, Character> ();
        for (int i=0; i<delimiters.size(); i++)
            {
                delimiteri.put(i,delimiters.get(i) );
            }

        int d=0; //position of last delimiter
        for(int i=0; i < text.length(); i++){
            char c = text.charAt(i);
            if(delimiteri.containsValue(c)) {
                String word = text.substring(d,i);
                if(word.length() > 0) res.add(word);
                d = i+1;
            }
        }

        return res;
    }*/


    public Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> WordCount = new HashMap<String, Integer>();
        for(String w: words){
            if(WordCount.containsKey(w)) WordCount.put(w, WordCount.get(w) + 1);
            else WordCount.put(w,1);
        }
        return WordCount;
    }

}
