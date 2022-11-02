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

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

}