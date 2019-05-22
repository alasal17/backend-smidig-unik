package exceptions;

public class ProjectIdExceptionResponse {

    private String projectIdentifier;

    public ProjectIdExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getUserId() {
        return projectIdentifier;
    }

    public void setUserId(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
