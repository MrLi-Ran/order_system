package com.newer.order_system.module.Combo;

import com.newer.order_system.mapper.ComboMapper;
import com.newer.order_system.pojo.Combo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComboServiceImpl implements ComboService {
    @Autowired
    ComboMapper comboMapper;

    @Override
    public List<Combo> findAll() {
        return comboMapper.findAll();
    }

    @Override
    public Combo findOne(Integer id) {
        return comboMapper.findOne(id);
    }

    @Override
    public Combo addCombo(Combo combo) {
        comboMapper.addCombo(
                combo.getName(),
                combo.getPrice(),
                combo.getStatus()
        );
        return combo;
    }

    @Override
    public Combo update(Combo combo) {
        comboMapper.update(
                combo.getId(),
                combo.getName(),
                combo.getPrice(),
                combo.getDetails(),
                combo.getStatus()
        );
        return combo;
    }

    @Override
    public void delete(Integer id) {
        comboMapper.delete(id);
    }
}
