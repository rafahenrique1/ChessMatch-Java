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

	@Override
	public String toString() {
		return "K";
	}

	private boolean canMove(Position position) {
		ChessPiece piece = (ChessPiece) getBoard().piece(position);
		return piece == null || piece.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece piece = (ChessPiece)getBoard().piece(position);
		return piece != null && piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
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
		
		// #SpecialMove Castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// #SpecialMove Castling Kingside Rook
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if (testRookCastling(posT1)) {
				Position p1 = new Position(position.getRow(), position.getColumn() + 1);
				Position p2 = new Position(position.getRow(), position.getColumn() + 2);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
			// #SpecialMove Castling Queenside Rook			
			Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
			if (testRookCastling(posT2)) {
				Position p1 = new Position(position.getRow(), position.getColumn() - 1);
				Position p2 = new Position(position.getRow(), position.getColumn() - 2);
				Position p3 = new Position(position.getRow(), position.getColumn() - 3);
				if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					mat[position.getRow()][position.getColumn() - 2] = true;
				}
			}
		}

		return mat;
	}
}
