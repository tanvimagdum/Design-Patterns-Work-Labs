/**
 * An abstract AbstractChessPiece class which implements
 * ChessPiece interface.
 * It is a base class from which various chess pieces will
 * inherit the methods.
 */

public abstract class AbstractChessPiece implements ChessPiece {

  /**
   * Variables are declared as protected since
   * only child classes must be able to access these variables.
   * @param row the row of the chess piece
   * @param col the column of the chess piece
   * @param color the color of the chess piece
   */

  protected int row;
  protected int col;
  protected Color color;

  /**
   * A constructor which can be called only through the derived class
   * while instantiating the derived class object.
   * @param row current row of the chess piece
   * @param col current column of the chess piece
   * @param color current color of the chess piece
   * @throws IllegalArgumentException if the current position is invalid
   */

  public AbstractChessPiece(int row, int col, Color color) throws IllegalArgumentException {
    if ((row < 0) || (col < 0)) {
      throw new IllegalArgumentException("Illegal position");
    }
    this.row = row;
    this.col = col;
    this.color = color;
  }


  @Override
  public int getRow() {
    return row;
  }

  @Override
  public int getColumn() {
    return col;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public boolean canMove(int row, int col) {
    return false;
  }


  @Override
  public boolean canKill(ChessPiece piece) {
    return (this.getColor() != piece.getColor())
            && canMove(piece.getRow(),
            piece.getColumn());
  }


}
