package ttdev.ttdevelopment.api.objects;

public class Commit {

	private String description;
	private CommitType type;
	private String url;
	private String repository;
	private String author;
	
	public Commit(String description, String type, String url, String repository, String author) {
		
		this.description = description;
		this.url = url;
		this.repository = repository;
		this.author = author;
		
		switch(type) {
			default:
				this.type = CommitType.CUSTOM;
				break;
			case "":
				this.type = CommitType.MERGE;
				break;
			case "Initial":
				this.type = CommitType.INITIAL;
				break;
		}
		
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public CommitType getType() {
		return this.type;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public String getRepository() {
		return this.repository;
	}
	
	public String getAuthor() {
		return this.author;
	}

}
