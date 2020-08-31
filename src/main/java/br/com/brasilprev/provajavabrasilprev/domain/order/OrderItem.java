package br.com.brasilprev.provajavabrasilprev.domain.order;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.brasilprev.provajavabrasilprev.domain.product.Product;

@Entity
@Table(name = "Order_Items")
public class OrderItem {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column	
	private BigDecimal value;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
    private Order order;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }    
}