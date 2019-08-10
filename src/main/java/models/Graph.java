package models;

import java.util.*;

public class Graph {

    private Map<Node, List<Node>> graph;
    private Map<String ,Node> nodes;

    public Graph(){
        this.graph = new HashMap<>();
        this.nodes = new HashMap<>();
    }

    public Set<Node> getNodes(){
        return this.graph.keySet();
    }


    public void addNeighbor(String nodeFromName, String nodeToName){
        this.graph.get(new Node(nodeFromName)).add(nodes.get(nodeToName));
    }

    public List<Node> getNeighbors(Node node){
        return this.graph.get(node);
    }

    public void addNodeIfNotExist(String name){
        if(!isNodeExist(name)) {
            Node newNode = new Node(name);
            this.graph.put(newNode, new LinkedList<>());
            this.nodes.put(newNode.getName(),newNode);
        }
    }

    public boolean isNodeExist(String name){
        return this.nodes.get(name) != null;
    }

    public String toString(){
        return this.graph.toString();
    }
}
