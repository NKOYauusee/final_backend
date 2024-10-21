package org.example.backend.service;

import org.apache.ibatis.annotations.Mapper;
import org.example.backend.entity.po.Contract;

import java.util.List;

public interface ContractService {
    void insert(Contract contract);

    void delete(Contract contract);

    void update(Contract contract);

    List<Contract> selectAll(int page);

}
