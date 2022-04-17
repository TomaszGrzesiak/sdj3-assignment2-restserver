package sdj3.springboot.restserver.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {
  private final OrderRepository orderRepository;

  @Autowired
  public OrderService(OrderRepository orderRepository) { this.orderRepository = orderRepository; }

  public Order addNewOrder(Order order) {
    Order result = orderRepository.save(order);
    System.out.println(result);
    return result;
  }

  public List<Order> getOrders() { return orderRepository.findAll(Sort.by(Sort.Direction.ASC, "id")); }

  public void deleteOrder(Long orderId) {
    boolean exists = orderRepository.existsById(orderId);
    if (!exists) throw new IllegalStateException("order with id " + orderId + " does not exist");
    orderRepository.deleteById(orderId);
  }

  @Transactional
  public void updateOrder(Long orderId, String description, float amount, boolean delivered) {
    Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalStateException(
        "order with id + " + orderId + " does not exists"));
    if (description != null && description.length() > 0) order.setDescription(description);
    if (amount != 0) order.setAmount(amount);
    order.setDelivered(delivered);
  }

  public Order getOrderById(Long orderId) {
    Order order = orderRepository.findById(orderId).orElseThrow(() -> new IllegalStateException(
        "order with id + " + orderId + " does not exists"));
    return order;
  }

  public Boolean doesOrderExist(Long orderId) {
    return orderRepository.existsById(orderId);
  }
}



