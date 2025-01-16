package sg.edu.nus.iss.paf_day23_wsA.repo;

public class Query {
    
    public static final String SQL_GET_ORDER_SUMMARY = 
        """
            select o.id as orderId, 
                   o.order_date as orderDate, 
                   o.customer_id as customerId,
	               sum(od.quantity * od.unit_price * (1 - od.discount)) as totalPrice,
	               sum(od.quantity * p.standard_cost) as costPrice
	
	        from orders o
		        inner join order_details od on o.id = od.order_id
		        inner join products p on od.product_id  = p.id
	
	            where o.id = ?
	
	        group by
		        o.id, o.order_date, o.customer_id;    
        """;

}
