public class Ticket {
    private Long fee;

    public Ticket(Long fee) {
        this.fee = fee;
    }

    public Long buy(Long amount) {
        return amount - fee;
    }

    public Long sell(Long amount) {
        return amount + fee;
    }
}