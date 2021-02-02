package refdiff.examples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import models.Edge;
import models.Info;
import models.ProjectModel;
import refdiff.core.RefDiff;
import refdiff.core.diff.Relationship;
import refdiff.parsers.c.CPlugin;
import refdiff.parsers.java.JavaPlugin;

public class JavaModeReffDif {
	private String url;
	private JavaPlugin javaPlugin;
	private RefDiff refDiffC;
	private File tempFolder;
	private ProjectModel projectModel;
	private Info info; 
	private List<String> commits;
	private List<Edge> edges;
	private String projectName;
	private int developer=0;
	private int vertice=0;
	private int agedays=0;
	private int edgeCounter=0;
	private String startingCommit;
	public JavaModeReffDif(String url, String projectName, String startingCommit) throws Exception {
		this.url = url;
		this.projectName = projectName;
		this.startingCommit = startingCommit;
		this.tempFolder = new File("temp");
		this.javaPlugin = new JavaPlugin(this.tempFolder);
		this.refDiffC = new RefDiff(javaPlugin);
		this.projectModel = new ProjectModel();
		this.info = new Info();
		this.commits = new ArrayList<String>();
		this.edges = new ArrayList<Edge>();
	}
	
	public void checkCommits() throws Exception {
				// Clone the angular.js GitHub repo.
				File angularJsRepo = refDiffC.cloneGitRepository(
					new File(this.tempFolder, "java"),
					this.url);
				this.info.setProject(this.projectName);
				this.info.setId(1);
				this.info.setLanguage("java");
				// You can also mine refactoring from the commit history. In this example we navigate
				// the commit graph backwards up to 5 commits. Merge commits are skipped.
				refDiffC.computeDiffForCommitHistory(angularJsRepo,this.startingCommit, 1300, (commit, diff) -> {
					if(diff.getRefactoringRelationships().size()>0) {
						this.commits.add(commit.getId().getName().toString());
					for (Relationship rel : diff.getRefactoringRelationships()) {
						if(rel.getStandardDescription()!=""
							|| rel.getStandardDescription() != null) {
							this.edgeCounter++;
							Edge edge = new Edge();
							edge.setId(this.edgeCounter);
							edge.setBefore(rel.getNodeBefore().getLocation().getFile());
							edge.setAfter(rel.getNodeAfter().getLocation().getFile());
							edge.setSha1(commit.getId().getName());
							edge.setRef(rel.getType().toString());
							this.edges.add(edge);
						}
						System.out.println(rel.getStandardDescription());
					}
					}
				});
				this.info.setCommits(this.commits.size());
				projectModel.setInfo(info);
				projectModel.setEdges(edges);
				projectModel.setCommitsList(commits);
				 try {
				      FileWriter myWriter = new FileWriter(this.projectName+".json");
				      myWriter.write(new Gson().toJson(this.projectModel));
				      myWriter.close();
				      System.out.println("Successfully wrote to the file.");
				    } catch (IOException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }
				
	}
}
