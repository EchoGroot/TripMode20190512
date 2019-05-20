package TripMode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static SqlSessionFactory sessionFactory;
    //类加载时执行静态块，静态块只执行一次，以后不再执行
    static{
        Reader reader=null;
        try {
            reader= Resources.getResourceAsReader("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory=new SqlSessionFactoryBuilder().build(reader);
    }
    public static SqlSession getSession(){
        SqlSession session=sessionFactory.openSession();
        return  session;
    }

}
