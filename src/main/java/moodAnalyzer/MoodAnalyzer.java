package moodAnalyzer;

import exception.MoodAnalyserException;

public class MoodAnalyzer {
    private String mood;

    public MoodAnalyzer() {
    }
    public MoodAnalyzer(String message) {
        mood = message;
    }

    public String analyzeMood() throws MoodAnalyserException {

        try {
            if (mood.contains("")) {
                throw new MoodAnalyserException("Mood can not be Empty");
            }
            if (mood.contains("I am Happy")) {
                return "Happy";
            }
            return "Sad";
        }
        catch(NullPointerException e){
            throw new MoodAnalyserException("Enter valid Mood");
            //return "Happy";
        }
    }
}
