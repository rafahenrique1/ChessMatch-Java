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
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position pos = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			pos.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
			pos.setValues(position.getRow() - 2, position.getColumn());
			Position pos2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos) && getBoard().positionExists(pos2)
					&& !getBoard().thereIsAPiece(pos2) && getMoveCount() == 0) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
			pos.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
			pos.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
		} else {
			pos.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
			pos.setValues(position.getRow() + 2, position.getColumn());
			Position pos2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos) && getBoard().positionExists(pos2)
					&& !getBoard().thereIsAPiece(pos2) && getMoveCount() == 0) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
			pos.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
			pos.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
				mat[pos.getRow()][pos.getColumn()] = true;
			}
		}

		return mat;
	}

}
