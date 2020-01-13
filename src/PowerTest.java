import java.util.Scanner;

public class PowerTest {
    public static void main(String[] args){
        Terminal terminal1 = new Terminal("a001");
        Terminal terminal2 = new Terminal("b002");
        System.out.println("Which terminal do you want to use? (a or b)");
        Scanner scanner = new Scanner(System.in);
        String terminalUsed = scanner.nextLine();
        Terminal currentTerminal = terminalUsed.equalsIgnoreCase("a")? terminal1 : terminal2;
        System.out.println("How many plays do you want to ?");
        int numbersOfPlays = scanner.nextInt();
        currentTerminal.generateTickets(numbersOfPlays);
        scanner.nextLine();
        System.out.println("Check the Validation of Tickets~");
        System.out.println("Which terminal do you buy? ( a or b )");
        terminalUsed = scanner.nextLine();
        currentTerminal = terminalUsed.equalsIgnoreCase("a")? terminal1 : terminal2;
        System.out.println("Please enter you Ticket#:");
        String ticketNumber = scanner.nextLine();
        System.out.println("You code is " + (currentTerminal.ticketValidate(ticketNumber)?"Valid.":"Invalid."));
        System.out.println("See you next time!");
    }
}
