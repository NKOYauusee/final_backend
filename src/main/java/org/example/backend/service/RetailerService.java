package org.example.backend.service;

import org.example.backend.entity.po.Retailer;

import java.util.List;

public interface RetailerService {
    void insert(Retailer retailer);

    void update(Retailer retailer);
    void batchUpdate(List<Retailer> retailer);

    List<Retailer> selectAll(int id);

    List<Retailer> selectHasSelected();

    int getPageSize();
}
