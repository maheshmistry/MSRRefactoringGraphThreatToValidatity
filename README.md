# MSRRefactoringGraphReproduce

This repository is the reproduction of the paper "Refactoring Graphs: Assessing Refactoring over Time" by Aline Brito, André C. Hora, Marco Tulio Valente. 
DBPL: https://dblp.org/rec/conf/wcre/BritoHV20.html

The repo contains 3 project:

RefDiff: https://github.com/maheshmistry/MSRRefactoringGraphReproduce/tree/main/process/RefDiff
Refactoring Graph: https://github.com/maheshmistry/MSRRefactoringGraphReproduce/tree/main/process/refactoring-graph
Refactoring Graph Script: https://github.com/maheshmistry/MSRRefactoringGraphReproduce/tree/main/process/refactoring-graph-scripts

## Installation

#### RefDiff project:

This project generates the refactoring operations between commits of the given project(C/JS/Java).

Github: https://github.com/alinebrito/RefDiff

To run java code following steps needs to be followed:

```
1. Go to 'RefDiff' folder in 'process' folder.(/process/RefDiff)
2. import all the projects in the eclipse.
3. Go to 'RefDIff' project' and open refdiff.examples' package.
4. Open 'RefdiffExample.java' file and run it as 'java project'.
5. Once everything is done output will be csv(temp.csv) file.
6. This csv will be located in the 'RefDiff' folder.
7. This csv will be used in python script.
```

Output Ex: 

|name_project|sha1|entity_before_full_name|entity_before_simple_name|entity_before_location|entity_after_full_name|entity_after_simple_name|entity_after_location|refactoring_level|refactoring_name|sha1|author_name|author_email|author_date|author_date_unix_timestamp|
|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|--------|
|airbnb/lottie-android|5e12628a0ded9eb37473a3b7b54d0cccf8ef86be|lottie.src.main.com.airbnb.lottie.model.layer.BaseLayer#saveLayerCompat(Canvas,RectF,Paint,boolean)|saveLayerCompat(Canvas,RectF,Paint,boolean)|lottie/src/main/java/com/airbnb/lottie/model/layer/BaseLayer.java:6082:6644:6198:6643|lottie.src.main.com.airbnb.lottie.utils.Utils#saveLayerCompat(Canvas,RectF,Paint,int)|saveLayerCompat(Canvas,RectF,Paint,int)|lottie/src/main/java/com/airbnb/lottie/utils/Utils.java:8230:8719:8316:8718|MethodDeclaration|MOVE|5e12628a0ded9eb37473a3b7b54d0cccf8ef86be|1be83d735510848b88a08e43c2e114d9|7ecae5cb47c9c103eed6f86b807fe501|Tue Sep 3 23:38:03 2019 +0900|1567521483



#### Refactoring Graph Generator scripts project:

The project takes the csv file from the RefDiff project and generate Refactoring sub graphs you need to run the python script.
Github: https://github.com/alinebrito/refactoring-graph-scripts

Follow the steps below:

1. Put the csv file in "/process/refactoring-graph-scripts/dataset/saner-2020/refactorings" folder and rename it as refactorings_{Project_Name}_selected_operations.csv (e.g: refactorings_PhilJay_MPAndroidChart_selected_operations.csv)

2. Run the graph_generate.py file at /process/refactoring-graph-scripts/scripts/python/ as ``` python graph_generate.py ``` or ``` python3 graph_generate.py ```

3.You will presented with 3 options after that: 

-> Select option 1 to Generate the refactoring subgraphs. See the results in dataset/saner-2020/graphs.
-> Select option 2 to Generate views of refactoring subgraphs. See the results in dataset/saner-2020/graphviz.
-> Select option 3 to Generate properties of refactoring subgraphs. See the results in dataset/saner-2020/subgraphs_properties.csv.
    
 #### Research Questions Reproduction
 
Run ResearchQuestionChart.py/ipynb file at /process/refactoring-graph-scripts/scripts/python/ in python or jupyter notebook to generate data charts for the research questions in paper.

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


#### Refactoring Graphs Viewer project:

This was not the part of the paper but we found it as a good tool for visualisation.

This project is for the visual representation of the refactoring Subgraphs generated from 2nd option of Refactoring Graph script programm.

Github: https://github.com/alinebrito/refactoring-graph
Example: https://refactoring-graph.github.io/#/elastic/elasticsearch/713

This is a React Js project, So NodeJS and npm is required.

Before you start the project put the 'subgraph.json' files in data folder (process/refactoring-graph/public/data) of the respective project.

To setup this project run command:
```npm install```

To run this project
```npm start```

### Delta

#### Process Delta:

* The paper didnt really explained the whole process of the algorithm and generation of refactoring graph. The paper just mentioned the tool of RefDiff to get the refactoring type between commits but we had to code up the main class to generate the desired csv as shown above to feed the python scripts.
* The algorithm to make the Refactoring graphs from the data of RefDiff, paper gave just 7 lines of basic graph generation code to just save methods as nodes and refactoring types as edges in graph. We tried to save the related data in edges and fetch later as needed but that created a lot of data mess. After that we contacted the authors of paper for the code and they provided the scripts for graph generation, which are much more complex than paper.
* The data analysis code for the research questions was still wrote by us as that was not the part of authors code.

#### Data Delta:
* Data was avaible easily as it was open source Github repos. 
