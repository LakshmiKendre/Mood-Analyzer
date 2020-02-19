package exception;

public class MoodAnalyserException extends Exception {
  public   enum ExceptionEnum {
        MOOD_EMPTY, MOOD_NULL
    }
    public ExceptionEnum variable;
    public MoodAnalyserException(ExceptionEnum variable,String message) {
        super(message);
        this.variable=variable;
    }
}
