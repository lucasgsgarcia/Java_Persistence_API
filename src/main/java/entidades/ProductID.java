package entidades;

import java.io.Serializable;
import java.util.Objects;

public class ProductID implements Serializable {

	//MFR_ID && PRODUCT_ID são as chaves compostas.
    //Técnica do ID CLASS, define uma clase que é responsável pela chave de uma entidade.
     private String mfr_id;
     private String product_id;

    public ProductID(){

    }

    public ProductID(String mfr_id, String product_id) {
        super();
        this.mfr_id = mfr_id;
        this.product_id = product_id;
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

    //É necessário usar o hashCode e o Equals para não haver violação na chave primária.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductID productID = (ProductID) o;
        return Objects.equals(mfr_id, productID.mfr_id) && Objects.equals(product_id, productID.product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mfr_id, product_id);
    }
}
