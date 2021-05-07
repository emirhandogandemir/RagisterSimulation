package registerSimulation.core.utilities.results;

public class Result implements Consequence {
	private boolean success;
	private String message;
	
	public Result(boolean success) {
		this.success=success;
	}
	
	
	public Result(boolean success, String message) {
		this(success);
		this.message=message;
		
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
}
