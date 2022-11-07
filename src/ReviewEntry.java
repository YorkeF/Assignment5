public class ReviewEntry {
    private int phraseId;
    private int sentenceId;
    private String phrase;
    private double sentiment = 0;
    private int numOfPhrases;

    private int total = 0;

    public ReviewEntry(){
        phraseId = 0;
        sentenceId = 0;
        phrase = "";
        sentiment = 0;
        total = 0;
        numOfPhrases = 0;
    }

    public ReviewEntry(int a){
        phraseId = 0;
        sentenceId = a;
        phrase = "";
        sentiment = 0;
        total = 0;
        numOfPhrases = 0;
    }

    public ReviewEntry(int phraseId, int sentenceId, String phrase, int sentiment){
        this.sentiment = sentiment;
        this.phrase = phrase;
        this.sentenceId = sentenceId;
        this.phraseId = phraseId;
    }

    public ReviewEntry(String[] entry){
        phraseId = Integer.parseInt(entry[0]);
        sentenceId = Integer.parseInt(entry[1]);
        phrase = entry[2];
        total = Integer.parseInt(entry[3]);
        sentiment = 0;
        numOfPhrases = 1;
    }

    public void setNumOfPhrases(int numOfPhrases) {
        this.numOfPhrases = numOfPhrases;
    }

    public int getNumOfPhrases() {
        return numOfPhrases;
    }

    public void addAPhrase(String[] line) {
        total += Integer.parseInt(line[3]);
        numOfPhrases++;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public int getPhraseId() {
        return phraseId;
    }

    public void setPhraseId(int phraseId) {
        this.phraseId = phraseId;
    }

    public int getSentenceId() {
        return sentenceId;
    }

    public int getSentiment() {
        return (int) sentiment;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setSentenceId(int sentenceId) {
        this.sentenceId = sentenceId;
    }

    public void setSentiment(int sentiment) {
        this.sentiment = sentiment;
    }

    public void computeAvgSentiment(){

    }

    public void printEntry(){
        if( numOfPhrases != 0 ) {
            sentiment = (double)total / (double)numOfPhrases;
        }else {
            sentiment = 0;
        }

        System.out.println("\nSentence ID: " + sentenceId + "\nPhrase: " + phrase + "\nSentiment: " + sentiment);
    }

}
