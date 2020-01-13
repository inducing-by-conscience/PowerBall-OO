import java.util.Arrays;

public class Terminal {
    private static int nextTicketId = 0;
    private String terminalID;
    private double sales;
    private int ticketsSize = 100;
    private Ticket[] tickets = new Ticket[ticketsSize];
    private int countOfTickets;
    public Terminal(String terminalID){
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
            tickets = Arrays.copyOf(tickets, newTicketSize);
            ticketsSize = newTicketSize;
        }
    }
    public void generateTickets( int numbersOfPlays){
        String ticketsID = generateTicketsId();
        Ticket ticket = new Ticket(ticketsID, numbersOfPlays, terminalID);
        checkTicketsSize();
        tickets[countOfTickets] = ticket;
        countOfTickets++;
        printTicket(ticket);
    }
    public boolean ticketValidate(String ticketsID){
        boolean result = false;
        for(Ticket t: tickets){
            if( ticketsID.equalsIgnoreCase( ticketsID ) ){
                result = true;
            }
        }
        return result;
    }

    private void printTicket(Ticket ticket){
        System.out.println(ticket);
    }
}
