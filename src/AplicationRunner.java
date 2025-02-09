import com.mysite.customer.service.CustomerService;

public class AplicationRunner {
    public static void main(String[] args) {
        CustomerService customerService=new CustomerService();
        customerService.run();
    }
}
