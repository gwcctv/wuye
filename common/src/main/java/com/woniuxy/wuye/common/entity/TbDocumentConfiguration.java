package com.woniuxy.wuye.common.entity;
/**
 * 单据配置表
 * @author 魏锦鹏
 */
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
@TableName("tb_document_configuration")
public class TbDocumentConfiguration  {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 单据类型
     */
    @TableField(value = "document_type", condition = SqlCondition.EQUAL)
    private String documentType;

    /**
     * 单据抬头
     */
    @TableField(value = "document_letterhead", condition = SqlCondition.EQUAL)
    private String documentLetterhead;

    /**
     * 适用项目
     */
    @TableField(value = "project_id", condition = SqlCondition.EQUAL)
    private Integer projectId;


private  String thisProjectName;
    /**
     * 收款单位
     */
    @TableField(value = "receiving_unit", condition = SqlCondition.EQUAL)
    private String receivingUnit;

    /**
     * 表头
     */
    @TableField(value = "table_head", condition = SqlCondition.EQUAL)
    private String tableHead;

    /**
     * 表尾
     */
    @TableField(value = "table_tail", condition = SqlCondition.EQUAL)
    private String tableTail;

    /**
     * 创建时间
     */
    @TableField(value = "creat_time", condition = SqlCondition.EQUAL)
    private String creatTime;

}