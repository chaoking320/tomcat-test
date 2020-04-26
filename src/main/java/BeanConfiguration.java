import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.demo.MyHttpClient;

@Configuration
public class BeanConfiguration {

    @Bean
    public MyHttpClient payBillMain() {
        return new MyHttpClient();
    }

}
