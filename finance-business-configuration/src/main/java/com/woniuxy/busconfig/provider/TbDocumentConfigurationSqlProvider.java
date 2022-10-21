package com.woniuxy.busconfig.provider;

import com.woniuxy.wuye.common.entity.TbDocumentConfiguration;
import com.woniuxy.wuye.common.entity.TbMeasure;
import org.apache.ibatis.jdbc.SQL;

public class TbDocumentConfigurationSqlProvider {
    public String getByCondition(TbDocumentConfiguration tbDocumentConfiguration) {
        if(tbDocumentConfiguration==null){
            return  new SQL(){
                {
                    SELECT("*");
                    FROM("(SELECT tbc.*,tbp.project_name  this_project_name FROM tb_document_configuration tbc LEFT JOIN tb_project  tbp  ON tbc.project_id=tbp.project_id) aaa");}
            }.toString();
        }else {
            return new SQL() {
                {
                    SELECT("*");
                    FROM("(SELECT tbc.*,tbp.project_name  this_project_name FROM tb_document_configuration tbc LEFT JOIN tb_project  tbp  ON tbc.project_id=tbp.project_id) aaa");
                    if (tbDocumentConfiguration.getThisProjectName()!= null && !"".equals(tbDocumentConfiguration.getThisProjectName())) {
                        WHERE("this_project_name like concat('%',#{thisProjectName},'%')");
                       // WHERE("project_name=#{projectName}");
                    }
                    if (tbDocumentConfiguration.getDocumentType()!= null && !"".equals(tbDocumentConfiguration.getDocumentType())) {
                        WHERE("document_type=#{documentType}");
                    }
                    if (tbDocumentConfiguration.getDocumentLetterhead()!= null && !"".equals(tbDocumentConfiguration.getDocumentLetterhead())) {
                        WHERE("document_letterhead=#{documentLetterhead}");
                    }
                    if (tbDocumentConfiguration.getReceivingUnit()!= null && !"".equals(tbDocumentConfiguration.getReceivingUnit())) {
                        WHERE("receiving_unit=#{receivingUnit}");
                    }
                    if (tbDocumentConfiguration.getTableHead()!= null && !"".equals(tbDocumentConfiguration.getTableHead())) {
                        WHERE("table_head=#{tableHead}");
                    }
                    if (tbDocumentConfiguration.getTableTail()!= null && !"".equals(tbDocumentConfiguration.getTableTail())) {
                        WHERE("table_tail=#{tableTail}");
                    }
                    if (tbDocumentConfiguration.getCreatTime()!= null && !"".equals(tbDocumentConfiguration.getCreatTime())) {
                        WHERE("creat_time=#{creatTime}");
                    }
                    if (tbDocumentConfiguration.getProjectId()!= null && !"".equals(tbDocumentConfiguration.getProjectId())) {
                        WHERE("project_id=#{projectId}");
                    }
                }
            }.toString();
        }
    }
}
