import java.util.HashMap;

public class Main {

    private static final HashMap<String, Integer> map = new HashMap<String, Integer>();
    private static final int CONVERSION_FACTOR = 10;

    public static void main(String[] args) {

        // for each set of coins given as an argument...
        for (String str : args) {

            int cutoff = str.length() - 2;

            // get the number and type of the coin
            int coinNum = Integer.parseInt(str.substring(0, cutoff));
            String coinType = str.substring(cutoff).toLowerCase();

            // add coin type and value to hashmap
            map.put(coinType, coinNum);

        }

        // convert excess cp to sp
        convertCoin("cp", "sp");

        // convert excess sp to gp
        convertCoin("sp", "gp");

        // print each cointype and value
        map.forEach((key, value) -> {
            System.out.printf("%d%s ", value, key);
        });

    }

    // #region abstracted code

    /**
     * Converts a set of coins from one type to another.
     * 
     * @param fromCoinType the coin type to convert from
     * @param toCoinType   the coin type to convert to
     *
     */
    private static void convertCoin(String fromCoinType, String toCoinType) {

        int numOfTimes = calculateNumConversions(fromCoinType);

        decrementCoin(fromCoinType, numOfTimes);
        incrementCoin(toCoinType, numOfTimes);

    }

    /**
     * Reduces the given coin's number by the given conversion rate
     * 
     * @param coinType   the coin to decrement
     * @param numOfTimes the number of unit decrements to occur
     */
    private static void decrementCoin(String coinType, int numOfTimes) {

        // calculate how many of coin to remove
        int subtraction = CONVERSION_FACTOR * numOfTimes;

        // decrement by subtractive amount
        map.put(coinType, map.getOrDefault(coinType, 0) - subtraction);

        // if there are no more coins of this type, remove it from the map
        if (map.get(coinType) == 0)
            map.remove(coinType);

    }

    /**
     * Adds one to this coinType
     * 
     * @param coinType   the type of coin to increment
     * @param numOfTimes the number of times to increment the coin by
     */
    private static void incrementCoin(String coinType, int numOfTimes) {

        // if the coin already exists, add numOfTimes
        map.put(coinType, map.getOrDefault(coinType, 0) + numOfTimes);

        if (map.get(coinType) == 0)
            map.remove(coinType);

    }

    /**
     * Checks if the coin can be decremented by a specified value
     * 
     * @param coinType the type of coin to decrement
     * @return how many times the coin can be decremented
     */
    private static int calculateNumConversions(String coinType) {

        // calculate how many can be removed
        return map.getOrDefault(coinType, 0) / CONVERSION_FACTOR;

    }

    // #endregion

}