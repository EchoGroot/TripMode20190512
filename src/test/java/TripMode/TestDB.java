package TripMode;


import TripMode.pojo.TheCrossing;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class TestDB {
    public static void main(String[] args) throws IOException {
        String id;
        InputStream ab = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(ab);
        SqlSession session = factory.openSession();
        List<TheCrossing> list = session.selectList("test.selAll");
        Scanner a = new Scanner(System.in);
        id=a.nextLine();
        //TheCrossing crossing =  session.selectOne("getLocation.getLocation",id);
        for(TheCrossing crossing:list){
            System.out.print(crossing);
        }
        //System.out.println(crossing.toString());
        session.close();
    }

}
