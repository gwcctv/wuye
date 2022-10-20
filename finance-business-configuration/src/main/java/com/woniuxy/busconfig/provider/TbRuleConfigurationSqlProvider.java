package com.woniuxy.busconfig.provider;

import com.woniuxy.wuye.common.entity.TbDocumentConfiguration;
import com.woniuxy.wuye.common.entity.TbRuleConfiguration;
import org.apache.ibatis.jdbc.SQL;

public class TbRuleConfigurationSqlProvider {
    public String getByCondition(TbRuleConfiguration tbRuleConfiguration) {
        if(tbRuleConfiguration==null){
            return  new SQL(){
                {
                    SELECT("*");
                    FROM("(SELECT a.*,tbp.project_name FROM (SELECT*FROM tb_rule_configuration tbc LEFT JOIN tb_ruleproject tbr ON tbc.id=tbr.rule_id) a LEFT JOIN tb_project  tbp ON a.project_id = tbp.project_id) hhh");}
            }.toString();
        }else {
            return new SQL() {
                {
                    SELECT("*");
                    FROM("(SELECT a.*,tbp.project_name FROM (SELECT*FROM tb_rule_configuration tbc LEFT JOIN tb_ruleproject tbr ON tbc.id=tbr.rule_id) a LEFT JOIN tb_project  tbp ON a.project_id = tbp.project_id) hhh");

                    if (tbRuleConfiguration.getProjectName()!= null) {
                        WHERE("project_name=#{projectName}");
                    }
                    if (tbRuleConfiguration.getRuleDescription()!= null) {
                        WHERE("rule_description=#{ruleDescription}");
                    }
                    if (tbRuleConfiguration.getRuleName()!= null) {
                        WHERE("rule_name=#{ruleName}");
                    }
                    if (tbRuleConfiguration.getRuleSituation()!= null) {
                        WHERE("rule_situation=#{ruleSituation}");
                    }
                }
            }.toString();
        }
    }
}

