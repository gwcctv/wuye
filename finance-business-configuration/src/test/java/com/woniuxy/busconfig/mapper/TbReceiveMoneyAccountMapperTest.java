package com.woniuxy.busconfig.mapper;

import com.woniuxy.wuye.common.entity.AccountAndProject;
import com.woniuxy.wuye.common.entity.TbReceiveMoneyAccount;
import com.woniuxy.wuye.common.utils.ChuLIjiHe;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TbReceiveMoneyAccountMapperTest {
    @Autowired
    TbReceiveMoneyAccountMapper tbReceiveMoneyAccountMapper;
    @Test
    public  void  testGetByCondition() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        TbReceiveMoneyAccount tbReceiveMoneyAccount=new TbReceiveMoneyAccount();
     List<TbReceiveMoneyAccount> tbReceiveMoneyAccounts= tbReceiveMoneyAccountMapper.getByCondition(tbReceiveMoneyAccount);
      List<TbReceiveMoneyAccount> tbReceiveMoneyAccounts1= ChuLIjiHe.get(tbReceiveMoneyAccounts,"id","projectId","projectIds","projectName","projectNames");

        System.out.println("111");

    }
    @Test
    public void testAddMiddle(){
        AccountAndProject accountAndProject=new AccountAndProject();
        accountAndProject.setAccountId(1);
        accountAndProject.setProjectId(1);
        tbReceiveMoneyAccountMapper.addAccountAndProject(accountAndProject);
    }
@Test
public void testDeleteMiddle(){
    AccountAndProject accountAndProject=new AccountAndProject();
    accountAndProject.setAccountId(1);
    accountAndProject.setProjectId(1);
    tbReceiveMoneyAccountMapper.deleteBangDingProjects(accountAndProject);
}
/**/
/**
 * 此方法针对界面展示一个类型展示多个项目
 * 名称             项目
 * w               A、B、C
 * X               A、C
 *
 * 前提条件：实体类中有Integer类型的projectId和String类型的projectName
 *          List<Integer> projectIds 和 List<String> projectNames
 *
 *          其中 List<String> projectNames 作为展示项目A、B、C数据来源
 *        ****注意属性名一定要相同********
 * */
    public <T> List<T> get(List<T> ts ) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
for(int i=0;i<ts.size();i++){
    Class c=ts.get(i).getClass();
    //获取实例对象
    Object obj=ts.get(i);
    //获取属性ID
   Field fieldId= c.getDeclaredField("id");
    fieldId.setAccessible(true);
   Integer id= (Integer) fieldId.get(obj);
    Field fieldProjectName=c.getDeclaredField("projectName");
    fieldProjectName .setAccessible(true);
    //项目名属性值
    Object oProjectName=fieldProjectName.get(obj);
    Field filedListProjectNames=c.getDeclaredField("projectNames");
    filedListProjectNames.setAccessible(true);
    //获取之前list中的projectNames 这个list属性值
    List<String> projectNames= (List<String>) filedListProjectNames.get(obj);
    if(projectNames==null){
        projectNames=new ArrayList<>();
    }
    projectNames.add((String)oProjectName );
    //获取之前list中的projectIds 这个list属性
    Field filedProjectIds=c.getDeclaredField("projectIds");
    filedProjectIds. setAccessible(true);
    List<Integer> projectIds=(List<Integer>) filedProjectIds.get(obj);
    if(projectIds==null){
        projectIds=new ArrayList<>();
    }
    //获取projectId属性值
    Field fieldProjectId=c.getDeclaredField("projectId");
    fieldProjectId.setAccessible(true);
    projectIds.add((Integer)fieldProjectId.get(obj) );
    filedProjectIds.set(obj,projectIds);
   for(int j=i+1;j<ts.size();j++){
       Class c1=ts.get(j).getClass();
       Object obj1=ts.get(j);
       Field fieldId1= c1.getDeclaredField("id");
       fieldId1.setAccessible(true);
       if(fieldId1.get(obj1)==id){
           Field fieldProjectName1=c1.getDeclaredField("projectName");
           fieldProjectName1 .setAccessible(true);
           Object oProjectName1=fieldProjectName1.get(obj1);
           //projectNames添加属性
           projectNames.add((String)oProjectName1 );
           //属性赋值
           filedListProjectNames.set(obj,projectNames);
           Field fieldProjectId1=c1.getDeclaredField("projectId");
           fieldProjectId1.setAccessible(true);
           projectIds.add((Integer)fieldProjectId1.get(obj1) );
           filedProjectIds.set(obj,projectIds);
           ts.remove(j);
           j--;
       }
   }
}
return  ts;
    }
}
