package exceptions;

/**
 * Created by xavi on 7/17/15.
 */
public class InvalidRequiredParameter extends Exception {

    public  InvalidRequiredParameter(String table, String field){
        super("InvalidRequiredParameter: field "+ field +" in table" + table+" is invalid");
    }
}
