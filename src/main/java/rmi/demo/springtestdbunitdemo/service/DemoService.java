package rmi.demo.springtestdbunitdemo.service;

import rmi.demo.springtestdbunitdemo.db.entity.DemoEntity;

public interface DemoService {

  DemoEntity create(DemoEntity entity);

  DemoEntity update(DemoEntity entity);

}
