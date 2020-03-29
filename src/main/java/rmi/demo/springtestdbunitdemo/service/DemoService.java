package rmi.demo.springtestdbunitdemo.service;

import rmi.demo.springtestdbunitdemo.db.entity.DemoEntity;

import java.util.List;

public interface DemoService {

  List<DemoEntity> findAll();

  DemoEntity create(DemoEntity entity);

  DemoEntity find(Long id);

  DemoEntity update(DemoEntity entity);

}
