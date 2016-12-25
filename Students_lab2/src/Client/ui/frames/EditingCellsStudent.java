package Client.ui.frames;

/**
 *@author Arsenii
 */
public class EditingCellsStudent {

    private static volatile int row = -1;
    private static volatile int col = -1;

    public static int getRow() {
        return row;
    }

    public static void setRow(int row) {
        EditingCellsStudent.row = row;
    }

    public static int getCol() {
        return col;
    }

    public static void setCol(int col) {
        EditingCellsStudent.col = col;
    }
}
