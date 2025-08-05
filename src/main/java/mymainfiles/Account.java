package mymainfiles;

import java.util.*;
import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accno;

    private String accname;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    public int getAccno() { return accno; }
    public void setAccno(int accno) { this.accno = accno; }

    public String getAccname() { return accname; }
    public void setAccname(String accname) { this.accname = accname; }

    public List<Transaction> getTransactions() { return transactions; }
    public void setTransactions(List<Transaction> transactions) { this.transactions = transactions; }

    public void addTransaction(Transaction t) {
        transactions.add(t);
        t.setAccount(this);
    }
}
