// I need to obtain console input somehow.
import java.util.Scanner;

public class Unit_Conversion
{
    // Constants are initialized relative to miles.
    // Since they all equal each other, ratios can be obtained between all of them with minimal number of constants to define.
    static int MILES = 1;
    static int YARDS = 1760;
    static int STEPS = 2112;
    static int CUBITS = 3520;
    static int FEET = 5280;
    static int INCHES = 63360;

    public static int PickCorrectConstant(String input_unit)
    {
        int output_constant = 0;

        switch (input_unit)
        {
            case "inches":
                output_constant = INCHES;
                break;
            case "feet":
                output_constant = FEET;
                break;
            case "cubits":
                output_constant = CUBITS;
                break;
            case "steps":
                output_constant = STEPS;
                break;
            case "yards":
                output_constant = YARDS;
                break;
            case "miles":
                output_constant = MILES;
        }

        return output_constant;
    }

    public static boolean AskIfInputUnitIsValid(String input_unit)
    {
        boolean validator_bool = true;

        switch (input_unit)
        {
            case "inches", "feet", "cubits", "steps", "yards", "miles":
                validator_bool = false;
                break;
            case null, default:
                System.out.println("Invalid unit! Input unit as displayed.");
                break;
        }
        return validator_bool;
    }

    public static void main(String[] args)
    {
        /*
        *
        * Constants:
        * Inches (Imperial)
        * Feet (Imperial)
        * Yards (Imperial)
        * Miles (Imperial)
        * Steps ([Technically 5/2 Roman Foot, from which 1 Roman Foot != 1 foot] I am assuming an imaginary Imperial step unit where 1 step = 5/2 foot. Also, there is a modern equivalent in the US customary system called "pace," this is an example to what I intend do.)
        * Cubits (Similarly, Cubits is an ancient Roman unit of length. I can still find a parallel modern unit. An equivalent cubit would be 3/2 a foot.)
        *
        * System.out.println("Unit conversion class initiated!");
        * System.out.println("These are the available units to input or output:");
        * System.out.println("inches\n" + "feet\n" + "cubits\n" + "steps\n" + "yards\n" + "miles");
        *
        * Scanner scannerTool = new Scanner(System.in);
        *
        * System.out.print("Input your number's current unit: ");
        * while loop:
        * String current_unit = scannerTool.nextLine();
        *
        * System.out.print("\n" + "Input your number's current value: ");
        * while loop:
        * String current_value = scannerTool.nextFloat();
        *
        * System.out.print("\n" + "Input your number's new unit: ");
        * while loop:
        * String new_value = scannerTool.nextLine();
        *
        */

        // Explaining the program.
        System.out.println("Unit conversion class initiated!");
        System.out.println("These are the available units to input or output:");
        System.out.println("inches\n" + "feet\n" + "cubits\n" + "steps\n" + "yards\n" + "miles");

        // This is the creation of the object we need to obtain inputs.
        Scanner scannerTool = new Scanner(System.in);

        // Current Unit
        System.out.print("Input your number's current unit: ");
        String current_unit = "";
        boolean unit_is_invalid = true;
        // Validating
        while (unit_is_invalid)
        {
            current_unit = scannerTool.next();
            unit_is_invalid = AskIfInputUnitIsValid(current_unit);
        }

        // Current Value
        System.out.print("\n" + "Input the number of " + current_unit + " you have: ");
        float current_value;
        // Validating
        while (!scannerTool.hasNextFloat())
        {
            System.out.println("Invalid value! Input a number as an integer or decimal!");
            scannerTool.next();
        }
        current_value = scannerTool.nextFloat();

        // New Unit
        System.out.print("\n" + "Input your number's new unit: ");
        String new_unit = "";
        unit_is_invalid = true;
        // Validating
        while (unit_is_invalid)
        {
            new_unit = scannerTool.next();
            unit_is_invalid = AskIfInputUnitIsValid(new_unit);
        }

        // New Value
        int current_unit_constant = PickCorrectConstant(current_unit);
        int new_unit_constant = PickCorrectConstant(new_unit);

        float new_value = current_value * ((float) new_unit_constant / current_unit_constant);
        System.out.println(new_value + " " + new_unit);
    }
}