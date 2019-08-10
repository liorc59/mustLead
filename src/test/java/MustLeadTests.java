import bl.GraphBl;
import controllers.RequestHandler;
import models.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class MustLeadTests {


    @Test
    public void testMustLeadExample(){
        String graph = "{\n1->2\n2->3\n3->5\n2->5\n5->2\n}";
        List<Node> result = GraphBl.getMustLeads(graph,"1","5");
        List<Node> expected = new LinkedList<>();
        expected.add(new Node("1"));
        expected.add(new Node("2"));
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void testMustLeadWithSplitsPaths(){
        String graph = "{\n1->2\n2->3\n2->5\n5->6\n3->6\n6->7\n}";
        List<Node> result = GraphBl.getMustLeads(graph,"1","7");
        List<Node> expected = new LinkedList<>();
        expected.add(new Node("1"));
        expected.add(new Node("2"));
        expected.add(new Node("6"));
        Assert.assertTrue(result.equals(expected));
    }

    @Test
    public void testMustLeadWithLoop(){
        String graph = "{\n1->2\n2->3\n2->5\n5->6\n3->6\n6->7\n6->2\n}";
        List<Node> result = GraphBl.getMustLeads(graph,"1","7");
        List<Node> expected = new LinkedList<>();
        expected.add(new Node("1"));
        expected.add(new Node("2"));
        expected.add(new Node("6"));
        Assert.assertTrue(result.equals(expected));
    }

}
