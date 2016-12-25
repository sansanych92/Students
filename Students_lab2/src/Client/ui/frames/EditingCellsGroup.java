package Client.ui.frames;

/**
 *@author Arsenii
 */
public class EditingCellsGroup {

    private static volatile int row = -1;
    private static volatile int col = -1;

    public static int getRow() {
        return row;
    }

    public static void setRow(int row) {
        EditingCellsGroup.row = row;
    }

    public static int getCol() {
        return col;
    }

    public static void setCol(int col) {
        EditingCellsGroup.col = col;
    }
}
