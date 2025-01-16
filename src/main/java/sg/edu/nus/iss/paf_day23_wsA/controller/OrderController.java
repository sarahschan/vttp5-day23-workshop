package sg.edu.nus.iss.paf_day23_wsA.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.paf_day23_wsA.model.Order;
import sg.edu.nus.iss.paf_day23_wsA.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    
    @GetMapping("")
    public String orderSearch() {
        return "orderSearch";
    }


    @GetMapping(path = "/total", produces = "text/html")
    public String orderSearchResult(@RequestParam int orderId, Model model) {
        
        Optional<Order> orderOpt = orderService.getOrder(orderId);

        if (orderOpt.isEmpty()) {
            model.addAttribute("orderId", orderId);
            return "noOrderFound";
        }

        model.addAttribute("order", orderOpt.get());
        return "foundOrder";

    }
}
