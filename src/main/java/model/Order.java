package model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Vitaliy on 21.07.2015.
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Order;
    @ManyToOne
    @JoinColumn(name = "id_client" ,referencedColumnName = "id_client")
    private Client client;
    @OneToOne()
    @JoinColumn(name = "id_Bucket",referencedColumnName = "id_Bucket")
    private Bucket bucket;
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dateCreation;
    @Column
    private double amount;
    @Enumerated(EnumType.STRING)
    @Column
    private OrderStatus orderStatus;

    public Order (){
    }

    public Order( Client client, Bucket bucket, Date dateCreation, double amount, OrderStatus orderStatus) {
        this.client = client;
        this.bucket = bucket;
        this.dateCreation = dateCreation;
        this.amount = amount;
        this.orderStatus = orderStatus;
    }

    public int getId_Order() {
        return id_Order;
    }

    public void setId_Order(int id_Order) {
        this.id_Order = id_Order;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public void setBucket(Bucket bucket) {
        this.bucket = bucket;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id_Order=" + id_Order +
                ", client=" + client +
                ", bucket=" + bucket.getBucket() +
                ", dateCreation=" + dateCreation +
                ", amount=" + amount +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
