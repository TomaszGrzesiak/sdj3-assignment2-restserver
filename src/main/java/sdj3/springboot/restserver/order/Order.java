package sdj3.springboot.restserver.order;

import javax.persistence.*;

@Entity
public class Order {
  @Id @Column(name = "id", nullable = false)
  @SequenceGenerator(name = "order_sequence",sequenceName = "order_sequence",allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_sequence")
  private Long id;

  private String description;
  private float amount;
  private boolean delivered;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public boolean isDelivered() {
    return delivered;
  }

  public void setDelivered(boolean delivered) {
    this.delivered = delivered;
  }


  @Override
  public String toString() {
    return "Order{" +
        "id=" + id +
        ", description='" + description + '\'' +
        ", amount=" + amount +
        ", delivered=" + delivered +
        '}';
  }
}
