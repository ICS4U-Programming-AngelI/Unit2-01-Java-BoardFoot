import java.util.Scanner; // Import the Scanner for user input

/**
 * This program calculates the required board length (in inches)
 * to create exactly 1 board foot (144 cubic inches), given the
 * width and height in inches entered by the user.
 *
 * It performs input validation and separates logic into functions.
 *
 * Formula to be used length = 144 / (width * height)
 *
 * Author: Angel
 * Version: 1.0
 * Since: 2025-10-01
 */

public final class BoardFoot { // Start of the BoardFoot class

    /** Constant for one board foot in cubic inches. */
    static final Float BOARD_FOOT_VOLUME = 144.0f;
    // 1 board foot = 144 cubic inches

    /**
     * Private constructor to prevent instantiation.
     */
    private BoardFoot() {
        // Private constructor to prevent object creation
        throw new IllegalStateException("Utility class");
        // Throws exception
    }

    /**
     * Calculates the required board length to make 1 board foot.
     *
     * @param width  the width in inches
     * @param height the height in inches
     * @return the required length in inches
     */
    public static Float calculateBoardFoot(final Float width,
            final Float height) { // Method to calculate length
        return BOARD_FOOT_VOLUME / (width * height);
        // Apply formula for length = volume / (width * height)
    }

    /**
     * Main method that gets input.
     * @param args Unused.
    */

    public static void main(final String[] args) { // Entry point of the program
        Scanner scanner = new Scanner(System.in);
        // Create Scanner object to read user input

        System.out.print("Enter width (in inches): ");
        // ask user to enter width
        String widthInput = scanner.nextLine(); // Read width input as a string

        Float width; // Variable to store width

        try { // Try to convert the width input
            width = Float.parseFloat(widthInput);
            // Convert input string to float
            if (width <= 0) { // Check if width is less than or equal to 0
                System.out.println("Width must be greater than 0.");
                // Print error message
                scanner.close(); // Close the scanner
                return; // Exit the program
            }
        } catch (NumberFormatException e) { // where input is not a valid number
            System.out.println("Invalid input. Please enter a numeric value.");
            // Print error message
            scanner.close(); // Close the scanner
            return; // Exit the program
        }

        System.out.print("Enter height (in inches): ");
        // ask user to enter height
        String heightInput = scanner.nextLine();
        // Read height input as a string

        Float height; // Variable to store height

        try { // Try to parse the height input
            height = Float.parseFloat(heightInput);
            // Convert input string to float
            if (height <= 0) { // Check if height is less than or equal to 0
                System.out.println("Height must be greater than 0.");
                // Print error message
                scanner.close(); // Close the scanner
                return; // Exit the program
            }
        } catch (NumberFormatException e) { // where input is not a valid number
            System.out.println("Invalid input. Please enter a numeric value.");
            // Print error message
            scanner.close(); // Close the scanner
            return; // Exit the program
        }

        float length = calculateBoardFoot(width, height);
        // Call method to calculate required length

        System.out.printf("To make 1 board foot");
        System.out.printf("the required length is: ");
        System.out.printf("%.2f inches.%n", length);
        // Print the result formatted to 2 decimal places

        scanner.close(); // Close the scanner to free system resources
    }
} // End of BoardFoot class
