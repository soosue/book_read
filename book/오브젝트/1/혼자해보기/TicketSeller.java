public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void changeOrSellTicket(Audience audience) {
        if (audience.hasInvitation()) {
            audience.changeInvitation(ticketOffice.change());
            return;
        }
        audience.buyTicket(ticketOffice.sell());
    }
}