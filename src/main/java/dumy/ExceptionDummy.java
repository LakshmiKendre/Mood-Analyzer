package dumy;

public class ExceptionDummy {
    public static void main(String[] args) {
        ExceptionDummy exceptionDummy = new ExceptionDummy();
        exceptionDummy.dummy();
        System.out.println("I am in Main");
    }

    public void dummy(){
        System.out.println("I am in Dummy Method");
        dummy2();
    }

    public static void dummy2(){
        try{
            System.out.println(10/0);
        }
        catch (ArithmeticException e){
            e.printStackTrace();
        }

    }
}
