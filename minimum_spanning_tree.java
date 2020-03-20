import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class minimum_spanning_tree {
	
	public static Vector<Vertix> vertices = new Vector<Vertix>();
	public static Vector<Edge> edges = new Vector<Edge>();
	public static Vector<Edge> result = new Vector<Edge>();
	
	public static void main(String[] args) {
		System.out.print("Please enter the number of vertices :");
		Scanner sc = new Scanner(System.in);
		int ver = sc.nextInt();
		
		for(int i = 0; i < ver; i++) {
			System.out.print("Vertix " + i + " : ");
			Vertix vertix = new Vertix(sc.next());
			vertices.add(vertix);
		}
		//System.out.println();
		System.out.print("Please enter the number of edges : ");
		int edg = sc.nextInt();
		for(int i = 0 ; i < edg; i++) {
			Edge edge = new Edge();
			System.out.print("Edge " + i + "'s value = ");
			edge.value = sc.nextInt();
			System.out.print("Edge " + i + "'s starting point : ");
			edge.start = new Vertix(sc.next());
			System.out.print("Edge " + i + "'s ending point : ");
			edge.end = new Vertix(sc.next());
		}
		minSpanTree();
		for(int i = 0 ; i < result.size() ; i++) {
			System.out.println("Edge's value : " + result.elementAt(i).value);
			System.out.println("Edge's start : " + result.elementAt(i).start.name);
			System.out.println("Edge's end : " + result.elementAt(i).end.name);
		}
	}
	
	public static void minSpanTree() {
		edges.sort(Comparator.comparing(Edge::getValue));
		for(int i = 0 ; i < edges.size() ; i++) {
			if(edges.elementAt(i).start.pass && edges.elementAt(i).end.pass)
				continue;
			edges.elementAt(i).start.pass = true;
			edges.elementAt(i).end.pass = true;
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
