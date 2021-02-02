package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("project")
    @Expose
    private String project = null;
    @SerializedName("developers")
    @Expose
    private Integer developers = 0;
    @SerializedName("edges")
    @Expose
    private Integer edges = 0;
    @SerializedName("vertices")
    @Expose
    private Integer vertices = 0;
    @SerializedName("commits")
    @Expose
    private Integer commits = 0;
    @SerializedName("id")
    @Expose
    private Integer id = null;
    @SerializedName("agedays")
    @Expose
    private Integer agedays = 0;
    @SerializedName("refactorings")
    @Expose
    private Integer refactorings = 0;
    @SerializedName("group")
    @Expose
    private String group = null;
    @SerializedName("language")
    @Expose
    private String language = "en";
    @SerializedName("level")
    @Expose
    private String level = null;
    @SerializedName("summary")
    @Expose
    private String summary = null;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Integer getDevelopers() {
        return developers;
    }

    public void setDevelopers(Integer developers) {
        this.developers = developers;
    }

    public Integer getEdges() {
        return edges;
    }

    public void setEdges(Integer edges) {
        this.edges = edges;
    }

    public Integer getVertices() {
        return vertices;
    }

    public void setVertices(Integer vertices) {
        this.vertices = vertices;
    }

    public Integer getCommits() {
        return commits;
    }

    public void setCommits(Integer commits) {
        this.commits = commits;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAgedays() {
        return agedays;
    }

    public void setAgedays(Integer agedays) {
        this.agedays = agedays;
    }

    public Integer getRefactorings() {
        return refactorings;
    }

    public void setRefactorings(Integer refactorings) {
        this.refactorings = refactorings;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
