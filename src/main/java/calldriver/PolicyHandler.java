package calldriver;

import calldriver.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    PayRepository pr;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCanceled_PayCancel(@Payload Canceled canceled){

        if(canceled.isMe()){
            Pay pay = pr.findByCallId(canceled.getId());
            pay.setCallId(canceled.getId());
            pay.setPayStatus("Canceled");

            pr.save(pay);
        }
    }

}
