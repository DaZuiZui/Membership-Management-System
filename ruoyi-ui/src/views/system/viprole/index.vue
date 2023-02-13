<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="部门" prop="department">
        <el-input
          v-model="queryParams.department"
          placeholder="请输入部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="职务" prop="position">
        <el-input
          v-model="queryParams.position"
          placeholder="请输入职务"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="genders">
        <el-input
          v-model="queryParams.genders"
          placeholder="请输入性别"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="民族" prop="nationality">
        <el-input
          v-model="queryParams.nationality"
          placeholder="请输入民族"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="政治面貌" prop="politicalBread">
        <el-input
          v-model="queryParams.politicalBread"
          placeholder="请输入政治面貌"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出生日期" prop="dateOfBirth">
        <el-date-picker clearable
          v-model="queryParams.dateOfBirth"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出生日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="手机号" prop="phonenumber">
        <el-input
          v-model="queryParams.phonenumber"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="工作单位" prop="employer">
        <el-input
          v-model="queryParams.employer"
          placeholder="请输入工作单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="微信号" prop="wechatId">
        <el-input
          v-model="queryParams.wechatId"
          placeholder="请输入微信号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="入会时间" prop="membershipTime">
        <el-date-picker clearable
          v-model="queryParams.membershipTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择入会时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="入会介绍人" prop="introducer">
        <el-input
          v-model="queryParams.introducer"
          placeholder="请输入入会介绍人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="特长" prop="expertise">
        <el-input
          v-model="queryParams.expertise"
          placeholder="请输入特长"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="会员状态" prop="status">
        <el-input
          v-model="queryParams.status"
          placeholder="请输入会员状态"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="离会时间" prop="departureTime">
        <el-date-picker clearable
          v-model="queryParams.departureTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择离会时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:viprole:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:viprole:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:viprole:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:viprole:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="viproleList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="部门" align="center" prop="department" />
      <el-table-column label="职务" align="center" prop="position" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="性别" align="center" prop="genders" />
 
      <el-table-column label="出生日期" align="center" prop="dateOfBirth" width="100">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.dateOfBirth, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
   
      <el-table-column label="入会时间" align="center" prop="membershipTime" width="100">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.membershipTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="入会介绍人" align="center" prop="introducer" />
      <el-table-column label="会员状态" align="center" prop="status" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:viprole:edit']"
          >查看</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:viprole:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改会员信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="部门" prop="department">
          <el-input v-model="form.department" placeholder="请输入部门" />
        </el-form-item>
        <el-form-item label="职务" prop="position">
          <el-input v-model="form.position" placeholder="请输入职务" />
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="genders">
          <el-input v-model="form.genders" placeholder="请输入性别" />
        </el-form-item>
        <el-form-item label="民族" prop="nationality">
          <el-input v-model="form.nationality" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="政治面貌" prop="politicalBread">
          <el-input v-model="form.politicalBread" placeholder="请输入政治面貌" />
        </el-form-item>
        <el-form-item label="出生日期" prop="dateOfBirth">
          <el-date-picker clearable
            v-model="form.dateOfBirth"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="手机号" prop="phonenumber">
          <el-input v-model="form.phonenumber" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="住址" prop="address">
          <el-input v-model="form.address" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="工作单位" prop="employer">
          <el-input v-model="form.employer" placeholder="请输入工作单位" />
        </el-form-item>
        <el-form-item label="微信号" prop="wechatId">
          <el-input v-model="form.wechatId" placeholder="请输入微信号" />
        </el-form-item>
        <el-form-item label="入会时间" prop="membershipTime">
          <el-date-picker clearable
            v-model="form.membershipTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择入会时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="入会介绍人" prop="introducer">
          <el-input v-model="form.introducer" placeholder="请输入入会介绍人" />
        </el-form-item>
        <el-form-item label="特长" prop="expertise">
          <el-input v-model="form.expertise" placeholder="请输入特长" />
        </el-form-item>
        <el-form-item label="会员状态" prop="status">
          <el-input v-model="form.status" placeholder="请输入会员状态" />
        </el-form-item>
        <el-form-item label="离会时间" prop="departureTime">
          <el-date-picker clearable
            v-model="form.departureTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择离会时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listViprole, getViprole, delViprole, addViprole, updateViprole } from "@/api/system/viprole";

export default {
  name: "Viprole",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 会员信息表格数据
      viproleList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        department: null,
        position: null,
        name: null,
        genders: null,
        nationality: null,
        politicalBread: null,
        dateOfBirth: null,
        phonenumber: null,
        address: null,
        employer: null,
        wechatId: null,
        membershipTime: null,
        introducer: null,
        expertise: null,
        status: null,
        departureTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询会员信息列表 */
    getList() {
      this.loading = true;
      listViprole(this.queryParams).then(response => {
        this.viproleList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        department: null,
        position: null,
        name: null,
        genders: null,
        nationality: null,
        politicalBread: null,
        dateOfBirth: null,
        phonenumber: null,
        address: null,
        employer: null,
        wechatId: null,
        membershipTime: null,
        introducer: null,
        expertise: null,
        status: null,
        departureTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加会员信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getViprole(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改会员信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateViprole(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addViprole(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除会员信息编号为"' + ids + '"的数据项？').then(function() {
        return delViprole(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/viprole/export', {
        ...this.queryParams
      }, `viprole_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
