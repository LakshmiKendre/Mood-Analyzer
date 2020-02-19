package moodAnalyzer;

import exception.MoodAnalyserException;

public class MoodAnalyzer {

    public String analyzeMood(String mood) throws MoodAnalyserException {

        try {
            if (mood.contains("")) {
                throw new MoodAnalyserException("Mood can not be Empty");
            }
            if (mood.contains("Happy")) {
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
