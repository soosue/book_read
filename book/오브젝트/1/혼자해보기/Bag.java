public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public void changeInvitation(Ticket ticket) {
        this.ticket = ticket;
        this.invitation = null;
    }

    public void buyTicket(Ticket ticket) {
        this.ticket = ticket;
        this.amount = ticket.buy(amount);
    }
}