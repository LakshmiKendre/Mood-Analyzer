package moodAnalyzer;

import exception.MoodAnalyserException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyzerFactory {

    public static MoodAnalyzer createMoodAnalyzerDefault() {
        try {
            Class<?> aClass = Class.forName("moodAnalyzer.MoodAnalyzer");
            Constructor<?> moodConstructor = aClass.getConstructor();
            Object objMood = moodConstructor.newInstance();
            return (MoodAnalyzer) objMood;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getConstructor(String classParam, Class methodParam) throws MoodAnalyserException {
        try {
            Class<?> aClass = Class.forName(classParam);
            return aClass.getConstructor(methodParam);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionEnum.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionEnum.NO_SUCH_METHOD, e.getMessage());
        }
    }

}
