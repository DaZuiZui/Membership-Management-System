package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ViproleMapper;
import com.ruoyi.system.domain.Viprole;
import com.ruoyi.system.service.IViproleService;

/**
 * 会员信息Service业务层处理
 *
 * @author ruoyi
 * @date 2023-02-13
 */
@Service
public class ViproleServiceImpl implements IViproleService
{
    @Autowired
    private ViproleMapper viproleMapper;

    /**
     * 查询会员信息
     *
     * @param id 会员信息主键
     * @return 会员信息
     */
    @Override
    public Viprole selectViproleById(Long id)
    {
        return viproleMapper.selectViproleById(id);
    }

    /**
     * 查询会员信息列表
     *
     * @param viprole 会员信息
     * @return 会员信息
     */
    @Override
    public List<Viprole> selectViproleList(Viprole viprole)
    {
        return viproleMapper.selectViproleList(viprole);
    }

    /**
     * 新增会员信息
     *
     * @param viprole 会员信息
     * @return 结果
     */
    @Override
    public int insertViprole(Viprole viprole)
    {
        return viproleMapper.insertViprole(viprole);
    }

    /**
     * 修改会员信息
     *
     * @param viprole 会员信息
     * @return 结果
     */
    @Override
    public int updateViprole(Viprole viprole)
    {
        return viproleMapper.updateViprole(viprole);
    }

    /**
     * 批量删除会员信息
     *
     * @param ids 需要删除的会员信息主键
     * @return 结果
     */
    @Override
    public int deleteViproleByIds(Long[] ids)
    {
        return viproleMapper.deleteViproleByIds(ids);
    }

    /**
     * 删除会员信息信息
     *
     * @param id 会员信息主键
     * @return 结果
     */
    @Override
    public int deleteViproleById(Long id)
    {
        return viproleMapper.deleteViproleById(id);
    }
}
