package Terminal;

/**
 * @author jinjiantan
 * @version 0.1.0
 */
public class Ticket {
    private String ticketsID;
    private Play[] plays;
    private int numberOfPlays;
    private String terminalId;

    /**
     * helper method to generate plays
     */
    private void generatePlays(){
        for(int counter = 0; counter < numberOfPlays; counter++){
            this.plays[counter] = new Play();
        }
    }

    /**
     * Constructor with ticketsID, number of plays to generate, and the terminalID
     * @param ticketsID the unique ID of the ticket, cannot be changed after being constructed
     * @param numberOfPlays the number of plays want to generate
     * @param terminalId the unique ID of the terminal, cannot be changed after being constructed
     */
    public Ticket(String ticketsID, int numberOfPlays, String terminalId){
        this.ticketsID = ticketsID;
        this.plays = new Play[numberOfPlays];
        this.numberOfPlays = numberOfPlays;
        generatePlays();
        this.terminalId = terminalId;
    }

    /**
     * Accessor of field ticketsID
     * @return the String represented the ID of the tickets
     */
    public String getTicketsID(){
        return this.ticketsID;
    }

    /**
     * ToString method
     * @return the formatted String represents the ticket.
     */
    public String toString(){
        var stringBuilder = new StringBuilder();
        stringBuilder.append(" Ticket#: ");
        stringBuilder.append(ticketsID);
        stringBuilder.append(" Terminal#: ");
        stringBuilder.append(terminalId + "\n");
        for(Play p: plays){
            stringBuilder.append(p);
            stringBuilder.append("\n");
        }
        stringBuilder.append(" Good Luck! \n");
        return stringBuilder.toString();
    }


}
