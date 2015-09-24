package exceptions;

/**
 * Created by rmatei9 on 16/7/15.
 */
public class MissingRequiredFile extends Exception {

    public  MissingRequiredFile(String table, String field){
        super("MissingRequiredFile: field "+ field +" is necessary in table" + table);
    }
}
