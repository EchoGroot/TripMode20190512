package TripMode;

import TripMode.model.Crossing;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

public class TestDB {
    public static void main(String[] args) throws IOException {
        InputStream ab = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ab);
        SqlSession session = factory.openSession();
        List<Crossing> list = session.selectList("test.selAll");
        for(Crossing crossing:list){
            System.out.print(crossing);
        }
        session.close();
    }

}
