public class BudgetCalculator {
    private int suggestedExpenses;
    private double shortTerm;
    private double mediumTerm;
    private double longTerm;
    private double wants;
    private double needs;
    private String message;

    public int expensesBudget(int age, boolean marital, boolean dependent, int childCount, boolean carOwnership) {
        int suggestedBudget = 0;
        if (age < 60) {
            // Married
            if (marital) {
                // With children
                if (dependent) {
                    // 1 child
                    if (childCount == 1) {
                        suggestedBudget = 5360;
                    } // More than 1 child
                    else {
                        suggestedBudget = 6100;
                    }
                }
                // W/out children
                else {
                    suggestedBudget = 4110;
                }
            }
            // Single
            else {
                // Car ownership
                if (carOwnership) {
                    suggestedBudget = 2290;
                }
                // Public transport user
                else {
                    suggestedBudget = 1760;
                }
            }
        }
        // Senior
        else {
            // Married
            if (marital) {
                // With children
                if (dependent) {
                    // 1 child
                    if (childCount == 1) {
                        suggestedBudget = 4200;
                    } // More than 1 child
                    else {
                        suggestedBudget = 4940;
                    }
                }
                // W/out children
                else {
                    suggestedBudget = 3020;
                }
            }
            // Single
            else {
                suggestedBudget = 2330;
            }
        }

        suggestedExpenses = suggestedBudget;

        return suggestedExpenses;
    }

    public double[] budgetAllocation(double monthlyIncome) {
        this.shortTerm = monthlyIncome * 0.1;
        this.mediumTerm = monthlyIncome * 0.1;
        this.longTerm = monthlyIncome * 0.1;
        this.wants = monthlyIncome * 0.25;
        this.needs = monthlyIncome * 0.45;

        double allocation[] = new double[5];

        allocation[0] = this.shortTerm;
        allocation[1] = this.mediumTerm;
        allocation[2] = this.longTerm;
        allocation[3] = this.wants;
        allocation[4] = this.needs;

        return allocation;
    }

    public String getMessage() {
        if ((wants + needs) > suggestedExpenses) {
            message = "Your wants and needs have exceeded your budget. Please review and make adjustments accordingly to regain control of your finances.";
        } else if ((wants + needs) <= suggestedExpenses) {
            message = "Congratulations! Your wants and needs are within your budget. Keep up the great work in managing your finances effectively.";
        } else message = "";

        return message;
    }
}
