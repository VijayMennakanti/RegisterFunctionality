package sample;

public class ClassA {
	public static void DemoNestedIf() {
		
		
		
		
		int age = 25;
		String nationality = "US";
		boolean hasVoterRegistration = true;
		boolean hasCriminalRecord = false;

		if (age >= 18) {
		    // Person is old enough to vote
		    if (nationality.equals("US")) {
		        // Person is eligible to vote in the US
		        if (hasVoterRegistration) {
		            // Person has a valid voter registration
		            if (!hasCriminalRecord) {
		                // Person does not have a criminal record affecting voting rights
		                System.out.println("You are eligible to vote in the US.");
		            } else {
		                // Person has a criminal record affecting voting rights
		                System.out.println("You are not eligible to vote due to a criminal record.");
		            }
		        } else {
		            // Person does not have a valid voter registration
		            System.out.println("You are not eligible to vote without voter registration.");
		        }
		    } else {
		        // Person is not eligible due to nationality
		        System.out.println("You are not eligible to vote in the US.");
		    }
		} else {
		    // Person is too young to vote
		    System.out.println("You are not old enough to vote.");
		}
	}

}
