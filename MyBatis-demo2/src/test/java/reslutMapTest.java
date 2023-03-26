import com.xbhog.mapper.DyNamocSQLMapper;
import com.xbhog.mapper.EmpMapper;
import com.xbhog.pojo.Dept;
import com.xbhog.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xbhog
 * @date 2022/5/30
 */
public class reslutMapTest {
    @Test
    public void demoTest() throws IOException {
        SqlSession sqlSession = getSqlSession();
        //tuofengName(sqlSession);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //associationQuery(mapper);
        //splitSept(mapper);
        //selectTableQuery(mapper);
    }

    private void selectTableQuery(EmpMapper mapper) {
        //连表查询
        Emp empAllDate = mapper.getEmpAllDate(3);
        System.out.println(empAllDate);
    }

    private void splitSept(EmpMapper mapper) {
        //分步查询
        Emp empAndDeptStepOne = mapper.getEmpAndDeptStepOne(3);
        System.out.println(empAndDeptStepOne.getEmpName());
    }

    @Test
    public void demoTest2() throws IOException {
        SqlSession sqlSession = getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Dept deptAndEmpByStepOne = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(deptAndEmpByStepOne);

    }
    @Test
    public void demoTest3() throws IOException {
        SqlSession sqlSession = getSqlSession();
        DyNamocSQLMapper mapper = sqlSession.getMapper(DyNamocSQLMapper.class);
        Emp emp = new Emp(null,"李四",null,null);
        System.out.println(mapper.getEmpByCondition(emp));
    }

    private void associationQuery(EmpMapper mapper) {
        Emp empAndDept = mapper.getEmpAndDept(3);
        System.out.println(empAndDept);
    }

    private void tuofengName(SqlSession sqlSession) {
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        mapper.getAllEmp().forEach(System.out::println);
    }

    /**
     * 工具类
     * @return
     * @throws IOException
     */
    private SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
