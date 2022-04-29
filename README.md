# Chandy-Misra-Haas-Algorithm AND Model
Implementation of Chandy-Misra-Haas AND Model Algorithm for Deadlock Detection
using AND model in a Distributed Computing System.
######
###Development Design Specs:
Programming Language:  JAVA  
Development Environment:  javac 18.0.1, Java version 18.0.1  
Windows OS: Win10
### **_How to compile_**:  
Open command prompt and cd to the location the zip file is unzipped and located:
##### Enter>>  javac ChandyMisraHaas.java

### **_How to Run_**:

Now run this compiled code:
##### Enter >>  java ChandyMisraHaas

## **_Assumptions_**:
######
1: Process is declared as deadlocked only if probe message 
returns to its initiator i.e. i =k in probe(i,j,k)
######
2: If the Initiator process do not receive back the probe and even if a cycle is detected, 
still the process is not considered at deadlocked but locked as per Chandy-Misra-Haas AND Model.
######
3: The Program is written considering 7 processes in the Algorithm, any changes to 
total number of processes will hinder the program execution and output.
######
4: To Make your own wait for graph file changes, graph.txt can be modified (0 or 1).

### **Screenshot of Outputs**:
Check output screenshot in the filename attached in zipfile: Output_Screenshots.docx
