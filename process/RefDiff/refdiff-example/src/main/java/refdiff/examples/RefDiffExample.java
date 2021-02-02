package refdiff.examples;

import java.io.File;

import models.Info;
import models.ProjectModel;
import refdiff.core.RefDiff;
import refdiff.core.diff.CstDiff;
import refdiff.core.diff.Relationship;
import refdiff.parsers.c.CPlugin;
import refdiff.parsers.java.JavaPlugin;
import refdiff.parsers.js.JsPlugin;

public class RefDiffExample {
	
	public static void main(String[] args) throws Exception {
		runExamples();
	}
	
	private static void runExamples() throws Exception {
	
//		JsModeReffDif jMRD = new JsModeReffDif("https://github.com/refdiff-study/angular.js.git", "AngularJs","840b5f0a7634efdf4d6ed81a52e66fc0e0620127");
//		jMRD.checkCommits();
//
//		CModeReffDif cMRD = new CModeReffDif("https://github.com/refdiff-study/git.git", "refdiff-study","ba97aea1659e249a3a58ecc5f583ee2056a90ad8");
//		cMRD.checkCommits();
		
		JavaModeReffDif javaMRD = new JavaModeReffDif("https://github.com/airbnb/lottie-android.git", "lottie-android","2ccdac06f95f68752abdede79770f5a8904e7e12");
		javaMRD.checkCommits();

	}
	
}
