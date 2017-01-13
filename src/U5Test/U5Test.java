package U5Test;

/**
 * Created by reyan21 on 1/12/2017.
 */
public class U5Test
{
    public static void main(String[] args)
    {
        String[] names = {"Iowa City", "Ames", "Waterloo", "Ottumwa", "Burlington"};
        int[][] chart = {{0, 121, 81, 83, 82},
                         {121, 0, 96, 116, 190},
                         {81, 96, 0, 117, 154},
                         {83, 116, 117, 0, 77},
                         {82, 190, 154, 77, 0}};
        DistanceChart distanceChart = new DistanceChart(chart, names);
        String[] itinerary = distanceChart.makeItinerary();
        System.out.println("The Itinerary");
        System.out.println("-------------");
        for (int i = 0; i < 5; i++)
        {
            System.out.println(itinerary[i]);
        }
    }
}
