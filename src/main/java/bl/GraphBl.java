package bl;



import models.Graph;
import models.Node;

import java.util.List;

public class GraphBl {

    public static List getMustLeads(String graphString, String entryString, String nodeString) {
        Graph graph = new GraphParser(graphString).parse();
        Node entryNode = graph.getNodes().stream().filter((node) -> new Node(entryString).equals(node)).findFirst().get();
        Node goalNode = graph.getNodes().stream().filter((node) -> new Node(nodeString).equals(node)).findFirst().get();
        return new MustLeadsHandler(graph,entryNode, goalNode).getMustLeads();

    }





}
