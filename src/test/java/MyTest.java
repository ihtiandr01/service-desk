import com.sdlite.Application;
import com.sdlite.domain.entities.Ticket;
import com.sdlite.domain.repositaries.TicketRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=Application.class)
public class MyTest {

    @Autowired
    TicketRepository ticketRepository;

    @Test
    public void testTicketRepo(){
        ticketRepository.save(new Ticket("Test ticket"));
    }

    @Test
    public void testFindTicket(){
        ticketRepository.findByName("Test ticket");
       //assertEquals();
    }

}
