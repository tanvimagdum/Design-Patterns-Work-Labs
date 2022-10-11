/**
 * A Bishop class which inherits from AbstractChessPiece class.
 * This class defines the move method for Bishop.
 */
public class Bishop extends AbstractChessPiece {

  /**
   * Construct a Bishop object that takes
   * current row, column and color of the chess piece.
   * This derived class constructor calls the base class constructor.
   * @param row current row of chess piece
   * @param col current column of chess piece
   * @param color color of the chess piece
   * @throws IllegalArgumentException if the current position is invalid
   */
  public Bishop(int row, int col, Color color) throws IllegalArgumentException {
    super(row,col,color);
  }

  @Override
  public boolean canMove(int row, int col) {
    if ((row < 0) || (col < 0) || (row >= 8) || (col >= 8)) {
      return false;
    }
    return (Math.abs(super.row - row) == Math.abs(super.col - col));
  }


}
