package rmi.demo.springtestdbunitdemo.db.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

  @Column(nullable = false, updatable = false)
  @CreatedDate
  private LocalDateTime createTimestamp;

  @Column
  @LastModifiedDate
  private LocalDateTime updateTimestamp;

  @Column
  @CreatedBy
  private String createUser;

  @Column
  @LastModifiedBy
  private String updateUser;

}
