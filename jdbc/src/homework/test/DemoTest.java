package homework.test;

import homework.bean.AirInfo;
import homework.controller.AirController;
import homework.dao.AirInfoDao;
import homework.dao.impl.AirInfoDaoImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName:
 * @Descripton:
 * @author: head
 */
public class DemoTest {
    public static void main(String[] args) throws ParseException {
        AirController controller = new AirController();
        controller.main();
    }
}
