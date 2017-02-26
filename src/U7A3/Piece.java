/*//Ben Schroeder
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
*/
package U7A3;

public class Piece
{
	private String type;
	public static final String EMPTY = " ";
	public static final String X = "X";
	public static final String O = "O";

	public Piece(String type)
	{
		this.type = type;
	}

	public String getType()
	{
		return type;
	}
}