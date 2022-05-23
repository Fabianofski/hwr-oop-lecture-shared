package hwr.oop.exercises.tictactoe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

class TicTacToeTest {

    @Test
    void newGame_NoTicksYet_AllFieldsAreZero() {
        TicTacToe game = new TicTacToe(3, false);
        int[] squares = new int[9];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                int targetIndex = y * 3 + x;
                squares[targetIndex] = game.getValueAt(x, y, 0);
            }
        }
        assertThat(squares).containsOnly(0);
    }

    @Test
    void setCross_FirstPlayerTicksCentralSquare_CentralSquareTicked() {
        TicTacToe game = new TicTacToe(3, false);
        game.setCross(1, 1, 0);
        int value = game.getValueAt(1, 1, 0);
        assertThat(value).isEqualTo(1);
    }

    @Test
    void setCross_SameSquare_IsNotAllowed() {
        TicTacToe game = new TicTacToe(3, false);
        game.setCross(1, 1, 0);
        game.setCircle(2,2, 0);
        try {
            game.setCross(1, 1, 0);
            fail("no error if (1,1) is ticked twice!");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void setCross_TwiceInARow_IsNotAllowed() {
        TicTacToe game = new TicTacToe(3, false);
        game.setCross(0, 0, 0);
        try {
            game.setCross(0, 1, 0);
            fail("no error, player A ticked twice in a row!");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void setCircle_FirstPlayerToedCentralSquare_CentralSquareToed() {
        TicTacToe game = new TicTacToe(3, false);
        game.setCross(0,0, 0);
        game.setCircle(1, 1, 0);
        int value = game.getValueAt(1, 1, 0);
        assertThat(value).isEqualTo(2);
    }

    @Test
    void setCircle_SameSquare_IsNotAllowed() {
        TicTacToe game = new TicTacToe(3, false);
        game.setCross(0,0, 0);
        game.setCircle(1, 1, 0);
        game.setCross(2,2, 0);
        try {
            game.setCircle(1, 1, 0);
            fail("no error if (1,1) is toed twice!");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void setCircle_TwiceInARow_IsNotAllowed() {
        TicTacToe game = new TicTacToe(3, false);
        game.setCross(2,2, 0);
        game.setCircle(0, 0, 0);
        try {
            game.setCircle(0, 1, 0);
            fail("no error, player B toed twice in a row!");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Test
    void isGameOver_NewGame_GameIsNotOver() {
        TicTacToe game = new TicTacToe(3, false);
        boolean over = game.isGameOver();
        assertThat(over).isFalse();
    }

    @Test
    void isGameOver_FirstPlayerCompletesThree_GameIsOver() {
        // given
        TicTacToe game = new TicTacToe(3, false);
        game.setCross(0, 0, 0);
        game.setCircle(0, 1, 0);
        game.setCross(1, 0, 0);
        game.setCircle(1, 1, 0);
        game.setCross(2, 0, 0);
        // when
        boolean over = game.isGameOver();
        // then
        assertThat(over).isTrue();
    }

    @Test
    void isGameOver_FirstPlayerDoesNotWinAfterThreeTicsNotInARow_GameIsNotOver() {
        // given: a NOT finished Game
        TicTacToe game = new TicTacToe(3, false);
        game.setCross(0, 0, 0);
        game.setCircle(0, 1, 0);
        game.setCross(1, 0, 0);
        game.setCircle(1, 1, 0);
        game.setCross(0, 2, 0);

        // when
        boolean over = game.isGameOver();
        // then
        assertThat(over).isFalse();
    }

    @Test
    void setCross_finishedGame_PlayingAFinishedGameIsNotAllowed() {
        // given: a finished Game
        TicTacToe game = new TicTacToe(3, false);
        game.setCross(0, 0, 0);
        game.setCircle(0, 1, 0);
        game.setCross(1, 0, 0);
        game.setCircle(1, 1, 0);
        game.setCross(2, 0, 0);

        // when
        try {
            game.setCircle(0, 2, 0);
            fail("no error, played on after three in a row");
        } catch (RuntimeException e) {
            // then
            e.printStackTrace();
        }
    }

    @Test
    void checkRows_RowOfCrossIsComplete_RowIsComplete(){
        TicTacToe game = new TicTacToe(3, false);

        game.setCross(0, 0, 0);
        game.setCircle(0, 1, 0);
        game.setCross(1, 0, 0);
        game.setCircle(1, 1, 0);
        game.setCross(2, 0, 0);

        assertThat(game.checkRows()).isTrue();
    }

    @Test
    void checkRows_RowOfCrossIsNotComplete_RowIsNotComplete(){
        TicTacToe game = new TicTacToe(3, false);

        game.setCross(0, 0, 0);
        game.setCircle(0, 1, 0);
        game.setCross(1, 0, 0);
        game.setCircle(1, 1, 0);
        game.setCross(2, 2, 0);

        assertThat(game.checkRows()).isFalse();
    }

    @Test
    void checkColumns_ColumnOfCrossIsComplete_ColumnIsComplete(){
        TicTacToe game = new TicTacToe(3, false);

        game.setCross(0, 0, 0);
        game.setCircle(1, 1, 0);
        game.setCross(0, 1, 0);
        game.setCircle(2, 1, 0);
        game.setCross(0, 2, 0);

        assertThat(game.checkColumns()).isTrue();
    }

    @Test
    void checkColumns_ColumnsOfCrossIsNotComplete_ColumnIsNotComplete(){
        TicTacToe game = new TicTacToe(3, false);

        game.setCross(0, 0, 0);
        game.setCircle(1, 1, 0);
        game.setCross(0, 1, 0);
        game.setCircle(2, 1, 0);
        game.setCross(1, 2, 0);

        assertThat(game.checkColumns()).isFalse();
    }

    @Test
    void checkDiagonal_DiagonalOfCrossIsComplete_DiagonalIsComplete(){
        TicTacToe game = new TicTacToe(3, false);

        game.setCross(0, 0, 0);
        game.setCircle(0, 1, 0);
        game.setCross(1, 1, 0);
        game.setCircle(2, 1, 0);
        game.setCross(2, 2, 0);

        assertThat(game.checkDiagonals()).isTrue();
    }

    @Test
    void checkDiagonal_DiagonalOfCrossIsNotComplete_DiagonalIsNotComplete(){
        TicTacToe game = new TicTacToe(3, false);

        game.setCross(0, 0, 0);
        game.setCircle(1, 1, 0);
        game.setCross(0, 1, 0);
        game.setCircle(2, 1, 0);
        game.setCross(1, 2, 0);

        assertThat(game.checkDiagonals()).isFalse();
    }

}
