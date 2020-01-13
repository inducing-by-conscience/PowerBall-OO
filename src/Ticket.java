public class Ticket {
    private String ticketsID;
    private Play[] plays;
    private int numberOfPlays;
    private String terminalId;

    private void generatePlays(){
        for(int counter = 0; counter < numberOfPlays; counter++){
            this.plays[counter] = new Play();
        }
    }
    public Ticket(String ticketsID, int numberOfPlays, String terminalId){
        this.ticketsID = ticketsID;
        this.plays = new Play[numberOfPlays];
        this.numberOfPlays = numberOfPlays;
        generatePlays();
        this.terminalId = terminalId;
    }

    public String getTicketsID(){
        return this.ticketsID;
    }

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
