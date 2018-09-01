package ttdev.ttdevelopment.api.objects;

import java.util.ArrayList;

public class ProjectProgress {
	
	/* Progress */
	private ArrayList<Commit> commits = new ArrayList<>();
	
	/* Response */
	private boolean success;
	private String message;
	
	/* Request */
	private String type;
	private String file;
	private String url;
	private String path;

	public ProjectProgress(ArrayList<Commit> commits, boolean success, String message, String type, String file, String url, String path) {
		/* Commits */
		this.commits = commits;
		
		/* Response */
		this.success = success;
		this.message = message;
		
		/* Request */
		this.type = type;
		this.file = file;
		this.url = url;
		this.path = path;
	}
	
	public ArrayList<Commit> getCommits() {
		return this.commits;
	}
	
	public int getTotalCommits() {
		return this.commits.size();
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
