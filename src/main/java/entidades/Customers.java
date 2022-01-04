package entidades;
import javax.persistence.*;
import java.util.Objects;
@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cust_num")
    private int cust_num; //foreign and primary key

    @Column(length = 20)
    private String company;

    @Column(precision = 9, scale = 2)
    private double credit_limit;

    @OneToOne(cascade =  CascadeType.PERSIST)
    @JoinColumn(name = "cust_rep", referencedColumnName = "empl_num")
//    @Column(length = 20)
    private Salesreps cust_rep;//foreign

    public Customers() {
    }

    public Customers(int cust_num, Salesreps cust_rep, String company, double credit_limit) {
        this.cust_num = cust_num;
        this.cust_rep = cust_rep;
        this.company = company;
        this.credit_limit = credit_limit;
    }

    public int getCust_num() {return cust_num;}

    public void setCust_num(int cust_num) {this.cust_num = cust_num;}

    public Salesreps getCust_rep() {return cust_rep;}

    public void setCust_rep(Salesreps cust_rep) {this.cust_rep = cust_rep;}

    public String getCompany() {return company;}

    public void setCompany(String company) {this.company = company;}

    public double getCredit_limit() {return credit_limit;}

    public void setCredit_limit(double credit_limit) {this.credit_limit = credit_limit;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customers)) return false;
        Customers customers = (Customers) o;
        return cust_num == customers.cust_num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cust_num);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "cust_num=" + cust_num +
                ", cust_rep=" + cust_rep +
                ", company='" + company + '\'' +
                ", credit_limit=" + credit_limit +
                '}';
    }
}
