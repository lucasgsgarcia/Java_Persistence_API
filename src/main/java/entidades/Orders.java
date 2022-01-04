package entidades;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_num")
    private int order_num;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date order_date;

    @OneToOne(cascade =  CascadeType.PERSIST)
    @JoinColumn(name = "cust", referencedColumnName = "cust_num")
    private Customers cust;

    @OneToOne
    @JoinColumn(name = "rep", referencedColumnName = "empl_num")
    private Salesreps rep;

    
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "mfr", referencedColumnName = "mfr_id"),
    @JoinColumn(name = "product", referencedColumnName = "product_id")
    })
    private Products product;

    @Column(name = "qty", nullable = false)
    private int qty;

    @Column(name = "amount", nullable = false)
    private int amount;

    public Orders() {
    };

    public Orders(int order_num, Date order_date, Customers cust, Salesreps rep, Products product, int qty, int amount){
        super();
        this.order_num = order_num;
        this.order_date = order_date;
        this.cust = cust;
        this.rep = rep;
        this.product = product;
        this.qty = qty;
        this.amount = amount;
    }
    
    public int getOrder_num() {
        return order_num;
    }

    public void setOrder_num(int order_num) {
        this.order_num = order_num;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Customers getCust() {
        return cust;
    }

    public void setCust(Customers cust) {
        this.cust = cust;
    }

    public Salesreps getRep() {
        return rep;
    }

    public void setRep(Salesreps rep) {
        this.rep = rep;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return rep == orders.rep && qty == orders.qty && amount == orders.amount && order_num == orders.order_num && order_date.equals(orders.order_date) && cust.equals(orders.cust) && product.equals(orders.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_num, order_date, cust, rep, product, qty, amount);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_num=" + order_num +
                ", order_date=" + order_date.getTime() +
                ", cust=" + cust +
                ", rep=" + rep +
                ", product=" + product +
                ", qty=" + qty +
                ", amount=" + amount +
                '}';
    }

}
