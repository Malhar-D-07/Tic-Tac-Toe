package Models;
import Exceptions.InvalidBotCountException;

import java.util.*;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Cell> moves;
    private GameStatus gameStatus;
    private int nextPlayerTurn;
    private Player winner;
    List<WinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<WinningStrategy> strategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.winningStrategies = strategies;
        this.moves = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.nextPlayerTurn = 0;
        this.winner = null;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Cell> getMoves() {
        return moves;
    }

    public void setMoves(List<Cell> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getNextPlayerTurn() {
        return nextPlayerTurn;
    }

    public void setNextPlayerTurn(int nextPlayerTurn) {
        this.nextPlayerTurn = nextPlayerTurn;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public static GameBuilder getBuilderInstance() {
        return new GameBuilder();
    }

    public static class GameBuilder {
        int dim;
        private List<Player> players;
        List<WinningStrategy> winningStrategies;

        public int getDim() {
            return dim;
        }

        public GameBuilder setDim(int dim) {
            this.dim = dim;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public List<WinningStrategy> getWinningStrategies() {
            return winningStrategies;
        }

        public GameBuilder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public void validate() throws InvalidBotCountException {
            int botCount = 0;
            for (Player p: players) {
                if(p.getType().equals(PlayerType.BOT)) {
                    botCount += 1;
                }
            }
            if(botCount > 1) {
                throw new InvalidBotCountException();
            }

            if(players.size() > dim - 1) {
                throw new RuntimeException();
            }
        }

        public Game build() throws InvalidBotCountException {
            validate();
            return new Game(this.dim, this.players, this.winningStrategies);
        }
    }
}
