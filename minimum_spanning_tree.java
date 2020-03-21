import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.samples.SimpleGraphDraw;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;
import org.apache.commons.collections15.Transformer;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class minimum_spanning_tree {

    public static Vector<Vertix> vertices = new Vector<Vertix>();
    public static Vector<Edge> edges = new Vector<Edge>();
    public static Vector<Edge> result = new Vector<Edge>();
    public static Graph<String, Integer> graph = new SparseMultigraph<String, Integer>();
    public static Layout<String, Integer> layout = new CircleLayout<>(graph);



    public static void main(String[] args) {
        System.out.print("Please enter the number of vertices :");
        Scanner sc = new Scanner(System.in);
        int ver = sc.nextInt();

        for(int i = 0; i < ver; i++) {
            System.out.print("Vertix " + (i + 1) + " : ");
            Vertix vertix = new Vertix(sc.next());
            vertices.add(vertix);
        }
        //System.out.println();
        System.out.print("Please enter the number of edges : ");
        int edg = sc.nextInt();
        for(int i = 0 ; i < edg; i++) {
            Edge edge = new Edge();
            System.out.print("Edge " + (i + 1) + "'s value = ");
            edge.value = sc.nextInt();
            System.out.print("Edge " + (i + 1) + "'s starting point : ");
            //edge.start = new Vertix(sc.next());
            edge.start = getVertix(sc.next());
            System.out.print("Edge " + (i + 1) + "'s ending point : ");
            edge.end = getVertix(sc.next());
            edges.add(edge);
        }
        minSpanTree();
        System.out.println(">>>>>>>===========================================<<<<<<<");
        System.out.println("Number of Edges in the minimum spanning tree " + result.size() + ", Which are : ");
        for(int i = 0 ; i < result.size() ; i++) {
            System.out.print("Edge's value : " + result.elementAt(i).value);
            System.out.print(" between " + result.elementAt(i).start.name);
            System.out.println(" and " + result.elementAt(i).end.name);
        }

        for(int i = 0 ; i < vertices.size(); i++){
            graph.addVertex(vertices.elementAt(i).name);
        }
        for(int i = 0 ; i < result.size(); i++){
            graph.addEdge(result.elementAt(i).value, result.elementAt(i).start.name, result.elementAt(i).end.name);
        }
        layout.setSize(new Dimension(300, 300));
        BasicVisualizationServer<String, Integer> vv = new BasicVisualizationServer<String, Integer>(layout);
        vv.setPreferredSize(new Dimension(350, 350));
        Transformer<String, Paint> vertexPaint = new Transformer<String, Paint>() {
            @Override
            public Paint transform(String s) {
                return Color.CYAN;
            }
        };
        float dash[] = {1.0f};
        final Stroke edgeStroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
        Transformer<Integer, Stroke> edgeStrokeTransformer = new Transformer<Integer, Stroke>(){
            public Stroke transform(Integer s){
                return edgeStroke;
            }
        };
        vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
        vv.getRenderContext().setEdgeStrokeTransformer(edgeStrokeTransformer);
        vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
        vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
        vv.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);



        JFrame frame = new JFrame("Minimum Spanning Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);


        //System.out.println("graph: " +  graph);

    }
    public static Vertix getVertix(String name) {
        for(int i = 0 ; i < vertices.size(); i++) {
            if(vertices.elementAt(i).name.equals(name))
                return vertices.elementAt(i);
        }
        return null;
    }
    public static void minSpanTree() {
        edges.sort(Comparator.comparing(Edge::getValue));
        for(int i = 0 ; i < edges.size() ; i++) {
            if(vertices.elementAt(vertices.indexOf(edges.elementAt(i).start)).pass
                    && vertices.elementAt(vertices.indexOf(edges.elementAt(i).end)).pass)
                continue;
            vertices.elementAt(vertices.indexOf(edges.elementAt(i).start)).pass = true;
            vertices.elementAt(vertices.indexOf(edges.elementAt(i).end)).pass = true;
            result.add(edges.elementAt(i));
        }

    }

}
class Edge{
    int value;
    Vertix start;
    Vertix end;
    Edge(){
        value = 0;
        start = new Vertix("");
        end = new Vertix("");
    }
    Edge(Vertix start, Vertix end){
        this.start = start;
        this.end = start;
        this.value = 0;
    }
    Edge(int value, Vertix start, Vertix end){
        this.start = start;
        this.end = start;
        this.value = value;
    }
    int getValue() {
        return this.value;
    }
}
class Vertix{
    String name;
    boolean pass;
    Vertix(){
        name = "";
        pass = false;
    }
    Vertix(String name){
        this.name =  name;
        pass = false;
    }
    Vertix(String name, boolean pass){
        this.name =  name;
        this.pass = pass;
    }
}
