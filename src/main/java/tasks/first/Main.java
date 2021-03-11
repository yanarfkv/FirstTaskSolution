package tasks.first;

public class Main {

    public static void main(String[] args) {

    }

    public boolean[][] adjacencyMatrix (String[][] stringAdjacencyMatrix, int verticesNum) {
        boolean[][] adjacencyMatrix = new boolean[verticesNum][verticesNum];
        for (int i = 0; i < stringAdjacencyMatrix.length; i++) {
            for (int j = 0; j < stringAdjacencyMatrix.length; j++) {
                if (stringAdjacencyMatrix[i][j].equals("0")) {
                    adjacencyMatrix[i][j] = false;
                }
                if (stringAdjacencyMatrix[i][j].equals("1")) {
                    adjacencyMatrix[i][j] = true;
                }
            }
        }
        return adjacencyMatrix;
    }

    boolean isNumber(String string) {
        try {
            Long.parseLong(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
