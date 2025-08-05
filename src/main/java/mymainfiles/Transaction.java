package mymainfiles;

import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;

    private String type;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "accno")
    private Account account;

    public int getTid() { return tid; }
    public void setTid(int tid) { this.tid = tid; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}
