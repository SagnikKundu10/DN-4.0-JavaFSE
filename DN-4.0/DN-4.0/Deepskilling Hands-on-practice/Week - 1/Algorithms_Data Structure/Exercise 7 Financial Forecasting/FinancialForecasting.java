public class FinancialForecasting {

    public static double predictFutureValue(double currentValue, double rate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(currentValue * (1 + rate), rate, years - 1);
    }

    public static double predictFutureValueMemo(double currentValue, double rate, int years, Double[] memo) {
        if (years == 0) return currentValue;
        if (memo[years] != null) return memo[years];
        memo[years] = predictFutureValueMemo(currentValue * (1 + rate), rate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double currentValue = 1000.0;
        double annualGrowthRate = 0.10;
        int years = 5;

        double futureValue = predictFutureValue(currentValue, annualGrowthRate, years);
        System.out.println("Predicted Future Value (Recursive): " + futureValue);
        
        Double[] memo = new Double[years + 1];
        double futureValueMemo = predictFutureValueMemo(currentValue, annualGrowthRate, years, memo);
        System.out.println("Predicted Future Value (Memoized): " + futureValueMemo);
    }
}
