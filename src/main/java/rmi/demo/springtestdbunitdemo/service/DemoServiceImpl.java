package rmi.demo.springtestdbunitdemo.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rmi.demo.springtestdbunitdemo.api.advice.exception.NotFoundException;
import rmi.demo.springtestdbunitdemo.db.DemoRepository;
import rmi.demo.springtestdbunitdemo.db.entity.DemoEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

  @Autowired
  private DemoRepository repository;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public List<DemoEntity> findAll() {

    List<DemoEntity> list = new ArrayList<>();
    repository.findAll().forEach(list::add);

    return list;
  }

  @Override
  public DemoEntity create(DemoEntity entity) {
    return repository.save(entity);
  }

  @Override
  public DemoEntity find(Long id) {
    return repository.findById(id).orElseThrow(()-> new NotFoundException("Entity was not found!"));
  }

  @Override
  public DemoEntity update(DemoEntity updateEntity) {
    return repository.save(updateEntity);
  }

}
