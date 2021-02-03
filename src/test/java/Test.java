import com.qi.pojo.Books;
import com.qi.service.BookServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLOutput;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test()
    {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        BookServiceImpl bookServiceImpl = classPathXmlApplicationContext.getBean("bookServiceImpl", BookServiceImpl.class);
        List<Books> books = bookServiceImpl.queryAllBook();
        for (Books book:books
             ) {
            System.out.println(book);
        }
    }
}
