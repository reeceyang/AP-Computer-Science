// Reece Yang
//
// This class models a quiz.
// It has methods to get and set the score and grade.

public class Quiz implements Measurable
{
    private int score;
    private String grade;

    public Quiz(int score)
    {
        this.score = score;
        setGrade();
    }

    private void setGrade()
    {
        if (score >= 90)
        {
            grade = "A";
        }
        else if (score >= 80)
        {
            grade = "B";
        }
        else if (score >= 70)
        {
            grade = "C";
        }
        else if (score >= 60)
        {
            grade = "D";
        }
        else
        {
            grade = "F";
        }
    }

    public String getResult()
    {
        return grade;
    }
}
