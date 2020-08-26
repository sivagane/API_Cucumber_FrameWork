package utilities;


public class PayLoad {

	public static java.lang.Object createIssue(String summary, String description) {
		Project project = new Project();
		project.setKey("SIV");
		
		IssueType issuetype = new IssueType();
		issuetype.setName("Bug");
		
		Fields fields = new Fields();
		fields.setProject(project);
		fields.setSummary(summary);
		fields.setDescription(description);
		fields.setIssuetype(issuetype);
		
		Object object = new Object();
		object.setFields(fields);
		return object;
	}
	
	public static Object updateIssue() {
		Fields fields = new Fields();
		fields.setSummary("Updated Summary");
		fields.setDescription("Updated description");
		
		Object object = new Object();
		object.setFields(fields);
		return object;
	}
}
