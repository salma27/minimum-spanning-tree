# minimum spanning tree
 
## What is Minimum Spanning Tree?
Assume that we have an undirected connected graph, a minimum spanning tree is an edge
weighted undirected graph that connects all vertices together with the minimum possible
total edge weight, it can’t have any internal cycles or else it won’t be a spanning tree.
The cost (total weight) of the spanning tree is the sum of all edges in the tree. There can be
many spanning trees (that includes every vertex in the graph), but the minimum spanning
tree is the spanning tree with the least cost (total weight), and there can be many minimum
spanning tree for the same graph and all of them will have the same minimum cost.

## Why do we use Minimum Spanning Tree?
As it makes the perfect match to search for an optimal path with the passing through edges
with the least cost.

## How do we design and implement its algorithm?
There are 2 algorithm for the minimum spanning tree which are:
9. Kruskal’s Algorithm.
10. Prim’s Algorithm.
11. Boruvka’s Algorithm.

## Steps for Kruskal’s Algorithm:
12. Sort the graph edges by their weight in an ascending order.
13. Choose the smallest edge and add its weight to the total cost.
14. Draw the 2 vertices and the edge between them then go to the next point.
15. Repeat the algorithm until the tree covers all the vertices.

## When and where to use it?
It’s used when having many paths to pass through as it gets the optimal path (multiterminal minimum cut), and in algorithms including minimum cost.
The input and output to use the algorithm:
The Input should be a graph with number of vertices and edges connecting them, the
graph’s edges are not directed, is the input is an undirected graph.
The output is a minimum spanning tree, a tree with the least cost.(if the graph had many
minimum spanning trees, it will draw only one of them).

## Time Complexity for the algorithm:
O (E log V): such that E is total number of edges, and V is the total number of vertices.
(What consumes the time the most is the sorting operation for the edges every time).

## Conclusion:
Due to the numerous applications of minimum spanning trees to communications and
transportation networks, it is important to have efficient algorithms to find minimum
spanning trees in weighted, connected graphs.

## Steps to Execute:

### Important: Each Time You Enter An Edge Press The Button Next To It.
Make Sure That You Pressed The Vertices Button After Entering The Vertices Once
Before Entering The Edges.

1. enter all the names of the vertices(nodes) separated by a space.
2. press the button next to it to add the vertices.
3. enter the weight of the edge then the start of it then the end respectively in the 3 text boxes next to each other.
4. press on the button next to them to enter each edge.
5. repeat step 3,4 for each edge.
6. after entering all the edges and pressing their button, press on the output button to get the output.

![Untitled](https://user-images.githubusercontent.com/36279740/144145885-216e7d78-4a1b-4c36-b784-7a503c0e392b.png)
