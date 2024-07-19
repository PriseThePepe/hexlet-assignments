package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    String error;
    NegativeRadiusException(String error){
        this.error = error;
    }
    NegativeRadiusException(){

    }

    @Override
    public String getMessage() {
        return error;
    }
}
// END
