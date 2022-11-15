import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
/*
--------------------------------------------------------------------------------------------------
SIMPLE SENTIMENT ANALYSIS                                                             (40 POINTS)
--------------------------------------------------------------------------------------------------
Sentiment Analysis is a Big Data problem used to get the attitude or sentiment of the writer based
on their written text. For instance, when analyzing movie reviews, “The film was a breath of fresh
air” has a positive statement while “It made me want to poke out my eye balls” is negative.

One algorithm that we can use for this is to assign a numeric value to any given word based on
how positive or negative that word is and then score the statement based on the values of the
words. But, how do we come up with our word scores in the first place?

That’s the problem that we’ll solve in this assignment. In the attachments, you will see a data
file movieReviews.tsv which contains movie reviews from the Rotten Tomatoes website which
have both a numeric score as well as text. The data file has four columns – phraseID,
sentenceID, the phrase and a sentiment score.

Your goal is to write a JAVA program that reads the given data file and aggregate the review score
per sentence. You will need to create an instance of a class named ReviewEntry for each word in
the file and track the total score assigned to the sentence.
You will need to write a function that computes the average score for each sentence and assigns
the following meaning to a word based on the average score:

--------------------------------------------------------------------------------------------------

0-2: negative
2-3: neutral
3-4: positive

--------------------------------------------------------------------------------------------------
[Part 1] Create a class called ReviewEntry which has the following elements: (i) a variable to track
the sentence ID, (ii) a variable to track the total score (which is the sum of all scores assigned to
the sentence) and (iii) a variable to track the number of phrases in the sentence. Create an array
of object instances of this class to account for each sentence in the file. You will have a total 8544
elements in the array.

--------------------------------------------------------------------------------------------------
[Part 2] Use FileIO operations in JAVA to read each entry in the movieReviews.tsv file and update
the  corresponding  entry  for  the  sentence.  For  example,  you  should  update  the  object  for
sentenceID 1 with each corresponding entry in movieReviews.tsv

--------------------------------------------------------------------------------------------------
[Part 3] Once you finish loading the entries in the file, ask the user for a sentence ID as input and
print the statistics of the corresponding sentence in the following format:

Sentence ID 1 has 15 phrases with an average rating of 3.5. The overall sentiment is positive.
--------------------------------------------------------------------------------------------------
 */
public class Ferrell_ProblemSentimentAnalysis {
    public static void main(String[] args) throws IOException {
        //calls the parseFile method that returns an array of ReviewEntries.
        ReviewEntry[] entries = parseFile();

        //Begins the looping search functionality.
        searching(entries);
    }

    public static void searching(ReviewEntry[] entries){
        Scanner scan = new Scanner(System.in);
        int input = 0;
        do {
            boolean going = true;
            while (going) {
                try {
                    System.out.print("_______________________________________ " +
                                   "\nInput a sentence ID or enter 0 to stop: ");
                    input = scan.nextInt();
                    going = false;
                }catch(Exception e){
                    scan.nextLine();
                    if(e.toString() == "java.util.InputMismatchException") {
                        System.out.println("You entered something other than an Integer\nTry again");
                    }else{
                        e.printStackTrace();
                    }
                }
            }
            if(input > 0 && input < 8545) {
                entries[input].printSearchedEntry();
            } else if (input == 0){
                System.out.println("\nEnding Program");
            } else {
                System.out.println("\nThere is not a review with that entry.");
            }
        } while(input != 0);
    }

    public static ReviewEntry[] parseFile() throws IOException {
        File movieReviews = null;
        try {
            movieReviews = new File("src/movieReviews.tsv");
        } catch (Exception e){
            try {
                movieReviews = new File("movieReviews.tsv");
            } catch (Exception f){
                System.out.println("movieReviews.tsv File not Found.\n Error thrown: " + f);
            }
        }
        List<String[]> list = Files.lines(movieReviews.toPath()).map(line -> line.split("\t")).collect(Collectors.toList());

        ReviewEntry[] entries = new ReviewEntry[8545];
        for (int i = 0; i < 8545; i++) {
            entries[i] = new ReviewEntry(i);
        }
        int b = 1;
        for (int i = 1; i < list.size(); i++) {
            if(b == 2628 || b == 2746 || b == 4044 || b == 4365 || b == 4761 || b == 5695 || b == 5916 || b == 6231 || b == 6358 || b == 6673 || b == 6922  || b == 7325 || b == 7473 || b == 8443 || b == 8530){
                b++;
            }
            //Creates the Main Object
            if(Integer.parseInt(list.get(i)[1]) == b) {
                entries[b] = new ReviewEntry(list.get(i));
                b++;
                if(b == 8545){
                    break;
                }
                //Adds phrases to the Main Object
            }else {
                if(b-1 == 2628 || b-1 == 2746 || b-1 == 4044 || b-1 == 4365 || b-1 == 4761 || b-1 == 5695 || b-1 == 5916 || b-1 == 6231 || b-1 == 6358 || b-1 == 6673 || b-1 == 6922 || b-1 == 7325 || b-1 == 7473 || b-1 == 8443 || b-1 == 8530){
                    entries[b - 2].addAPhrase(list.get(i));
                }else {
                    entries[b - 1].addAPhrase(list.get(i));
                }
            }
        }
        return entries;
    }
}