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
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position pos = new Position(0, 0);

		// Above
		pos.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// Below
		pos.setValues(position.getRow() + 1, position.getColumn());
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// Left
		pos.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// Right
		pos.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// Nw
		pos.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// Ne
		pos.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// Sw
		pos.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		// Se
		pos.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}

		return mat;
	}
}
