package sdj3.springboot.restserver.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path ="viacanteen/rest/order")
public class OrderController {

  private final OrderService orderService;

  @Autowired
  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public Order addNewOrder(@RequestBody Order order) { return orderService.addNewOrder(order); }

  @GetMapping
  public List<Order> getOrders() { return orderService.getOrders(); }

  @GetMapping(path ="{orderId}")
  public Order getOrderById(@PathVariable("orderId") Long orderId) { return orderService.getOrderById(orderId); }

  @GetMapping(path ="/exist/{orderId}")
  public Boolean doesOrderExist(@PathVariable("orderId") Long orderId) { return orderService.doesOrderExist(orderId); }

  @DeleteMapping(path = "{orderId}")
  public void deleteOrder(@PathVariable("orderId") Long orderId) { orderService.deleteOrder(orderId);}

  @PutMapping(path = "{orderId}")
  public void updateOrder(@PathVariable("orderId") Long orderId,
      @RequestParam(required = false) String description,
      @RequestParam(required = false, defaultValue = "0") float amount,
      @RequestParam(required = false, defaultValue = "false") boolean delivered){
    orderService.updateOrder(orderId,description,amount,delivered);
  }
}
