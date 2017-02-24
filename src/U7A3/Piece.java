//Ben Schroeder
//
//Piece Class

package U7A3;

public class Piece
{
	private String pieceType;

	public Piece(String player)
	{
		if(player.equals("p1"))
			pieceType = "X";
		else if(player.equals("p2"))
			pieceType = "O";
	}

	public String getPiece()
	{
		return pieceType;
	}
}