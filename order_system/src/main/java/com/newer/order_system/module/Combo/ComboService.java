package com.newer.order_system.module.Combo;

import com.newer.order_system.pojo.Combo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ComboService {

    //查询所有套餐
    List<Combo> findAll();

    //查询某一个套餐
    Combo findOne(Integer id);

    //添加套餐
    Combo addCombo(Combo combo);

    //更新套餐信息
    Combo update(Combo combo);

    //删除某一个套餐
    void delete(Integer id);

//    //更新套餐价格
//    void postPrice(BigDecimal price);
//
//    //修改套餐状态
//    void upStatus(String status);
}
