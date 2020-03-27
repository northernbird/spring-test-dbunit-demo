package rmi.demo.springtestdbunitdemo.db.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

  @Column(name = "CREATE_TIMESTAMP", nullable = false, updatable = false)
  @CreatedDate
  private LocalDateTime createTimestamp;

  @Column(name = "UPDATE_TIMESTAMP")
  @LastModifiedDate
  private LocalDateTime updateTimestamp;

}
