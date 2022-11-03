public class ReviewEntry {
    private int phraseId;
    private int sentenceId;
    private String phrase;
    private int sentiment;
    private int numOfPhrases;

    public ReviewEntry(){
        phraseId = 0;
        sentenceId = 0;
        phrase = "";
        sentiment = 0;
        System.out.println("Default Constructor");
    }

    public ReviewEntry(int phraseId, int sentenceId, String phrase, int sentiment){
        this.sentiment = sentiment;
        this.phrase = phrase;
        this.sentenceId = sentenceId;
        this.phraseId = phraseId;
    }

    public ReviewEntry(String[] entry){
        System.out.print("Creating an Entry: ");
        phraseId = Integer.parseInt(entry[0]);
        sentenceId = Integer.parseInt(entry[1]);
        System.out.print(sentenceId + "\n           Phrase: ");
        phrase = entry[2];
        System.out.print(phrase + "\n        Sentiment: ");
        sentiment = Integer.parseInt(entry[3]);
        System.out.print(sentiment + "\n\n");
        numOfPhrases = 1;
    }

    public void setNumOfPhrases(int numOfPhrases) {
        this.numOfPhrases = numOfPhrases;
    }

    public int getNumOfPhrases() {
        return numOfPhrases;
    }

    public void addAPhrase(String[] line) {
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
        return sentiment;
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

    public void printEntry(){
        System.out.println(phraseId + ", " + sentenceId + ", " + phrase + ", " + sentiment);
    }

}
