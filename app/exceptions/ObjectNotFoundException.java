package exceptions;

/**
 * Created by eric on 7/20/15.
 */
public class ObjectNotFoundException extends AppException {
    public ObjectNotFoundException(String apiError, String objectName){
        super(apiError, ObjectNotFoundException.buildMessage(objectName));
    }

    public static String buildMessage(String objectName){
        return "Object " + objectName + " not found";
    }
}
