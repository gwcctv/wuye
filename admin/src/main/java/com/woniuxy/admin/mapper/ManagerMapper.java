package com.woniuxy.admin.mapper;

import com.woniuxy.wuye.common.entity.TbManager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 管理者用户接口
 */
public interface ManagerMapper {
    /**
     * 增加管理者
     * @param tbManager
     */
    @Insert("insert into tb_manager(id,account,password,head_phone,state) values (#{id},#{account},#{password},#{headPhone},#{state},)")
    void  insert(TbManager tbManager);

    /**
     * 根据账号和密码查找用户，用于登录
     * @param account
     * @param password
     * @return
     */
    @Select("select * from tb_manager where account=#{account} and password=#{password}")
    TbManager getManager(@Param("account")String account, @Param("password")String password);

}
