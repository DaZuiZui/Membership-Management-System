package com.ruoyi.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Viprole;
import com.ruoyi.system.service.IViproleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 会员信息Controller
 *
 * @author ruoyi
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/system/viprole")
public class ViproleController extends BaseController
{
    @Autowired
    private IViproleService viproleService;

    /**
     * 查询会员信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:viprole:list')")
    @GetMapping("/list")
    public TableDataInfo list(Viprole viprole)
    {
        startPage();
        List<Viprole> list = viproleService.selectViproleList(viprole);
        return getDataTable(list);
    }

    /**
     * 导出会员信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:viprole:export')")
    @Log(title = "会员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Viprole viprole)
    {
        List<Viprole> list = viproleService.selectViproleList(viprole);
        ExcelUtil<Viprole> util = new ExcelUtil<Viprole>(Viprole.class);
        util.exportExcel(response, list, "会员信息数据");
    }

    /**
     * 获取会员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:viprole:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(viproleService.selectViproleById(id));
    }

    /**
     * 新增会员信息
     */
    @PreAuthorize("@ss.hasPermi('system:viprole:add')")
    @Log(title = "会员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Viprole viprole)
    {
        return toAjax(viproleService.insertViprole(viprole));
    }

    /**
     * 修改会员信息
     */
    @PreAuthorize("@ss.hasPermi('system:viprole:edit')")
    @Log(title = "会员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Viprole viprole)
    {
        return toAjax(viproleService.updateViprole(viprole));
    }

    /**
     * 删除会员信息
     */
    @PreAuthorize("@ss.hasPermi('system:viprole:remove')")
    @Log(title = "会员信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(viproleService.deleteViproleByIds(ids));
    }
}
