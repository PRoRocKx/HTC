public class GraphMain {

    public static void main(String... args){
        Graph graph = new Graph();
        graph.readFromFile("Graph/graph.txt");
        graph.breadthFirstSearch();
    }
}
