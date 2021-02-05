package refdiff.examples;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.google.gson.Gson;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.TimeZone;

import models.Commit;
import models.Edge;
import models.Info;
import models.ProjectModel;
import refdiff.core.RefDiff;
import refdiff.core.diff.Relationship;
import refdiff.parsers.c.CPlugin;
import refdiff.parsers.java.JavaPlugin;

public class JavaModeReffDif2 {
	private String url;
	private JavaPlugin javaPlugin;
	private RefDiff refDiffC;
	private File tempFolder;
	private ProjectModel projectModel;
	private Info info; 
	private List<Commit> commits;
	private List<Edge> edges;
	private String projectName;
	private int developer=0;
	private int vertice=0;
	private int agedays=0;
	private int edgeCounter=0;
	private String startingCommit;
	public JavaModeReffDif2(String url, String projectName, String startingCommit) throws Exception {
		this.url = url;
		this.projectName = projectName;
		this.startingCommit = startingCommit;
		this.tempFolder = new File("temp");
		this.javaPlugin = new JavaPlugin(this.tempFolder);
		this.refDiffC = new RefDiff(javaPlugin);
		this.projectModel = new ProjectModel();
		this.info = new Info();
		this.commits = new ArrayList<Commit>();
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
				try {
				// You can also mine refactoring from the commit history. In this example we navigate
				// the commit graph backwards up to 5 commits. Merge commits are skipped.
					FileWriter csvWriter;
					csvWriter = new FileWriter(this.tempFolder+".csv");
					csvWriter.append("name_project");
					csvWriter.append(";");
					csvWriter.append("sha1");
					csvWriter.append(";");
					csvWriter.append("entity_before_full_name");
					csvWriter.append(";");
					csvWriter.append("entity_before_simple_name");
					csvWriter.append(";");
					csvWriter.append("entity_before_location");
					csvWriter.append(";");
					csvWriter.append("entity_after_full_name");
					csvWriter.append(";");
					csvWriter.append("entity_after_simple_name");
					csvWriter.append(";");
					csvWriter.append("entity_after_location");
					csvWriter.append(";");
					csvWriter.append("refactoring_level");
					csvWriter.append(";");
					csvWriter.append("author_name");
					csvWriter.append(";");
					csvWriter.append("author_date_unix_timestamp");
					csvWriter.append(";");
					csvWriter.append("\n");
					refDiffC.computeDiffForCommitHistory(angularJsRepo,this.startingCommit, 500, (commit, diff) -> {
					if(diff.getRefactoringRelationships().size()>0) {
					for (Relationship rel : diff.getRefactoringRelationships()) {
						if(rel.getStandardDescription()!=""
							|| rel.getStandardDescription() != null) {
							
							this.edgeCounter++;
							try {
								csvWriter.append(this.projectName+";"+
										commit.getId().getName().toString()+";"+
										rel.getNodeBefore().getLocation()+";"+
										rel.getNodeBefore().getLocation().getFile()+";"+
										rel.getNodeBefore().getLocalName()+";"+
										rel.getNodeAfter().getLocation()+";"+
										rel.getNodeAfter().getLocation().getFile()+";"+
										rel.getNodeAfter().getLocalName()+";"+
										rel.getType().toString()+";"+
										commit.getCommitterIdent().getEmailAddress()+";"+
										getDateFromSecs(commit.getCommitTime())+";"
										);
								csvWriter.append("\n");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println(rel.getStandardDescription());
					}
					}
				});
					csvWriter.flush();
					csvWriter.close();
				}catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
				
	}
	
	public String getDateFromSecs(long millis) {
		Date date = new Date(millis*1000);
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE,MMMM d,yyyy h:mm,a", Locale.ENGLISH);
		sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		return sdf.format(date);
		
	}
}
