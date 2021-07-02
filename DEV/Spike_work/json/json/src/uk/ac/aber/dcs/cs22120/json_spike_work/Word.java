package uk.ac.aber.dcs.cs22120.json_spike_work;

/**
 * Class to store processed data from the JSON file, stores
 * English, Welsh and word type.
 *
 * @author jor69
 * @version 1.1.0
 */

public class Word {

    //Instance variables
    private String english;
    private String welsh;
    private String wordType;

    public Word() {
        this.welsh = "foo";
        this.english = "foo";
        this.wordType = "foo";
    }

    public Word(String welsh, String english, String wordType) {
        this.welsh = welsh;
        this.english = english;
        this.wordType = wordType;
    }

    public String getWelsh() {
        return this.welsh;
    }

    public void setWelsh(String welsh) {
        this.welsh = welsh;
    }

    public String getEnglish() {
        return this.english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("\nWelsh: ");
        builder.append(welsh);
        builder.append(", English: ");
        if(wordType.equals("verb")) {
             builder.append("to ");
        }
        builder.append(english);
        builder.append(", Word type: ");
        if(wordType.equals("nf")) {
            builder.append("feminine noun");
        } else if(wordType.equals("nm")) {
            builder.append("masculine noun");
        } else {
            builder.append(wordType);
        }

        return builder.toString();
    }
}
