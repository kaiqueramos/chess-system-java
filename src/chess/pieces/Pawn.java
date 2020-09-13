package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    public Pawn(Board board, Color color) {
        super(board, color);
    }


    @Override
    public boolean[][] possibleMoves() {

        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);


        //Cima
        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { //Posição existe e não tem peças amigas a frente
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(p.getRow() - 1, p.getColumn());
            if (
                    getBoard().positionExists(p) //Posição existe
                            && !getBoard().thereIsAPiece(p) //Não tem peças amigas a frente
                            && getMoveCount() == 0 //Contador 0
                            && getBoard().positionExists(p2) //Posição existe
                            && !getBoard().thereIsAPiece(p2) //Não tem peças amigas a frente
            ) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(p.getRow() - 1, p.getColumn()); //Possible error here??
            if (
                getBoard().positionExists(p)
                && !getBoard().thereIsAPiece(p)
                && getMoveCount() == 0
                && getBoard().positionExists(p2)
                && !getBoard().thereIsAPiece(p2)
            ) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        return mat;
    }
    @Override
    public String toString () {
        return "P";
    }
}
