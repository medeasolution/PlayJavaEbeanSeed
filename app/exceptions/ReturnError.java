package exceptions;


public class ReturnError {



    private ReturnError() {
		// // Prevents instantiation
	}


    public static final String USER_NOT_FOUND     		  	= "001";
    public static final String USERNAME_TAKEN 			  	= "002";
    public static final String EMAIL_IN_USE		      	  	= "003";
    public static final String ALBUM_NOT_FOUND      	  	= "004";
    public static final String SESSION_ERROR			  	= "005";
    public static final String ERROR_GENERATING_USER_TOKEN 	= "006";
    public static final String ERROR_VALIDATING_USER_TOKEN	= "007";
    public static final String HEADER_TOKEN_EXPECTED		= "008";
    public static final String NOT_A_VALID_TOKEN			= "009";
    public static final String PHOTO_NOT_FOUND				= "010";
    public static final String ERROR_FILE_UPLOAD			= "011";
    public static final String FILE_IS_NOT_IMAGE			= "012";
    public static final String EMPTY_FILE 					= "013";
    public static final String FILE_IS_TOO_LARGE 			= "014";
    public static final String LIKE_LIMIT_EXCEEDED			= "015";
    public static final String TAG_LIMIT_EXCEEDED			= "016";
    public static final String PHOTO_LIMIT_EXCEEDED			= "017";
    public static final String FROM_GREATER_THAN_TO			= "018";
	public static final String FOLLOWERS_LIMIT_EXCEEDED 	= "019";
	public static final String FOLLOWING_LIMIT_EXCEEDED 	= "020";
	public static final String ALBUMS_LIMIT_EXCEEDED 		= "021";
	public static final String VENUE_NOT_FOUND		 		= "022";
	public static final String TIME_NOT_DATE		 		= "023";
	public static final String LIST_LIMIT_EXCEEDED			= "024";
	public static final String EMAIL_NOT_ALLOWED			= "025";
	public static final String USERNAME_NOT_ALLOWED 		= "026";
	public static final String BIO_IS_TOO_LONG				= "027";
	public static final String PASSWORD_DO_NOT_MATCH		= "028";
	public static final String WRONG_PASSWORD				= "029";
	public static final String PHOTO_ID_REQUIRED 			= "030";
	public static final String AVATAR_FILE_MANDATORY 		= "031";
	public static final String FACEBOOK_LOGIN_FAILED 		= "032";
	public static final String FACEBOOK_TOKEN_REQUIRED 		= "033";
	public static final String FACEBOOK_TOKEN_ASSIGNED_TO_ANOTHER_USER = "034";
	public static final String FACEBOOK_ACCESS_FAILED		= "035";
	public static final String FACEBOOK_FRIENDS_LIMIT		= "036";
	public static final String UPLOAD_PHOTO_TIMEOUT			= "037";
	public static final String ERROR_PHOTO_META_UPLOAD		= "038";
	public static final String MISSING_VENUE_PARAMETERS 	= "039";
	public static final String ERROR_CREATING_NEW_VENUE 	= "040";
	public static final String EXPLORE_LIMIT_EXCEEDED		= "041";
	public static final String NO_PERMISSION				= "042";
	public static final String VENUE_ALREADY_VERIFIED 		= "043";
	public static final String REQUIRED_PARAMETER_MISSING 	= "044";
	public static final String ERROR_ADDING_PHOTOS_TO_VENUE = "045";
	public static final String USERNAME_MAX_LENGTH 			= "046";
	public static final String APPLICATION_SETTINGS_IS_EMPTY 			= "047";
    public static final String LOGIN_FAILED = "048";
    public static final String WRONG_ROW_ID = "049";
    public static final String SUPPORT_SEND_ERROR = "050";
    public static final String WRONG_JSON = "051";
    public static final String RECOVER_PASSWORD_SEND_ERROR = "052";
    public static final String CLIENT_NOT_FOUND = "053";
    public static final String ENTITY_NOT_FOUND = "054";
}
