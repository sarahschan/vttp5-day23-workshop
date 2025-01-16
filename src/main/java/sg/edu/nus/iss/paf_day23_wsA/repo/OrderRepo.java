package sg.edu.nus.iss.paf_day23_wsA.repo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day23_wsA.model.Order;

@Repository
public class OrderRepo {
    
    @Autowired
    private JdbcTemplate template;

    public Optional<Order> getOrder(int orderId) {
        
        SqlRowSet rs = template.queryForRowSet(Query.SQL_GET_ORDER_SUMMARY, orderId);

        if (!rs.next()) {
            return Optional.empty();

        } else {
            return Optional.of(Order.toOrder(rs));
        }


    }
}
