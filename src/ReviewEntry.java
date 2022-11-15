public class ReviewEntry {
    private final int sentenceId;
    private final String phrase;
    private double sentiment;
    private int numOfPhrases;

    private int total;
    public ReviewEntry(int a){
        sentenceId = a;
        phrase = "";
        sentiment = 0;
        total = 0;
        numOfPhrases = 0;
    }
    public ReviewEntry(String[] entry){
        sentenceId = Integer.parseInt(entry[1]);
        phrase = entry[2];
        total = Integer.parseInt(entry[3]);
        sentiment = 0;
        numOfPhrases = 1;
    }
    public String getPositivity(){
        if( numOfPhrases != 0 ) {
            sentiment = (double)total / (double)numOfPhrases;
        }else {
            sentiment = 0;
        }

        String positivity;
        if (sentiment < 2){
            positivity = "Negative";
        } else if (sentiment < 3) {
            positivity = "Neutral";
        } else {
            positivity = "Positive";
        }

        return positivity;
    }
    public void addAPhrase(String[] line) {
        total += Integer.parseInt(line[3]);
        numOfPhrases++;
    }
    public double getSentiment() {
        if( numOfPhrases != 0 ) {
            sentiment = (double)total / (double)numOfPhrases;
        }else {
            sentiment = 0;
        }
        return sentiment;
    }
    public void printSearchedEntry(){
        int b = this.sentenceId;
        if(b == 2628 || b == 2746 || b == 4044 || b == 4365 || b == 4761 || b == 5695 || b == 5916 || b == 6231 || b == 6358 || b == 6673 || b == 6922  || b == 7325 || b == 7473 || b == 8443 || b == 8530){
            System.out.println("\nThere is not a review with that sentence ID\n");
        } else {
            System.out.printf("\nSentence ID " + sentenceId + " has " + numOfPhrases + " phrases with an average rating of " + "%.2f"
                    + ". The overall sentiment is " + this.getPositivity() + ".\n\n", this.getSentiment());
        }
    }

}
