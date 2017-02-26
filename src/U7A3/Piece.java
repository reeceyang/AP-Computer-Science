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
	private int type;
	public static final int EMPTY = 0;
	public static final int X = 1;
	public static final int O = 2;

	public Piece(int type)
	{
		this.type = type;
	}

	public int getType()
	{
		return type;
	}

	public String toString()
	{
		return typeToString(type);
	}

	public boolean equals(Object object)
	{
		// Pieces are equal if they have the same type
		Piece piece = (Piece) object;
		return piece.getType() == type;
	}

	public static int stringToType(String string)
	{
		switch(string)
		{
			case "":
				return EMPTY;
			case "X":
				return X;
			case "O":
				return O;
			default:
				return EMPTY;
		}
	}

	public static String typeToString(int type)
	{
		switch(type)
		{
			case 0:
				return "";
			case 1:
				return "X";
			case 2:
				return "O";
			default:
				return "Invalid Type";
		}
	}
}