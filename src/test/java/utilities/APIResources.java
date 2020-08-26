package utilities;

public enum APIResources {

	createIssueApi("/rest/api/2/issue"), 
	updateIssueApi("/rest/api/2/issue"), 
	getAllIssueApi("/rest/api/2/search"), 
	deleteIssueApi("/rest/api/3/issue");

	String resource;

	APIResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

}
