package moodAnalyzer;

import exception.MoodAnalyserException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MoodAnalyzerTest {
    private MoodAnalyzer moodAnalyzer;
    @Before
    public void setUp() throws Exception {
        moodAnalyzer=new MoodAnalyzer();
    }
    @Test
    public void givenHappyMood_shouldReturnHappy() {
        String mood = null;
        try {
            mood = moodAnalyzer.analyzeMood("Happy");
            Assert.assertEquals("Happy", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenSadMood_shouldReturnSad() {
        String mood = null;
        try {
            mood = moodAnalyzer.analyzeMood("Sad");
            Assert.assertEquals("Sad",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void givenNullMood_shouldReturnNull() {
        String mood = null;
        try {
            mood = moodAnalyzer.analyzeMood(null);
            Assert.assertEquals("Happy", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenEmptyMood_shouldReturnTrue() {
        try {
            String mood = moodAnalyzer.analyzeMood("");
            Assert.assertEquals("Happy",mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }
}
