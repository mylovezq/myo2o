package com.imooc.myo2o.service.impl;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.myo2o.dao.AreaDao;
import com.imooc.myo2o.dto.AreaExecution;
import com.imooc.myo2o.entity.Area;
import com.imooc.myo2o.enums.AreaStateEnum;
import com.imooc.myo2o.service.AreaService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    public List<Area> getAreaList()  {
        List<Area> areaList = null;

        areaList = this.areaDao.queryArea();

        return areaList;
    }

    public AreaExecution addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0) {
                    return new AreaExecution(AreaStateEnum.SUCCESS, area);
                } else {
                    return new AreaExecution(AreaStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("添加区域信息失败:" + e.toString());
            }
        } else {
            return new AreaExecution(AreaStateEnum.EMPTY);
        }
    }

    public AreaExecution modifyArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return new AreaExecution(AreaStateEnum.SUCCESS, area);
                } else {
                    return new AreaExecution(AreaStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败:" + e.toString());
            }
        } else {
            return new AreaExecution(AreaStateEnum.EMPTY);
        }
    }

    public AreaExecution removeArea(long areaId) {
        if (areaId > 0) {
            try {
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0) {
                    return new AreaExecution(AreaStateEnum.SUCCESS);
                } else {
                    return new AreaExecution(AreaStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败:" + e.toString());
            }
        } else {
            return new AreaExecution(AreaStateEnum.EMPTY);
        }
    }

    public AreaExecution removeAreaList(List<Long> areaIdList) {
        if (areaIdList != null && areaIdList.size() > 0) {
            try {
                int effectedNum = areaDao.batchDeleteArea(areaIdList);
                if (effectedNum > 0) {
                    return new AreaExecution(AreaStateEnum.SUCCESS);
                } else {
                    return new AreaExecution(AreaStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败:" + e.toString());
            }
        } else {
            return new AreaExecution(AreaStateEnum.EMPTY);
        }
    }
}

