package Terminal;

import java.util.Arrays;

/**
 * @author jinjiantan
 * @version 0.1.0
 */
public class Terminal {
    private String terminalID;
    private double sales;
    private int ticketsSize = 100;
    private Ticket[] tickets = new Ticket[ticketsSize];
    private int countOfTickets;
    //The maximum number of plays per ticket.
    private final int maximumPlaysPerTicket = 5;

    /**
     * The basic contsructor
     * @param terminalID the Unique ID of the terminal, cannot be changed after being constructed
     */
    public Terminal( String terminalID ){
        this.terminalID = terminalID;
        sales = 0;
        countOfTickets = 0;
    }

    /**
     * The method to generate the TicketID base on the terminalID and the count of Tickets solved by this terminal
     * @return the String represents the uniqueTicketsID
     */
    private String generateTicketsId(){
        String result = terminalID + Integer.toString(this.countOfTickets + 1 );
        return result;
    }

    /**
     * The function to check whether the array to hold the record of the tickets are full,
     * if they are full, just expands the size of the array.
     */
    private void checkTicketsSize(){
        if(countOfTickets == ticketsSize - 1){
            int newTicketSize = ticketsSize * 2;
            tickets = Arrays.copyOf( tickets, newTicketSize );
            ticketsSize = newTicketSize;
        }
    }

    /**
     * The method to generate the tickets base on how many plays the customer has ordered.
     * @param numbersOfPlays the numbers of plays the customer has ordered.
     */
    public void generateTickets(int numbersOfPlays){
        int numbersOfTickets = numbersOfPlays / maximumPlaysPerTicket + 1;
        int playsOfLastTicket = numbersOfPlays % maximumPlaysPerTicket;
        while (numbersOfTickets > 1) {
            generateOneTicket( maximumPlaysPerTicket );
            numbersOfTickets--;
        }
        if ( playsOfLastTicket!= 0 ){
            generateOneTicket( playsOfLastTicket );
        }

    }

    /**
     * The basic method to check the validation of one ticket
     * @param ticketsID the id of the ticket to be checked
     * @return true for valid, false for invalid
     */
    public boolean ticketValidate(String ticketsID){
        boolean result = false;
        for(Ticket t: tickets){
            if(t != null && t.getTicketsID().equalsIgnoreCase(ticketsID) ){
                result = true;
            }
        }
        return result;
    }

    /**
     * The method to print tickets to customer
     * @param ticket the ticket to be printed
     */
    private void printTicket(Ticket ticket){
        System.out.println( ticket );
    }

    /**
     * helper method to generate one ticket
     * @param playsOfTicket the number of plays on the ticketß
     */
    private void generateOneTicket(int playsOfTicket){
        String ticketsID = generateTicketsId();
        Ticket ticket = new Ticket( ticketsID, playsOfTicket, terminalID );
        checkTicketsSize();
        tickets[countOfTickets] = ticket;
        countOfTickets++;
        printTicket(ticket) ;
    }
}
