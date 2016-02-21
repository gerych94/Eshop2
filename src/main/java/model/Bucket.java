package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Vitaliy on 21.07.2015.
 */

@Entity
@Table(name = "buckets")
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Bucket;
    @OneToOne(mappedBy = "bucket")
    private Order order;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToMany
    @JoinTable(name = "products_buckets",joinColumns = {@JoinColumn(name="id_Bucket")},
    inverseJoinColumns = {@JoinColumn(name="id_product")})
    private List<Product> bucket =new ArrayList<Product>();
     @Column
    private double cost;


        public Bucket(){
        }

         public Bucket(Date date){
             this.date=date;
         }
    public void addProduct(Product product){
        bucket.add(product);
        cost+=product.getPrice();
    }
    public void deleteProduct(Product product){
        bucket.remove(product);
        cost-=product.getPrice();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Product> getBucket() {
        return bucket;
    }

    public void setBucket(List<Product> productList) {
        this.bucket = productList;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId_Bucket() {
        return id_Bucket;
    }

    public void setId_Bucket(int id_Bucket) {
        this.id_Bucket = id_Bucket;
    }

    @Override
    public String toString() {
        return "Bucket{" +
                "id_Bucket=" + id_Bucket +
                ", order=" + order +
                ", date=" + date +
                ", productList=" + bucket +
                ", cost=" + cost +
                '}';
    }
}
