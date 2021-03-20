# MSRRefactoringThreatToValidatity

This repository is the threat to validatity experiment of the paper "Refactoring Graphs: Assessing Refactoring over Time" by Aline Brito, André C. Hora, Marco Tulio Valente. 
DBPL: https://dblp.org/rec/conf/wcre/BritoHV20.html

The experiment in this repo includes use of modified version of 2 existing project:

RefDiff: https://github.com/maheshmistry/MSRRefactoringGraphReproduce/tree/main/process/RefDiff
Refactoring Graph Script: https://github.com/maheshmistry/MSRRefactoringGraphReproduce/tree/main/process/refactoring-graph-scripts

## Baseline:

### Requirements
   For Java Project:
        Install Java (Optional, if you already have java and JDK installed no need to do this step)
        1. Go to link: https://www.java.com/en/download/
        2. Click on "Agree and start free download".
        3. After the download finish, run the "jre-8u281.exe" file.
        4. Click on install and after successful install finish it.
        5. You have sucessfully installed java.
        6. To confirm the successful install run "java -verison" in terminal and you should see the versions.

   For Python Project:
        Python 3+ : https://www.python.org/downloads/
        Pip : https://pypi.org/project/pip/
        Jupyter Notebook(little IDE approach but it is simple way to display charts): https://jupyter.org/install

### Installation

First of all, clone the project: ``` git clone https://github.com/maheshmistry/MSRRefactoringGraphThreatToValidatity.git``` 
Next go into the directory ```cd MSRRefactoringGraphThreatToValidatity```

#### RefDiff project:

This project generates the refactoring operations between commits of the given project(C/JS/Java).

Github: https://github.com/alinebrito/RefDiff

To run java code following steps needs to be followed:

Run this command:

```
java -jar process/JavaProjects.jar
```

The command will take csv file data (/data/dataset/saner-2020/java_git_projects.csv), which contains pre-selected Java project's github links. Each project is downloaded locally and refactoring operations between commits and other various details are given as output.(Example below)

Output Ex: 

|name_project|sha1|entity_before_full_name|entity_before_simple_name|entity_before_location|entity_after_full_name|entity_after_simple_name|entity_after_location|refactoring_level|refactoring_name|sha1|author_name|author_email|author_date|author_date_unix_timestamp|
|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|
|airbnb/lottie-android|5e12628a0ded9eb37473a3b7b54d0cccf8ef86be|lottie.src.main.com.airbnb.lottie.model.layer.BaseLayer#saveLayerCompat(Canvas,RectF,Paint,boolean)|saveLayerCompat(Canvas,RectF,Paint,boolean)|lottie/src/main/java/com/airbnb/lottie/model/layer/BaseLayer.java:6082:6644:6198:6643|lottie.src.main.com.airbnb.lottie.utils.Utils#saveLayerCompat(Canvas,RectF,Paint,int)|saveLayerCompat(Canvas,RectF,Paint,int)|lottie/src/main/java/com/airbnb/lottie/utils/Utils.java:8230:8719:8316:8718|MethodDeclaration|MOVE|5e12628a0ded9eb37473a3b7b54d0cccf8ef86be|1be83d735510848b88a08e43c2e114d9|7ecae5cb47c9c103eed6f86b807fe501|Tue Sep 3 23:38:03 2019 +0900|1567521483



#### Refactoring Graph Generator scripts project:

The project takes the refactoring csv file from the RefDiff project and generate Refactoring sub graphs you need to run the python script.
Github: https://github.com/alinebrito/refactoring-graph-scripts

Follow the steps below:

1. Install all requirement packages:  ``` pip install /process/requirements.txt```
2. Run the IPython Notebook: ```cd /process/refactoring-graph-scripts/scripts/python/``` and than ```jupyter notebook```
3. Click on the RunThis.ipynb
4. Run the program cells.
5. You will presented with 3 options after that: 

-> Select option 1 to Generate the refactoring subgraphs. See the results in /data/dataset/saner-2020/graphs.
-> Select option 2 to Generate views of refactoring subgraphs. See the results in /data/dataset/saner-2020/graphviz.
-> Select option 3 to Generate properties of refactoring subgraphs. See the results in /data/dataset/saner-2020/subgraphs_properties.csv.

6. Select 1, which will take refactoring csv file produced from RefDiff project. and make bunch of subgraphs csv files for each Java Project.
7. Select 3 to generate statistical properties of the subgraphs, this will take all the subgraphs and make a single properties csv file.
8. Running cells after that will make chart which answers the Research questions mentioned in the paper.

#### Research Questions Results:
     
RQ1 - What Is the Size of Refactoring Subgraphs?

![alt text](https://github.com/maheshmistry/MSRRefactoringGraphReproduce/blob/main/data/rq1-ver.png?raw=true)

![alt text](https://github.com/maheshmistry/MSRRefactoringGraphReproduce/blob/main/data/rq1-edge.png?raw=true)

RQ2 - How Many Commits Are in Refactoring Subgraphs?

![alt text](https://github.com/maheshmistry/MSRRefactoringGraphReproduce/blob/main/data/rq2-commit.png?raw=true)

RQ3 - What Is the Age of Refactoring Subgraphs?

![alt text](https://github.com/maheshmistry/MSRRefactoringGraphReproduce/blob/main/data/rq3-1.png?raw=true)
![alt text](https://github.com/maheshmistry/MSRRefactoringGraphReproduce/blob/main/data/rq3-2.png?raw=true)
![alt text](https://github.com/maheshmistry/MSRRefactoringGraphReproduce/blob/main/data/rq3-3.png?raw=true)
![alt text](https://github.com/maheshmistry/MSRRefactoringGraphReproduce/blob/main/data/rq3-4.png?raw=true)


### Delta

#### Process Delta:

* The paper didnt really explained the whole process of the algorithm and generation of refactoring graph. The paper just mentioned the tool of RefDiff to get the refactoring type between commits but we had to code up the main class to generate the desired csv as shown above to feed the python scripts.
* The algorithm to make the Refactoring graphs from the data of RefDiff, paper gave just 7 lines of basic graph generation code to just save methods as nodes and refactoring types as edges in graph. We tried to save the related data in edges and fetch later as needed but that created a lot of data mess. After that we contacted the authors of paper for the code and they provided the scripts for graph generation, which are much more complex than paper.
* The data analysis code for the research questions was still wrote by us as that was not the part of authors code.

#### Data Delta:
* Data was avaible easily as it was open source Github repo's link. 


## Experiment:

### Threat:

The one threat of validation is that for the research only Java Projects have been processed.

### Traces:

From the Paper: “Generalization of the results. We analyzed 1,150 refactoring subgraphs from 10 popular and open-source Java systems. Therefore, our dataset is built over credible and real-world software systems. Despite these observations, our findings—as usual in empirical software engineering—may not be directly generalized to other systems, particularly commercial, closed source, and the ones implemented in other languages than Java. Besides that, we focus our study on eight refactorings at the method level. Thus, other refactoring types can affect the size of subgraphs. We plan to extend this research to cover software systems implemented in other programming languages and refactorings at the class level.”

### Theory:

The first point is considered to be a threat because researchers have only processed Java Projects and result obtained from them cannot be generalized to other languages also (e.g: C and JavaScript). We will try to process the Project of C Language and Javascript and get refactoring types from them to analyze their data and compare them to other languages.

### Feasibility:

The first major threat mentioned by authors was that all the processed projects were open-source, thus limiting them to work on commercial and closed source projects. We cannot also perform the analysis on closed or commercial projects as we don't have access to them.

Many Threats of validity were given a proper reason as to why they are not implemented like: using a third-party tool called “REFDIFF” for getting refactoring. 

Here, authors have also mentioned the performance of another tool for getting refactoring types called “RMINER” as this tool performs better than REFDIFF ( F-measure of 92% (precision: 98%; recall 87%) improving on REFDIFF ’s overall accuracy.) but it only works for Java Language. 

Authors have also mentioned removing some methods like constructors and test methods as they don't have behaviours as usual methods. Also, the processing of the project is limited to its main branch as other branches can be unstable or experimental.

### Implementation

Steps followed for experiment implementation:

1. First we collected top 10(based on stars) github projects which as major language C++ and Javascript.
2. Initial RefDiff project was manuel process, where we had to give each project's link to generate refactoring file, We changed that to read from csv file(/data/dataset/java_git_projects.csv) and process every given project in csv file automatically on command call.
3. A jar file was created to run the RefDiff project and generate refactoring files.
4. The working of the RefDiff is in a waý that each commit is compared to given number of backward commit (e.g: If given 500, each commit of the project will be compared and look for refactoring operation to previous 500 commits only.) But usually each commit should be compared to each commit for better data. But while performing this most of the projects who has more than 10000 commits were thrownig memoery exceptions due to our system's low memory so we couldnt produce refactoring operations for all the projects. Than we selected projects with lowest 3 no. of commits for each language(Java/C++/Javascript).
5. Further we also found that RefDiff has problems with processing Javascript project, while not being able to solve all errors we dropped to check Javascript and focused only on Java and C++.
6. Refactoring Graphs(Python) part of the experiment was also changed to generate graphs for general language as previously Java project's data were hardcoded into that.
7. Option to generate vies of the graphs was dropped as it was not needed for the experiment.
8. To generate charts, a python notebook was created(/process/refactoring-graph-scripts/scripts/python/RunThis.ipynb).

### Process of Generation

1. Generate Refactoing files
   --Project's Github Links -- Provided via csv file(/data/dataset/{language}_git_projects.csv)
   -- Contains of this file can be changed to generate refactoring operations file for any other project. But, take care of the language(dont put C++ project in Java file)
   -- To generate that run ``` java -jar /process/JavaProjects.jar ```
   -- Refactoring file will be generated at /data/dataset/refactorings/refactorings_{Github UserName}_{projectName}_selected_operations.csv
   
2. Generate Refactoring Subgraphs and Subgraph Properties
   -- We have changed code for both feature to genearate refactoring subgraphs and its properties to process any given language not only java but to get input for that from user via notebook or command required to change a lot of structure of the project. So, we created the csv file for them and already uploaded them in repo.
   -- Refactoring Subgraphs file can seen at: /data/dataset/graphs/overtime_subgraphs_{Github UserName}_{projectName}.json
   -- Subgraph Properties file can be seen at: /data/dataset/{Language}_subgraphs_properties.csv
3. Generate charts for the Subgraph properties
   -- ``` cd /process/refactoring-graph-scripts/scripts/python/ ```
   Run the above command to go the scripts folder and open Jupyter Notebook: ``` jupyter notebook``` 
   -- Click and open RunThis.ipynb. Run the program cells. Second cell will ask for Language option, chosse from Java or C++, So specfic subgraph properties file will be loaded. E.g: If choosen C++ the charts generated in further cells will be from C++ subgraphs properties.
   -- To get charts of another language run the Language option cell again and choose desired language and run the chart cells.
   
   -- We made different cells for each chart, as to generate multiple chart single cell was very complex process.
   
### Results:

#### As mentioned before, we have used only 3 github projects for each Language, so they are in lesser quantity than Baseline charts.

RQ1 - What Is the Size of Refactoring Subgraphs?
--No. of Vertices:
Java: 
![alt text](https://github.com/maheshmistry/MSRRefactoringGraphThreatToValidatity/blob/main/data/java-rq-11.png?raw=true)
C++
![alt text](https://github.com/maheshmistry/MSRRefactoringGraphThreatToValidatity/blob/main/data/cpp-rq-11.png?raw=true)

--No. of Edges:
Java: 
![alt text](https://github.com/maheshmistry/MSRRefactoringGraphThreatToValidatity/blob/main/data/java-rq-12.png?raw=true)
C++
![alt text](https://github.com/maheshmistry/MSRRefactoringGraphThreatToValidatity/blob/main/data/cpp-rq-12.png?raw=true)

RQ2 - How Many Commits Are in Refactoring Subgraphs?

Java:
![alt text](https://github.com/maheshmistry/MSRRefactoringGraphThreatToValidatity/blob/main/data/cpp-rq-2.png?raw=true)
C++:
![alt text](https://github.com/maheshmistry/MSRRefactoringGraphThreatToValidatity/blob/main/data/cpp-rq-2.png?raw=true)

RQ3 - What Is the Age of Refactoring Subgraphs?

Java:
![alt text](https://github.com/maheshmistry/MSRRefactoringGraphThreatToValidatity/blob/main/data/cpp-rq-3.png?raw=true)
C++:
![alt text](https://github.com/maheshmistry/MSRRefactoringGraphThreatToValidatity/blob/main/data/cpp-rq-3.png?raw=true)

### Process
We changed code to use general languages to process but we kept process almost as same as Baseline.

### Data
We used projects for more Languages like C++. Also, we downloaded the data again for Assignment 3. So, any new commits for the used projects were also part of the contribution in stats.

