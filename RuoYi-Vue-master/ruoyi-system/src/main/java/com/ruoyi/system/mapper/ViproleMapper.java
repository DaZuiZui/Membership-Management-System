package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Viprole;

/**
 * 会员信息Mapper接口
 *
 * @author ruoyi
 * @date 2023-02-13
 */
public interface ViproleMapper
{
    /**
     * 查询会员信息
     *
     * @param id 会员信息主键
     * @return 会员信息
     */
    public Viprole selectViproleById(Long id);

    /**
     * 查询会员信息列表
     *
     * @param viprole 会员信息
     * @return 会员信息集合
     */
    public List<Viprole> selectViproleList(Viprole viprole);

    /**
     * 新增会员信息
     *
     * @param viprole 会员信息
     * @return 结果
     */
    public int insertViprole(Viprole viprole);

    /**
     * 修改会员信息
     *
     * @param viprole 会员信息
     * @return 结果
     */
    public int updateViprole(Viprole viprole);

    /**
     * 删除会员信息
     *
     * @param id 会员信息主键
     * @return 结果
     */
    public int deleteViproleById(Long id);

    /**
     * 批量删除会员信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteViproleByIds(Long[] ids);
}
