
package models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProjectModel {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("commits_list")
    @Expose
    private List<String> commitsList = null;
    @SerializedName("edges")
    @Expose
    private List<Edge> edges = null;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<String> getCommitsList() {
        return commitsList;
    }

    public void setCommitsList(List<String> commitsList) {
        this.commitsList = commitsList;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }

}
