package io.ggammu.study.jpa;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    @Embedded
    private Address address;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", fetch =  FetchType.LAZY)
    private Order order;
}