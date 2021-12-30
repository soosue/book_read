public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public boolean hasInvitation() {
        return bag.hasInvitation();
    }

    public changeInvitation(Ticket ticket) {
        bag.changeInvitation(ticket);
    }

    public void buyTicket(Ticket ticket) {
        bag.buyTicket(ticket);
    }
}