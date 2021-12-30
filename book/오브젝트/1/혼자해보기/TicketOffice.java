public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Ticket change() {
        return tickets.remove(0);
    }

    public Ticket sell() {
        Ticket ticket = tickets.remove(0);
        amount = ticket.sell();
        return ticket;
    }
}