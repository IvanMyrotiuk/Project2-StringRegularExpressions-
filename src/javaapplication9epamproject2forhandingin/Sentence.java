package javaapplication9epamproject2forhandingin;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {

    private String sentence;
    private String sentenceForReplaceWords;
    private List<Word> words;
    public Sentence(String sentence){
        this.sentence = sentence;
        this.sentenceForReplaceWords = sentence;
    }

    //Separate Words and Get Lists of Words
    public List<Word> separateWords(){
        words = new ArrayList<Word>();

        //changing to whitespace
        Pattern changeToWhitespace = Pattern.compile("[.,?!]");
        Matcher matcherForChangingToWhitespace = changeToWhitespace.matcher(sentence);
        System.out.println(matcherForChangingToWhitespace.replaceAll(" "));
        sentence = matcherForChangingToWhitespace.replaceAll(" ");

        Pattern splitSentence = Pattern.compile("[^\\s]+");
        Matcher matchToTheEndOfWord = splitSentence.matcher(sentence);
        while(matchToTheEndOfWord.find()){
            words.add(new Word(matchToTheEndOfWord.group().trim()));
        }
        return words;
    }

    //change Words In The Sentence
    public void changeWordsInTheSentence(int length, String newWord){

        String pattern1 = "(\\s)?((\\w{"+length+"})|(\\w{"+(length+1)+",}))((\\s)|(\\. )|(\\, )|(\\? )|(\\! ))";//( ( )| ( ))
                                                                                                                //^1 ^2   ^3 groups
        //System.out.println("pattern = "+pattern1);
        System.out.println("sentenceForReplaceWords==> "+sentenceForReplaceWords);
        //Change all words that are matching to length and moreover words that are biger than it is neded to be
        //than is used backreference to the words that are biger than it is neded therefore result newWord\\w{length+1,}
        String sentence2 = sentenceForReplaceWords.replaceAll(pattern1," "+newWord+"$4$5");
        //System.out.println("sentence2 ="+sentence2);

        //To leave words without newWord(cut down newWord from newWord\\w{length+1,} therefore result is \\w{length+1,})
        String pattern2 = "(\\s)"+newWord+"(\\w{"+length+",})((\\s)|(\\. )|(\\, )|(\\? )|(\\! ))";
        //System.out.println("pattern2="+pattern2);
       
        this.sentence = sentence2.replaceAll(pattern2, "$1$2$3");

        //replace Sequence Of Whitespace And Tabulation
        Pattern replace = Pattern.compile("\\s{2,}");
        Matcher makeOneWhitespace = replace.matcher(this.sentence);
        this.sentence = makeOneWhitespace.replaceAll(" ");
        //System.out.println("77777");
    }

    //gets List Of Words if there are not sentences, method will throw ListOfWordsIsEmpty Exception
    //therefore at first you have to separate words by calling separateWords() method!!!
    public List<Word> getWords() throws ListOfWordsIsEmpty{
        if(words==null) throw new ListOfWordsIsEmpty();
        return words;
    }

    public String getSentence(){
        return this.sentence;
    }

}
