// Reece Yang
//
// This class models a distance chart.

package U5Test;

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
        int iMin = Integer.MIN_VALUE;
        int minDist = Integer.MAX_VALUE;

        int length = cityNames.length;
        for (int i = 0; i < length; i++)
        {
            if (distances[currentCity][i] < minDist)
            {
                iMin = i;
                minDist = distances[currentCity][i];
            }
        }
        return iMin;
    }

    public String[] makeItinerary()
    {
        int length = cityNames.length;
        String[] itinerary = new String[length];
        int currentCity = findRemoteCity();
        for (int i = 0; i < length; i++)
        {
            itinerary[i] = cityNames[currentCity];
            for (int j = 0; j < length; j++)
            {
                distances[j][currentCity] = Integer.MAX_VALUE;
            }
            currentCity = findNearestCity(currentCity);
        }
        return itinerary;
    }
}
