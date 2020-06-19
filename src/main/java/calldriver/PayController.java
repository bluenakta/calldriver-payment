package calldriver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class PayController {

  @PutMapping("/pays/canceled/{callId}")
  public Pay payCanceled(@PathVariable("callId") Long callId) {

   Pay pay = new Pay();
   pay.setCallId(callId);
   pay.setPayStatus("Canceled");

   return pay;
  }

 }
