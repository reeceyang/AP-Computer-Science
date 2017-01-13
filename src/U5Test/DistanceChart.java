package U5Test;

/**
 * Created by reyan21 on 1/12/2017.
 */
public class DistanceChart
{
    private String[] cityNames;
    private int[][] distances;

    public DistanceChart(int[][] d, String[] cn)
    {
        distances = d;
        cityNames = cn;
    }

    public int findRemoteCity()
    {
        int length = distances.length;
        int maxSum = 0;
        int maxIndex = 0;
        for (int i = 0; i < length; i++)
        {
            int sum = 0;
            for (int j = 0; j < length; j++)
            {
                sum += distances[i][j];
            }
            if (sum > maxSum)
            {
                maxSum = sum;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int findNearestCity(int currentCity)
    {
        int length = distances.length;
        int nearestCity = 0;
        int leastDistance = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++)
        {
            if (distances[currentCity][i] < leastDistance && i != currentCity)
            {
                nearestCity = i;
                leastDistance = distances[currentCity][i];
                distances[currentCity][i] = Integer.MAX_VALUE;
            }
        }
        return nearestCity;
    }

    public String[] makeItinerary()
    {
        int length = cityNames.length;
        String[] itinerary = new String[length];
        int currentCity = findRemoteCity();
        itinerary[0] = cityNames[currentCity];
        for (int i = 1; i < length; i++)
        {
            System.out.println(findNearestCity(currentCity));
            currentCity = findNearestCity(currentCity);
            itinerary[i] = cityNames[currentCity];
        }
        return itinerary;
    }
}
