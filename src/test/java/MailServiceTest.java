
import com.rozainfotech.service.MailService;
import com.rozainfotech.service.UserService;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 *  2014 Roza Infotech Inc. 

 */

/**
 *
 * @author Akshay Kadu <akshay@rozainfotech.com>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "dev")
@ContextConfiguration(locations = {"classpath:spring-mail-beans.xml"})
public class MailServiceTest {

    @Autowired
    private MailService mailService;
    
    @Test
    public void shouldInjectService() {
        Assert.assertNotNull(mailService);
    }
    
    @Test 
    public void shouldSendEmail() {
        mailService.sendMessage();
    }
}
