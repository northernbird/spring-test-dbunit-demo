package rmi.demo.springtestdbunitdemo.db.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "demo")
@EntityListeners(AuditingEntityListener.class)
public class DemoEntity extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column
  private String name;

  @Column
  private String description;

}
