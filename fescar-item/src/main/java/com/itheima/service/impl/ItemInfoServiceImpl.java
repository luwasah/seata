package com.itheima.service.impl;

import com.itheima.dao.ItemInfoMapper;
import com.itheima.pojo.ItemInfo;
import com.itheima.service.ItemInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/****
 * @Author:shenkunlin
 * @Description:ItemInfo业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class ItemInfoServiceImpl implements ItemInfoService {

    @Resource
    private ItemInfoMapper itemInfoMapper;

    /***
     * 库存递减
     * @param id
     * @param count
     */
    @Override
    public void decrCount(int id, int count) {
        //查询商品信息
        ItemInfo itemInfo = itemInfoMapper.selectByPrimaryKey(id);
        itemInfo.setCount(itemInfo.getCount()-count);
        int dcount = itemInfoMapper.updateByPrimaryKeySelective(itemInfo);
        System.out.println("库存递减受影响行数："+dcount);
//        int q=10/0;
    }
}
