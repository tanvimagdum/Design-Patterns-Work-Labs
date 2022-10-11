import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractChessPieceTest {
  protected boolean[][] results;

  @Before
  public void setup() {
    results = new boolean[8][8];
  }

  protected void verifyMoveResults(ChessPiece piece) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((i == piece.getRow()) && (j == piece.getColumn())) {
          continue;
        }

        assertEquals("Piece at :" + piece.getRow() + "," + piece.getColumn() +
                        ", Unexpected canMove result "
                        + "for "
                        + "i=" + i + " j=" +
                        j + "",
                results[i][j], piece.canMove(i, j));

      }
    }
  }

  protected void verifyKillResults(ChessPiece piece) {

    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {

        if ((i == piece.getRow()) && (j == piece.getColumn())) {
          continue;
        }
        ChessPiece another = new (i, j,
                Color.values()[(piece.getColor().ordinal() + 1)
                        % Color.values().length]);


        assertEquals("Unexpected canKill result for "
                        + "i=" + i + " j="
                        + j + "",
                results[i][j], piece.canKill(another));

      }
    }
  }






}