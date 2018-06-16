import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    int[][] matrix;
    int count;
    Vertex[] vertices;

    private void parse(String line){
        if (line.contains("count=")){
            try {
                count = Integer.parseInt(line.substring(6));
            }catch (NumberFormatException e){
                System.out.println("read error in line: " + line +'\n'+ e.getLocalizedMessage());
            }
            matrix = new int[count][count];
            vertices = new Vertex[count];
        }else {
            String[] strings = line.split(";");
            int num = Integer.parseInt(strings[0]);
            vertices[num] = new Vertex(num);
            if (strings.length > 2){
                for (int i = 1; i <= Integer.parseInt(strings[1]); i++) {
                    matrix[num][Integer.parseInt(strings[1+i])] = 1;
                }
            }
        }
    }

    public void readFromFile(String fileName){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
                parse(line);
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public void depthFirstSearch(){
        Stack<Vertex> stack = new Stack<>();
        boolean[] checked = new boolean[count];
        System.out.println("Обход в глубину");
        if (vertices == null || vertices.length == 0){
            System.out.println("Граф не задан");
        }
        stack.push(vertices[0]);
        while (!stack.empty()){
            boolean find = false;
            int vertex = stack.peek().num;
            for(int i = 0; i < count; i++) {
                if (matrix[vertex][i] == 1 && !checked[i]) {
                    System.out.println(vertex + " - " + vertices[i].num);
                    checked[i] = true;
                    stack.push(vertices[i]);
                    find = true;
                    break;
                }
            }
            if (!find)
                stack.pop();
        }
    }
    public void breadthFirstSearch(){
        LinkedList<Vertex> queue = new LinkedList<>();
        boolean[] checked = new boolean[count];
        System.out.println("Обход в глубину");
        if (vertices == null || vertices.length == 0){
            System.out.println("Граф не задан");
        }
        queue.add(vertices[0]);
        while (!queue.isEmpty()){
            int vertex = queue.poll().num;
            for(int i = 0; i < count; i++) {
                if (matrix[vertex][i] == 1 && !checked[i]) {
                    System.out.println(vertex + " - " + vertices[i].num);
                    checked[i] = true;
                    queue.add(vertices[i]);
                }
            }
        }
    }

}
