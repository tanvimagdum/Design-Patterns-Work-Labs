import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * A Junit test class to test how Knight moves.
 */
public class KnightTest extends AbstractChessPieceTest {


  protected void verifyKillResults(ChessPiece piece) {

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((i == piece.getRow()) && (j == piece.getColumn())) {
          continue;
        }
        ChessPiece another = new Knight(i, j,
                Color.values()[(piece.getColor().ordinal() + 1)
                        % Color.values().length]);


        assertEquals("Unexpected canKill result for "
                        + "i=" + i + " j="
                        + j + "",
                results[i][j], piece.canKill(another));

      }
    }
  }


  @Test(timeout = 500)
  public void testGetters() {
    ChessPiece piece;
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        for (Color c : Color.values()) {
          piece = new Knight(row, col, c);
          assertEquals("Row number does not match what was initialized", row,
                  piece.getRow());
          assertEquals("Column number does not match what was initialized",
                  col, piece.getColumn());
          assertEquals("solution.Color does not match what was initialized",
                  c, piece.getColor());
        }
      }
    }
  }

  @Test(timeout = 500)
  public void testInvalidConstructions() {
    ChessPiece piece;
    for (Color c : Color.values()) {
      for (int i = 0; i < 8; i++) {
        try {
          piece = new Knight(i, -1, c);
          fail("Did not throw an exception when rook is created with invalid "
                  + "row");
        } catch (IllegalArgumentException e) {
                    //passes
        }

        try {
          piece = new Knight(-1, i, c);
          fail("Did not throw an exception when rook is created with invalid "
                  + "column");
        } catch (IllegalArgumentException e) {
                    //passes
        }

      }
    }
  }


  @Test(timeout = 500)
  public void testKnightMoves() {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        initializeResults();
        ChessPiece piece = new Knight(row, col, Color.BLACK);
        setupResults(row, col);
        verifyMoveResults(piece);
      }
    }
  }

  @Test(timeout = 500)
  public void testKnightKills() {
    for (Color c : Color.values()) {
      for (int row = 0; row < 8; row++) {
        for (int col = 0; col < 8; col++) {
          initializeResults();
          ChessPiece piece = new Knight(row, col, c);
          setupResults(row, col);
          verifyKillResults(piece);
        }
      }
    }
  }


  private void initializeResults() {
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        results[row][col] = false;
      }
    }
  }

  private void setupResults(int row, int col) {
    //check if canMove works
    if (row <= 5) {
      if (col <= 6) {
        results[row + 2][col + 1] = true;
      }
      if (col > 0) {
        results[row + 2][col - 1] = true;
      }
    }
    if (row > 1) {
      if (col <= 6) {
        results[row - 2][col + 1] = true;
      }
      if (col > 0) {
        results[row - 2][col - 1] = true;
      }
    }

    if (row <= 6) {
      if (col <= 5) {
        results[row + 1][col + 2] = true;
      }
      if (col > 1) {
        results[row + 1][col - 2] = true;
      }
    }
    if (row > 0) {
      if (col <= 5) {
        results[row - 1][col + 2] = true;
      }
      if (col > 1) {
        results[row - 1][col - 2] = true;
      }
    }
  }

}