package com.woniuxy.wuye.common.entity;
/**
 * 单据配置表
 * @author 魏锦鹏
 */
import lombok.Data;

/**
 * `tb_document_configuration`
 */
@Data
public class TbDocumentConfiguration  {
    private String id;

    /**
     * 单据类型
     */
    private String documentType;

    /**
     * 单据抬头
     */
    private String documentLetterhead;

    /**
     * 适用项目
     */
    private String projectId;

    /**
     * 收款单位
     */
    private String receivingUnit;

    /**
     * 表头
     */
    private String tableHead;

    /**
     * 表尾
     */
    private String tableTail;

    /**
     * 创建时间
     */
    private String creatTime;

}