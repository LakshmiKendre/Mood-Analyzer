package exception;

public class MoodAnalyserException extends Exception {
  public   enum ExceptionEnum {
        MOOD_EMPTY, MOOD_NULL, NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS, OBJECT_CREATION_ISSUE,
        METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE
    }
    public ExceptionEnum variable;
    public MoodAnalyserException(ExceptionEnum variable,String message) {
        super(message);
        this.variable=variable;
    }

    public MoodAnalyserException(ExceptionEnum variable, Throwable cause) {
        super(cause);
        this.variable=variable;
    }

    public MoodAnalyserException(ExceptionEnum variable, String message, Throwable cause) {
        super(message, cause);
        this.variable=variable;
    }
}
