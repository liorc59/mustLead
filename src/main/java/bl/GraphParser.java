package bl;

import models.Graph;

public class GraphParser {
    private String graphString;

    public GraphParser(String graphString){
        this.graphString = graphString;
    }

    public Graph parse(){
        Graph graph = new Graph();
        graphString = graphString.replace("{","");
        graphString = graphString.replace("}","");
        while(!(graphString = graphString.substring( graphString.indexOf("\n")+1)).isEmpty()){
            String line = graphString.substring(0, graphString.indexOf("\n"));
            updateGraphFromLine(line,graph);
        }
        return graph;
    }

    private void updateGraphFromLine(String line, Graph graph){
        String nodeFrom = line.substring(0 , line.indexOf("->"));
        String nodeTo = line.substring(line.indexOf("->")+2 , line.length());
        graph.addNodeIfNotExist(nodeFrom);
        graph.addNodeIfNotExist(nodeTo);
        graph.addNeighbor(nodeFrom, nodeTo);
    }




}
