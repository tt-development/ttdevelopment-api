package ttdev.ttdevelopment.api.objects;

public class ProjectInformation {

	/* Information */
	private String id;
	private String title;
	private String shortDescription;
	private String longDescription;
	private String clientID;
	private String deadline;
	private String budget;
	
	/* Response */
	private boolean success;
	private String message;
	
	/* Request */
	private String type;
	private String file;
	private String url;
	private String path;
	
	
	public ProjectInformation(String id, String title, String shortDescription, String longDescription, String clientID, 
			String deadline, String budget, boolean success, String message, String type, String file, String url, String path) {
		/* Information */
		this.id = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.clientID = clientID;
		this.deadline = deadline;
		this.budget = budget;
		
		/* Response */
		this.success = success;
		this.message = message;
		
		/* Request */
		this.type = type;
		this.file = file;
		this.url = url;
		this.path = path;
	}
	
	public String getProjectID() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	public String getLongDescription() {
		return this.longDescription;
	}
	
	public String getClientID() {
		return this.clientID;
	}
	
	public String getDeadline() {
		return this.deadline;
	}
	
	public String getBudget() {
		return this.budget;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String getRequestType() {
		return this.type;
	}
	
	public String getRequestFile() {
		return this.file;
	}
	
	public String getRequestUrl() {
		return this.url;
	}
	
	public String getRequestPath() {
		return this.path;
	}
	
}
