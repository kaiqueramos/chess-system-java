package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        if (getBoard().positionExists(position)) {
            ChessPiece p = (ChessPiece) getBoard().piece(position);
            return p == null || getColor() != p.getColor();
        }
        return false;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        //Cima
        p.setValues(this.position.getRow() - 1, this.position.getColumn());
        if(this.canMove(p) && getBoard().positionExists(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //Baixo
        p.setValues(this.position.getRow() + 1, this.position.getColumn());
        if(this.canMove(p) && getBoard().positionExists(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //Direita
        p.setValues(this.position.getRow(), this.position.getColumn() + 1);
        if(this.canMove(p) && getBoard().positionExists(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //Esquerda
        p.setValues(this.position.getRow(), this.position.getColumn() - 1);
        if(this.canMove(p) && getBoard().positionExists(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //Cima + Direita
        p.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        if(this.canMove(p) && getBoard().positionExists(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //Cima + Esquerda
        p.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        if(this.canMove(p) && getBoard().positionExists(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //Baixo + Direita
        p.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        if(this.canMove(p) && getBoard().positionExists(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        //Baixo + Esquerda
        p.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        if(this.canMove(p) && getBoard().positionExists(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }
}
