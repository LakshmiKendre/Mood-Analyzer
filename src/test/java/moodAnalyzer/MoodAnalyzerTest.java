package moodAnalyzer;

import exception.MoodAnalyserException;
import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTest {

    // test cases for analysing mood with parameterized constructor
    // Happy
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

    // Sad
    @Test
    public void givenSadMood_shouldReturnSad() {
        String mood = null;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am Sad");
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("Sad", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    // Null
    @Test
    public void givenNullMood_shouldReturnMessage() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try {
            //ExpectedException expectedException=ExpectedException.none();
            //expectedException.expect(MoodAnalyserException.class);
            String mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("Enter valid Mood", e.getMessage());
        }
    }

    // Empty
    @Test
    public void givenEmptyMood_shouldReturnMessage() {
        String mood = null;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
            mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals("Mood can not be Empty", e.getMessage());
        }
    }

    // test case for analyzing mood with default constructor
    @Test
    public void name() {
        String mood = null;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
            mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("Sad", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    // test cases for analysing mood with throwing Exception
    // Null
    @Test
    public void givenNullMood_shouldReturnExceptionMessage() {
        String mood = null;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
            mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionEnum.MOOD_NULL, e.variable);
        }
    }

    // Empty
    @Test
    public void givenEmptyMood_shouldReturnExceptionMessage() {
        String mood = null;
        try {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
            mood = moodAnalyzer.analyzeMood();
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionEnum.MOOD_EMPTY, e.variable);
        }
    }

    @Test
    public void givenMoodAnalyzer_whenProper_shouldReturnObject() {
        try {
            Constructor<?> constructor = Class.forName("moodAnalyzer.MoodAnalyzer").getConstructor(String.class);
            Object object = constructor.newInstance("I am Happy");
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) object;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //4.1 test method to check if the two objects are equal are not
    @Test
    public void givenMoodAnalyzerClassObject_whenProper_ShouldReturnTrue() {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzerDefault();
        Assert.assertEquals(new MoodAnalyzer(), moodAnalyzer);
    }

    //5 test method for MoodAnalyzerFactory should return MoodAnalyzer Object
    @Test
    public void givenMoodAnalyzerClass_whenProper_shouldReturnObject() {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("I am Happy");
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("Happy", mood);
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
    }

    //5.1 test method to check if the two objects are equal are not
    @Test
    public void givenMoodAnalyzerClassObject_whenProper_shouldReturnTrue() {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("I am Happy");
        Assert.assertEquals(new MoodAnalyzer("I am Happy"), moodAnalyzer);
    }

    //5.2 test method to throw NoSuchClassException by giving wrong class name
    @Test
    public void givenClassName_whenImproper_throwMoodAnalysisException() {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor("moodAnalyzer.Moodanalyzer", String.class);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionEnum.NO_SUCH_CLASS, e.variable);
        }
    }

    //5.3 test method to throw NoSuchMethodException by passing wrong parameter to constructor
    @Test
    public void givenMethodName_whenImproper_throwMoodAnalysisException() {
        try {
            Constructor<?> constructor = MoodAnalyzerFactory.getConstructor("moodAnalyzer.MoodAnalyzer", Integer.class);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionEnum.NO_SUCH_METHOD, e.variable);
        }
    }

    // test case for Invoking method by using Reflection
    @Test
    public void givenHappyUsingReflection_whenProper_shouldReturnHappy() {
        MoodAnalyzer object = MoodAnalyzerFactory.createMoodAnalyzer("I am Happy");
        String mood = null;
        try {
            mood = MoodAnalyzerFactory.invokeMethod(object, "analyzeMood");
        } catch (MoodAnalyserException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("Happy", mood);
    }

    // test case for if given improper name of method should return MoodAnalyzerException
    @Test
    public void givenHappyMessage_whenImproperMethodName_shouldReturnMoodAnalyzerException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzerDefault();
            String mood = MoodAnalyzerFactory.invokeMethod(moodAnalyzer, "analyzemood");
            Assert.assertEquals("Happy", mood);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionEnum.NO_SUCH_METHOD, e.variable);
        }
    }

    @Test
    public void givenHappyMessage_withReflector_shouldReturnNoSuchFieldException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzerDefault();
            String mood = MoodAnalyzerFactory.setField(moodAnalyzer, "Mood","sad");
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionEnum.NO_SUCH_FIELD, e.variable);
        }
    }

    @Test
    public void givenHappyMessage_withReflector_shouldThrowException() {
        try {
            MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzerDefault();
            String mood = MoodAnalyzerFactory.setField(moodAnalyzer, "mood",null);
        } catch (MoodAnalyserException e) {
            Assert.assertEquals(MoodAnalyserException.ExceptionEnum.FIELD_INVOCATION_ISSUE, e.variable);
        }
    }
}