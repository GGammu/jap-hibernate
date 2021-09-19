package io.ggammu.study.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;

@Getter
@Table(name = "DELIVERY")
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID", nullable = false)
    private Long id;
    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;
    @OneToOne(mappedBy = "order")
    private Order order;
}