package org.example.backend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.backend.entity.po.Contract;

import java.util.List;

@Mapper
public interface ContractMapper {

    void insert(Contract contract);

    void delete(Contract contract);

    void update(Contract contract);

    List<Contract> selectAll();
}
