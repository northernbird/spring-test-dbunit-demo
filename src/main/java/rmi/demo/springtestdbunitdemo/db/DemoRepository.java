package rmi.demo.springtestdbunitdemo.db;

import org.springframework.data.repository.CrudRepository;
import rmi.demo.springtestdbunitdemo.db.entity.DemoEntity;
import java.util.Optional;

public interface DemoRepository extends CrudRepository<DemoEntity, Long> {

  Optional<DemoEntity> findById(Long eventId);

}
