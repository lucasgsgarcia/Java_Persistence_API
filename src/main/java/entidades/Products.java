package entidades;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Entity
@Table(name = "Products")
@IdClass(ProductID.class)
public class Products {
    /*
     Por meio dos atributos mfr_id (linha 16) e product_id (linha 19) e a anotação do @IDClass (linha 7),
     eu to inserindo na tabela Products uma chave primária composta;
     */
    @Id
    @Column(columnDefinition = "CHAR(3)")
    private String mfr_id;

    @Id
    @Column(columnDefinition = "CHAR(4)")
    private String product_id;

    @Column(length = 20)
    private String description;

    @Column(precision = 9, scale = 2)
    private double price;

    @Column(nullable = false)
    private int qty_on_hand;

    @OneToMany(mappedBy = "product")
    private Collection<Orders> orders;

    public Products() {
    }

    public Products(String mfr_id, String product_id, String description, double price, int qty_on_hand) {
        this.mfr_id = mfr_id;
        this.product_id = product_id;
        this.description = description;
        this.price = price;
        this.qty_on_hand = qty_on_hand;
    }



    public String getMfr_id() {
        return mfr_id;
    }

    public void setMfr_id(String mfr_id) {
        this.mfr_id = mfr_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty_on_had() {
        return qty_on_hand;
    }

    public void setQty_on_had(int qty_on_had) {
        this.qty_on_hand = qty_on_had;
    }

    public Collection<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Collection<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(mfr_id, products.mfr_id) && Objects.equals(product_id, products.product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mfr_id, product_id);
    }

	@Override
	public String toString() {
		return "Products [mfr_id=" + mfr_id + ", product_id=" + product_id + ", description=" + description + ", price="
				+ price + ", qty_on_hand=" + qty_on_hand + ", orders=" + orders + "]";
	}
    
    
}
