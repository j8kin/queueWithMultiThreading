import java.util.Stack;

/**
 * Free number Pool
 */
class NextNumber {

    // pool of available numbers
    static private Stack<String> poolNumbers = new Stack<>();

    /**
     * Initialize number pool of free numbers
     */
    NextNumber() {
        poolNumbers.push("0");
        poolNumbers.push("1");
        poolNumbers.push("2");
        poolNumbers.push("3");
        poolNumbers.push("4");
        poolNumbers.push("5");
        poolNumbers.push("6");
        poolNumbers.push("7");
        poolNumbers.push("8");
        poolNumbers.push("9");
    }

    /**
     * Get available number or return empty string
     * @return available number
     */
    String getNumber() {
        if (!poolNumbers.isEmpty()) {
            return poolNumbers.pop();
        }
        return "";
    }

    /**
     * Add number to the pool of available numbers
     * @param number number to be added to pool of available numbers
     */
    void freeNumber(String number) {
        poolNumbers.push(number);
    }
}
