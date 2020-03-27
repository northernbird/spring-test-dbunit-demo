package rmi.demo.springtestdbunitdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmi.demo.springtestdbunitdemo.api.advice.exception.NotFoundException;
import rmi.demo.springtestdbunitdemo.db.DemoRepository;
import rmi.demo.springtestdbunitdemo.db.entity.DemoEntity;

@Service
public class DemoServiceImpl implements DemoService {

  @Autowired
  private DemoRepository repository;

  @Override
  public DemoEntity create(DemoEntity entity) {
    DemoEntity savedEntity = repository.save(entity);
    return savedEntity;
  }

  @Override
  public DemoEntity update(DemoEntity entity) {
    repository.findById(entity.getId()).orElseThrow(() -> new NotFoundException("Update entity was not found"));
    DemoEntity savedEntity = repository.save(entity);
    return savedEntity;
  }
}
