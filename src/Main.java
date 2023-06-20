import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int age = 0;
        boolean marital = false;
        boolean dependent = false;
        int childCount = 0;
        boolean carOwnership = false;
        int expensesBudget;
        double monthlyIncome = 0.0;
        double shortTerm;
        double mediumTerm;
        double longTerm;
        double wants;
        double needs;
        String message;

        Scanner input = new Scanner(System.in);
        boolean hasAge = false;
        boolean hasMarital = false;
        boolean hasDependent = false;
        boolean hasChildCount = false;
        boolean hasCarOwnership = false;
        boolean hasMonthlyIncome = false;

        BudgetCalculator budgetCalculator = new BudgetCalculator();

        while(!hasAge)
            // Check if age entered correctly
            try {
                System.out.print("Enter age: ");
                age = input.nextInt();
                input.nextLine();
                hasAge = true;
            } catch(InputMismatchException ime) {
                // Display Error message
                System.out.println("Invalid character found, Please enter numeric values only !!");
                // Advance the scanner
                input.nextLine();
            }

        while(!hasMarital)
            // Check if marital status entered correctly
            try {
                System.out.print("Enter marital status (married -- TRUE, single -- FALSE): ");
                marital = input.nextBoolean();
                input.nextLine();
                hasMarital = true;
            } catch(InputMismatchException ime) {
                // Display Error message
                System.out.println("Invalid character found, Please enter boolean values only !!");
                // Advance the scanner
                input.nextLine();
            }

        while(!hasDependent)
            // Check if dependent status entered correctly
            try {
                System.out.print("Enter dependent status (with children -- TRUE, w/out children -- FALSE): ");
                dependent = input.nextBoolean();
                input.nextLine();
                hasDependent = true;
            } catch(InputMismatchException ime) {
                // Display Error message
                System.out.println("Invalid character found, Please enter boolean values only !!");
                // Advance the scanner
                input.nextLine();
            }

        // If has children, then only ask about how many children
        if (dependent) {
            while (!hasChildCount)
                // Check if child count entered correctly
                try {
                    System.out.print("Enter child count: ");
                    childCount = input.nextInt();
                    input.nextLine();
                    hasChildCount = true;
                } catch (InputMismatchException ime) {
                    // Display Error message
                    System.out.println("Invalid character found, Please enter numeric values only !!");
                    // Advance the scanner
                    input.nextLine();
                }
        }

        while(!hasCarOwnership)
            // Check if car ownership status entered correctly
            try {
                System.out.print("Enter car ownership status (car owner -- TRUE, public transport user -- FALSE): ");
                carOwnership = input.nextBoolean();
                input.nextLine();
                hasCarOwnership = true;
            } catch(InputMismatchException ime) {
                // Display Error message
                System.out.println("Invalid character found, Please enter boolean values only !!");
                // Advance the scanner
                input.nextLine();
            }


        expensesBudget = budgetCalculator.expensesBudget(age, marital, dependent, childCount, carOwnership);
        System.out.println("------------------------------------------------------------\n" +
                "Suggested expenses budget for Johor Bahru is RM" + expensesBudget +
                "\n------------------------------------------------------------\n");

        // Check if monthly income entered correctly
        while(!hasMonthlyIncome)
            try {
                System.out.print("Enter monthly income: ");
                monthlyIncome = input.nextDouble();
                input.nextLine();
                hasMonthlyIncome = true;
            } catch(InputMismatchException ime) {
                // Display Error message
                System.out.println("Invalid character found, Please enter numeric values only !!");
                // Advance the scanner
                input.nextLine();
            }

        shortTerm = budgetCalculator.budgetAllocation(monthlyIncome)[0];
        mediumTerm = budgetCalculator.budgetAllocation(monthlyIncome)[1];
        longTerm = budgetCalculator.budgetAllocation(monthlyIncome)[2];
        wants = budgetCalculator.budgetAllocation(monthlyIncome)[3];
        needs = budgetCalculator.budgetAllocation(monthlyIncome)[4];

        System.out.println("------------------------------------------------------------\n" +
                "Short-term savings = RM" + String.format("%.2f", shortTerm) +
                "\nMedium-term savings = RM" + String.format("%.2f", mediumTerm) +
                "\nLong-term savings = RM" + String.format("%.2f", longTerm) +
                "\nWants = RM" + String.format("%.2f", wants) +
                "\nNeeds = RM" + String.format("%.2f", needs) +
                "\n------------------------------------------------------------\n");

        message = budgetCalculator.getMessage();
        System.out.println(message);
    }
}