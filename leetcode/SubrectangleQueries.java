public class SubrectangleQueries {
    private int[][] map;

    public SubrectangleQueries(int[][] rectangle) {
        map = rectangle;
    }
    
    /**
     * Updates all values with newValue in the subrectangle.
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @param newValue
     */
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        int startRow, endRow, startCol, endCol = 0;
        // determine the horizontal distance
        if (col1 == col2) {
            // no horizontal area, only traversing vertically
            startCol = col1;
            endCol = col2;
        } else {
            // there is horizontal area, find the leftmost col
            startCol = Math.min(col1, col2);
            if (col1 == startCol) {
                endCol = col2;
            } else {
                endCol = col1;
            }
        }

        // determine the vertical distance
        if (row1 == row2) {
            // no vert area, only horizontal traversal
            startRow = row1;
            endRow = row2;
        } else {
            // there is vertical area, find the topmost row
            startRow = Math.min(row1, row2);
            if (row1 == startRow) {
                endRow = row2;
            } else {
                endRow = row1;
            }
        }

        // double nested for loop for traversing & updating subrectangle
        for (int j=startRow; j<=endRow; j++) {
            for (int k=startCol; k<=endCol; k++) {
                map[j][k] = newValue;
            }
        }

    }
    
    /**
     * Returns the current value of the coordinate (row,col) from the rectangle.
     * @param row
     * @param col
     * @return
     */
    public int getValue(int row, int col) {
        return map[row][col];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<map.length; j++) {
            sb.append("\n");
            for (int k=0; k<map[j].length; k++) {
                // col
                sb.append(map[j][k]);
                sb.append("\t");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("\nBEGIN...");

        int row = 1;
        int col = 1;
        int[][] rect = {{1,2,3}, {4,5,6}, {7,8,9}};

        SubrectangleQueries sq = new SubrectangleQueries(rect);
        System.out.println(sq.toString());

        int answer = sq.getValue(row, col);
        System.out.println("Value at row" + row + " col" + col + " is: " + answer);

        sq.updateSubrectangle(0, 0, 2, 1, 0);
        System.out.println(sq.toString());

        answer = sq.getValue(row, col);
        System.out.println("Value at row" + row + " col" + col + " is: " + answer);

        System.out.println("\n...END");
    }
}
