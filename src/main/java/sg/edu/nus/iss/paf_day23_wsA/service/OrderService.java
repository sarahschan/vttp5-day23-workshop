package sg.edu.nus.iss.paf_day23_wsA.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_day23_wsA.model.Order;
import sg.edu.nus.iss.paf_day23_wsA.repo.OrderRepo;

@Service
public class OrderService {
    
    @Autowired
    OrderRepo orderRepo;

    public Optional<Order> getOrder(int orderId) {
        return orderRepo.getOrder(orderId);
    }
}
