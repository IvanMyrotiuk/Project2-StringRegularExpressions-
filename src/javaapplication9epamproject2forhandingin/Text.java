package javaapplication9epamproject2forhandingin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private List<Sentence> sentences;

    private String text;

    public Text(String text){
        this.text = text;
    }

    public String getText(){
        return this.text;
    }

    //-->replace Sequence Of Whitespace And Tabulation
    public void replaceSequenceOfWhitespaceAndTabulation(){
        Pattern replace = Pattern.compile("\\s{2,}");
        Matcher makeOneWhitespace = replace.matcher(this.text);
        this.text = makeOneWhitespace.replaceAll(" ");
    }

    //gets Sentences
    public List<Sentence> separateSentences(){

        sentences = new ArrayList<Sentence>();
        Pattern endSentence = Pattern.compile("[^.|!|?]+((\\.\\s)|(\\!\\s)|(\\?\\s))");
        Matcher matchToTheEndSentence = endSentence.matcher(this.text);
        while(matchToTheEndSentence.find()){
            if(matchToTheEndSentence.group()!=null){
                //System.out.println(matchToTheEndSentence.group().trim());
                sentences.add(new Sentence(matchToTheEndSentence.group()));
            }

        }
        return sentences;
    }

    //gets List Of Sentences if there are not sentences, method will throw NoSentence Exception
    //therefore at first you have to separate sentences by calling separateSentences() method!!!
    public List<Sentence> getSentances() throws NoSentences{
        if(sentences==null)throw new NoSentences();
        return sentences;
    }


}
