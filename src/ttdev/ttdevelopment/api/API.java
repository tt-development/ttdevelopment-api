package ttdev.ttdevelopment.api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ttdev.ttdevelopment.api.objects.Commit;
import ttdev.ttdevelopment.api.objects.ProjectInformation;
import ttdev.ttdevelopment.api.objects.ProjectProgress;

public class API {
	
	private static final String baseURL = "https://ttdevelopment.tk";
	
	public API() {
		
	}
	
	public static void main(String[] args) {
		
	}
	
	public ProjectInformation getProjectInformation(String projectID) {
		/* Get the payload */
		String payload = sendToUrl(projectID, "get.php");
		
		/* Parse json */
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(payload);
		
		/* Check if valid json */
		if (!element.isJsonObject()) {
			return null;
		}
		
		/* Process data */
		JsonObject object = element.getAsJsonObject();
		
		/* Parse Information */
		JsonElement informationElement = object.get("information");
		JsonObject information = informationElement.getAsJsonObject();
		
		String id = information.get("id").getAsString();
		String title = information.get("title").getAsString();
		String shortDescription = information.get("shortDescription").getAsString();
		String longDescription = information.get("longDescription").getAsString();
		String clientID = information.get("clientID").getAsString();
		String deadline = information.get("deadline").getAsString();
		String budget = information.get("budget").getAsString();
		
		/* Parse response */
		JsonElement responseElement = object.get("response");
		JsonObject response = responseElement.getAsJsonObject();
		
		boolean success = response.get("success").getAsBoolean();
		String message = response.get("message").getAsString();
		
		/* Parse request */
		JsonElement requestElement = object.get("request");
		JsonObject request = requestElement.getAsJsonObject();
		
		String type = request.get("type").getAsString();
		String file = request.get("file").getAsString();
		String url = request.get("url").getAsString();
		String path = request.get("path").getAsString();
		
		/* Create ProjectInformation */
		ProjectInformation projectInformation = new ProjectInformation(id, title, shortDescription, longDescription, clientID,
				deadline, budget, success, message, type, file, url, path);
		
		
		return projectInformation;
	}

	public ProjectProgress getProjectProgress(String projectID) {
		/* Get the payload */
		String payload = sendToUrl(projectID, "progress.php");
		
		/* Parse json */
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(payload);
		
		/* Check if valid json */
		if (!element.isJsonObject()) {
			return null;
		}
		
		/* Process data */
		JsonObject object = element.getAsJsonObject();
		
		/* Parse progress */
		JsonElement progressElement = object.get("progress");
		JsonObject progress = progressElement.getAsJsonObject();
		
		ArrayList<Commit> commits = new ArrayList<>();
		
		String repository = progress.get("repository").getAsString();
		
		for (int i=1; i < progress.get("commits").getAsInt() + 1; i++) {
			JsonElement progressElement2 = progress.get(String.valueOf(i));
			JsonObject progress2 = progressElement2.getAsJsonObject();
			
			String author = progress2.get("committer").getAsString();
			int size = progress2.get("commits").getAsInt();
			
			for (int a=1; a < size + 1; a++) {
				String description = progress2.get(String.valueOf(a)).getAsJsonObject().get("description").getAsString();
				String type = progress2.get(String.valueOf(a)).getAsJsonObject().get("type").getAsString();
				String url = progress2.get(String.valueOf(a)).getAsJsonObject().get("url").getAsString();
				
				commits.add(new Commit(description, type, url, repository, author));
			}
			
		}
		
		/* Parse response */
		JsonElement responseElement = object.get("response");
		JsonObject response = responseElement.getAsJsonObject();
		
		boolean success = response.get("success").getAsBoolean();
		String message = response.get("message").getAsString();
		
		/* Parse request */
		JsonElement requestElement = object.get("request");
		JsonObject request = requestElement.getAsJsonObject();
		
		String type = request.get("type").getAsString();
		String file = request.get("file").getAsString();
		String url = request.get("url").getAsString();
		String path = request.get("path").getAsString();
		
		/* Create project progress */
		ProjectProgress projectProgress = new ProjectProgress(commits, success, message, type, file, url, path);
		
		return projectProgress;
	}
	
	private String sendToUrl(String projectID, String file) {
		try {
			URL url = new URL(baseURL + "/api/order/" + file + "?id=975150743886298");
			
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			
			connection.addRequestProperty("User-Agent", "Mozilla/4.76"); 
			
		    DataOutputStream output = new DataOutputStream (connection.getOutputStream());
		    output.close();
		    
		    String toReturn = "";
		    
		    InputStream is = connection.getInputStream();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		    String line;
		    while ((line = rd.readLine()) != null) {
		    	toReturn = toReturn + line;
		    }
		    rd.close();
		    return toReturn;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
