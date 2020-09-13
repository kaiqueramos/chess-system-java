package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    private boolean testRookCastling(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null & p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
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
        //Special move castling
        if(getMoveCount() == 0 && !chessMatch.getCheck()){
            //Castling kingside-rook
            Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
            if(testRookCastling(posT1)){
                Position p1 = new Position(position.getRow(), position.getColumn() + 1);
                Position p2 = new Position(position.getRow(), position.getColumn() + 2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    mat[position.getRow()][position.getColumn() + 2] = true;
                }
            }
            //Castling queenside-rook
            Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
            if(testRookCastling(posT1)){
                Position p1 = new Position(position.getRow(), position.getColumn() - 1);
                Position p2 = new Position(position.getRow(), position.getColumn() - 2);
                Position p3 = new Position(position.getRow(), position.getColumn() - 3);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    mat[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }
        return mat;
    }
}
