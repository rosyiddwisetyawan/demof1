package com.example.demof1.service;

import com.example.demof1.model.TbRider;
import com.example.demof1.repository.TbRiderRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiderService {

    @Autowired
    private TbRiderRepository repository;

    public List<TbRider> getData(){
        List<TbRider> listRider = repository.findAll();
        return listRider;
    }

    public void save(TbRider rider){
        repository.save(rider);
    }

    public TbRider exist(Integer id){
        Optional<TbRider> opRider = repository.findById(id);
        if(opRider.isPresent()){
            TbRider tbRider = opRider.get();
            return tbRider;
        }
        return null;
    }

    public Boolean delete(Integer id){
        TbRider tb = exist(id);
        if(tb!=null){
            repository.delete(tb);
            return true;
        }
        return false;
    }
}
