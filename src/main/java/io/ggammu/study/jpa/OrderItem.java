package io.ggammu.study.jpa;

import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor
@Table(name = "ORDER_ITEM")
@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;
    private Long orderPrice;
    private int count;

    @Builder
    public OrderItem(Long orderprice, int count) {
        this.orderPrice = orderprice;
        this.count = count;
    }
}
