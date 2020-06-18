package calldriver;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PayRepository extends PagingAndSortingRepository<Pay, Long>{

    Pay findByCallId(Long callId);


}