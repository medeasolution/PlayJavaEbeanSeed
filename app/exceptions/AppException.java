package exceptions;

public class AppException extends Exception {
 
	private String apiError;
	
	public AppException() { super(); }
	public AppException(String apiError, String message) {
		super(message); 
		this.apiError = apiError;
	}
	public AppException(String apiError, Exception e) {
		super(e.getMessage());
		this.apiError = apiError;
	}
	
	public String getApiError() {
		return apiError;
	}
	public void setApiError(String apiError) {
		this.apiError = apiError;
	}
	
}
