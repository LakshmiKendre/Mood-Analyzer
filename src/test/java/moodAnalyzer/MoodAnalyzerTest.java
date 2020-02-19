package moodAnalyzer;

import exception.MoodAnalyserException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MoodAnalyzerTest {
    //private MoodAnalyzer moodAnalyze;
    @Test
    public void givenHappyMood_shouldReturnHappy() {
        String mood = null;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am Happy");
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("Happy", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenSadMood_shouldReturnSad() {
        String mood = null;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am Sad");
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("Sad",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenNullMood_shouldReturnMessage() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            ExpectedException expectedException=ExpectedException.none();
            expectedException.expect(MoodAnalyserException.class);

            String  mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("Enter valid Mood", mood);
        } catch (MoodAnalyserException e) {
           e.printStackTrace();
        }
    }

    @Test
    public void givenEmptyMood_shouldReturnMessage() {
        String mood = null;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
            mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("Mood can not be Empty",e.getMessage());
        }
    }

    @Test
    public void name() {
        String mood = null;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("Happy",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
}
