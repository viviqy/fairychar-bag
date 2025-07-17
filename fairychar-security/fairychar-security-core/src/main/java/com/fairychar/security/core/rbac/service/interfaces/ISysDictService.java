package com.fairychar.security.core.rbac.service.interfaces;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fairychar.security.core.rbac.entity.SysDict;
import com.fairychar.security.core.rbac.pojo.dto.SysDictDTO;
import com.fairychar.security.core.rbac.pojo.query.AddSysDictQuery;
import com.fairychar.security.core.rbac.pojo.query.SysDictQuery;
import com.fairychar.security.core.rbac.pojo.query.UpdateSysDictQuery;

import java.io.Serializable;
import java.util.List;

/**
 * 数据字典详情(SysDict)表服务接口
 *
 * @author chiyo
 */
public interface ISysDictService extends IService<SysDict> {

    Page<SysDictDTO> pageAll(SysDictQuery sysDictQuery);

    int save(AddSysDictQuery sysDictQuery);

    boolean updateById(UpdateSysDictQuery updateSysApiQuery);

    SysDictDTO findById(Serializable id);
}
