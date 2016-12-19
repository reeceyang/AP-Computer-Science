// Reece Yang
//
// This class has a convert method to convert binary numbers to decimal.

public class Binary {

  private String number;

  public Binary(String n) {

    number = n;
  }

  public int convert() {

    int result = 0;
    int i = 0;
    int length = number.length();

    while (i < length) {

      result += Integer.parseInt(number.substring(i, i + 1))
        * Math.pow(2, length - i - 1);
      i++;
    }

    return result;
  }

  public String getNumber() {

	  return number;
  }
}
