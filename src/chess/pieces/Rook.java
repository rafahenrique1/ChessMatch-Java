package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position pos = new Position(0, 0);

		// Above
		pos.setValue(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;

			pos.setRow(pos.getRow() - 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// Below
		pos.setValue(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;

			pos.setRow(pos.getRow() + 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// Left
		pos.setValue(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;

			pos.setColumn(pos.getColumn() - 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// Right
		pos.setValue(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsAPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;

			pos.setColumn(pos.getColumn() + 1);
		}
		if (getBoard().positionExists(pos) && isThereOpponentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		return mat;
	}
}
