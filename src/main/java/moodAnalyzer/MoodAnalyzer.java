package moodAnalyzer;

import exception.MoodAnalyserException;

import javax.swing.*;
import java.lang.reflect.Method;

public class MoodAnalyzer {
    private String mood;

    public MoodAnalyzer() {
        mood="Default";
    }

    public MoodAnalyzer(String message) {
        mood = message;
    }

    public String analyzeMood(String message) throws MoodAnalyserException {
        mood = message;
        return analyzeMood();
    }

    public String analyzeMood() throws MoodAnalyserException {

        try {
            if (mood.length() == 0 ) {
                throw new MoodAnalyserException(MoodAnalyserException.ExceptionEnum.MOOD_EMPTY,"Mood can not be Empty");
            }
            if (mood.contains("Happy"))
                return "Happy";
            else
                return "Sad";
        }
        catch(NullPointerException e){
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionEnum.MOOD_NULL,"Enter valid Mood");
            //return "Happy";
        }
    }

    public boolean equals(Object another) {
        if (mood.equals(((MoodAnalyzer) another).mood)) {
            return true;
        }
        return false;
    }


}
