import java.util.Arrays;

public class Terminal {
    private static int nextTicketId = 0;
    private String terminalID;
    private double sales;
    private int ticketsSize = 100;
    private Ticket[] tickets = new Ticket[ticketsSize];
    private int countOfTickets;
    private final int maximumPlaysPerTicket = 5;
    public Terminal( String terminalID ){
        this.terminalID = terminalID;
        sales = 0;
        countOfTickets = 0;
    }
    private String generateTicketsId(){
        String result = terminalID + Integer.toString(this.countOfTickets + 1 );
        return result;
    }

    private void checkTicketsSize(){
        if(countOfTickets == ticketsSize - 1){
            int newTicketSize = ticketsSize * 2;
            tickets = Arrays.copyOf( tickets, newTicketSize );
            ticketsSize = newTicketSize;
        }
    }
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
    public boolean ticketValidate(String ticketsID){
        boolean result = false;
        for(Ticket t: tickets){
            if(t != null && t.getTicketsID().equalsIgnoreCase(ticketsID) ){
                result = true;
            }
        }
        return result;
    }

    private void printTicket(Ticket ticket){
        System.out.println( ticket );
    }

    private void generateOneTicket(int playsOfTicket){
        String ticketsID = generateTicketsId();
        Ticket ticket = new Ticket( ticketsID, playsOfTicket, terminalID );
        checkTicketsSize();
        tickets[countOfTickets] = ticket;
        countOfTickets++;
        printTicket(ticket) ;
    }
}
