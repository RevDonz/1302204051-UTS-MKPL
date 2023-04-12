package lib;

public class TaxFunction {
  
    public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {

        final int TAX_NORMAL = 54000000;
        final int TAX_MARRIAGE = 4500000;
        final int TAX_CHILD = 4500000;

        int taxableIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking - deductible;

        int nonTaxableAllowance = TAX_NORMAL;

        if (isMarried) nonTaxableAllowance += TAX_MARRIAGE;

        if (numberOfChildren > 0) {
            int childAllowance = TAX_CHILD * Math.min(numberOfChildren, 3);
            nonTaxableAllowance += childAllowance;
        }

        int taxableAmount = taxableIncome - nonTaxableAllowance;

        int tax = (int) Math.round(0.05 * taxableAmount);

        return Math.max(tax, 0);
    }

}
