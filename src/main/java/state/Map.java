package state;

public class Map {

    private final int[][] matrix;

    public Map(int maxX, int maxY) {
        this.matrix = new int[maxX + 1][maxY + 1];
    }

    public boolean isOnTheMap(Position position) {
        try {
            int value = this.matrix[position.getX()][position.getY()];
            return true;
        } catch (ArrayIndexOutOfBoundsException ignored) {
            return false;
        }
    }
}
