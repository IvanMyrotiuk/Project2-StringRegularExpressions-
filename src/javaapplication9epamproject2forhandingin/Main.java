package javaapplication9epamproject2forhandingin;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("---------------Our Text---------------");
        Text text = new Text("He-llo                 World!       This is the second project. How, are you! This is about String, I have used Regular Expression for this project. There is an on-going debate on the extent to which the writing of programs is an art form, a craft, or an engineering discipline. In general, good programming is considered to be the measured application of all three, with the goal of producing an efficient and evolvable software solution (the criteria for efficient\" and \"evolvable\" vary considerably). The discipline differs from many other technical professions in that programmers, in general, do not need to be licensed or pass any standardized (or governmentally regulated) certification tests in order to call themselves programmers or even software engineers. Because the discipline covers many areas, which may or may not include critical applications, it is debatable whether licensing is required for the profession as a whole. In most cases, the discipline is self-governed by the entities which require the programming, and sometimes very strict environments are defined. ");
        
        System.out.println(text.getText());

        //-->replace Sequence Of Whitespace And Tabulation
        System.out.println("---------------replace Sequence Of Whitespace And Tabulation---------------");
        text.replaceSequenceOfWhitespaceAndTabulation();
        System.out.println(text.getText());

        //-->Get List of sentences
        List<Sentence> listOfSentence= text.separateSentences();//get Sentences;

        System.out.println("---------------Get List of sentences---------------");
        for(int i= 0; i< listOfSentence.size();i++){
            System.out.println(listOfSentence.get(i).getSentence());
        }

        //-->Get Lists of Words
        System.out.println("---------------Get Lists of Words---------------");
        for(int i=0;i<listOfSentence.size();i++){
            List<Word> listOfWord = listOfSentence.get(i).separateWords();//get Words;
            System.out.println(listOfWord);//.toString());
            for(int j=0;j<listOfWord.size();j++){
                System.out.println(listOfWord.get(j).getWord());
            }

        }

        //-->Console for changing words in a sentence
        System.out.println("---------------Console for changing words in a sentence---------------");
        Scanner in = new Scanner(System.in);
        System.out.println("Input the number of sentences where you want to change words");
        int numberOfSentence = in.nextInt();
        System.out.println("Input length of word that we should change");
        int lengthOfWords = in.nextInt();
        System.out.println("Input word or substring to change the word");
        in.nextLine();
        String newSubstring = in.nextLine();

        //-->change Words In The Sentence
        System.out.println("---------------change Words In The Sentence---------------");
        listOfSentence.get(numberOfSentence).changeWordsInTheSentence(lengthOfWords, newSubstring);
        System.out.println(listOfSentence.get(numberOfSentence).getSentence());

        System.out.println("\n---------------Additional informations about project---------------");
        System.out.println("JavaApplication9EpamProject2ForHandingIn is used for handing in!!!");
        System.out.println("John\u2122");
    }

}
