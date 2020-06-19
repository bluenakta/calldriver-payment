package calldriver;


import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class ContractVerifierBase {

    @MockBean
    PayRepository payRepositoryr;

    @Autowired
    WebApplicationContext webApplicationContext;

    @LocalServerPort
    int port;


    @Before
    public void setup() {
        //remove::start[]
        RestAssuredMockMvc.webAppContextSetup(this.webApplicationContext);

        RestAssured.baseURI = "http://localhost";
        RestAssured.port = this.port;

        Pay ti = new Pay();
        ti.setCallId(1L);
        ti.setPayStatus("Canceled");


        given(this.payRepositoryr.findById(any())).willReturn(Optional.of(ti));
        Mockito.when(this.payRepositoryr.findById(any())).thenReturn(Optional.of(ti));
    }
}