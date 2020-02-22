package moodAnalyzer;

import exception.MoodAnalyserException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

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
    public static MoodAnalyzer createMoodAnalyzer(String message) {
        try {
            Class<?> aClass = Class.forName("moodAnalyzer.MoodAnalyzer");
            Constructor<?> moodConstructor = aClass.getConstructor(String.class);
            Object objMood = moodConstructor.newInstance(message);

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

    public static String invokeMethod(MoodAnalyzer object, String methodName) throws MoodAnalyserException {
        try {
            return (String) object.getClass().getDeclaredMethod(methodName).invoke(object);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionEnum.NO_SUCH_METHOD, e.getMessage());
        }
        return null;
    }

    public static String setField(Object moodAnalyzer, String fieldName, String value) throws MoodAnalyserException {
        try {
            Field field = moodAnalyzer.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(moodAnalyzer,value);
            return (String) moodAnalyzer.getClass().getDeclaredMethod("analyzeMood").invoke(moodAnalyzer);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionEnum.NO_SUCH_FIELD, e.getMessage());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalyserException(MoodAnalyserException.ExceptionEnum.FIELD_INVOCATION_ISSUE, e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
