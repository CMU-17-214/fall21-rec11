package edu.cmu.cs.cs214.rec10.plugin;

import edu.cmu.cs.cs214.rec10.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec10.framework.core.GamePlugin;
import edu.cmu.cs.cs214.rec10.games.TicTacToe;

public class TicTacToePlugin implements GamePlugin<TicTacToe.Player>  {
    private static final String GAME_NAME = "Tic Tac Toe";


    private static final String PLAYER_WON_MSG = "You won!";
    private static final String COMPUTER_WON_MSG = "The computer won!";
    private static final String GAME_TIED_MSG = "The game ended in a tie.";

    private static final String GAME_START_FOOTER = "You are playing Tic Tac Toe with a computer!";

    private GameFramework framework;
    private TicTacToe game;

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    @Override
    public int getGridWidth() {
        return TicTacToe.SIZE;
    }

    @Override
    public int getGridHeight() {
        return TicTacToe.SIZE;
    }

    @Override
    public void onRegister(GameFramework framework) {
        framework = framework;
    }

    @Override
    public void onNewGame() {
        framework.setFooterText(GAME_START_FOOTER);
        game = new TicTacToe();
    }

    @Override
    public void onNewMove() {
        // Nothing to do
        // Clear up the state
    }

    @Override
    public boolean isMoveValid(int x, int y) {
        return game.isValidPlay(x, y);
    }

    @Override
    public boolean isMoveOver() {
        return true;
    }

    @Override
    public void onMovePlayed(int x, int y) {
        framework.setSquare(x, y, game.currentPlayer().toString());
        game.play(x, y);
    }

    @Override
    public boolean isGameOver() {
        return game.isOver();
    }

    @Override
    public String getGameOverMessage() {
        TicTacToe.Player possibleWinner = game.winner();
        if (possibleWinner == null) return "game ended in a tie";
        return String.format("%s", possibleWinner);
    }

    @Override
    public void onGameClosed() {

    }

    @Override
    public TicTacToe.Player currentPlayer() {
        return game.currentPlayer();
    }
}
