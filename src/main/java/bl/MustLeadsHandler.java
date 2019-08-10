package bl;

import javafx.util.Pair;
import models.Graph;
import models.Node;

import java.util.*;
import java.util.stream.Collectors;

public class MustLeadsHandler {
    private Graph graph;
    private Node entry;
    private Node goal;

    public MustLeadsHandler(Graph graph, Node entry, Node goal){
        this.graph = graph;
        this.entry = entry;
        this.goal = goal;
    }



    public List<Node> getMustLeads(){
       List<Node> localPath = new ArrayList<>();
       Map<Node,Integer> pathNodeCounter = new HashMap<>();
       getNodePaths(entry, localPath, pathNodeCounter);
       int numberOfPaths = pathNodeCounter.get(entry);
       return pathNodeCounter.keySet().stream().filter((node -> pathNodeCounter.get(node) == numberOfPaths)).collect(Collectors.toList());

    }



    //update pathNodeCounter to contain the number of paths the node participates
    private void getNodePaths(Node entry, List<Node> localPath, Map<Node,Integer> pathNodeCounter) {
        if(entry.equals(goal)) {
            localPath.forEach((node -> {
                if(pathNodeCounter.containsKey(node)){
                    pathNodeCounter.put(node,pathNodeCounter.get(node)+1);
                }
                else{
                    pathNodeCounter.put(node,1);
                }

            }));
            return;
        }
        if(entry.getIsTraversed()) {
            return;
        }


        entry.setIsTraversed(true);
        localPath.add(entry);
        for (Node node : graph.getNeighbors(entry)) {
            getNodePaths(node,localPath,pathNodeCounter);
        }
        localPath.remove(entry);
        entry.setIsTraversed(false);

    }
}
