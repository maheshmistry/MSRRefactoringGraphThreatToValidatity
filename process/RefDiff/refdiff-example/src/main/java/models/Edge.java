package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Edge {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("before")
    @Expose
    private String before;
    @SerializedName("lineB")
    @Expose
    private Object lineB;
    @SerializedName("after")
    @Expose
    private String after;
    @SerializedName("lineA")
    @Expose
    private Object lineA;
    @SerializedName("ref")
    @Expose
    private String ref;
    @SerializedName("sha1")
    @Expose
    private String sha1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public Object getLineB() {
        return lineB;
    }

    public void setLineB(Object lineB) {
        this.lineB = lineB;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public Object getLineA() {
        return lineA;
    }

    public void setLineA(Object lineA) {
        this.lineA = lineA;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

}
