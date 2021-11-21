package homework.controller;

import homework.bean.AirInfo;
import homework.dao.AirInfoDao;
import homework.dao.impl.AirInfoDaoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class AirController {
    private Scanner input = new Scanner(System.in);
    private static boolean flag = true;
    private static AirInfoDao airInfoDao = new AirInfoDaoImpl();
    public void main() throws ParseException {
        while(flag){
            System.out.println("请选择操作（1.列出所有航班，2.按起飞时间查询，3.按目的地查询，4.删除航班，5.更新航班，6.离开系统）");
            String choose = input.nextLine();
            int num = Integer.parseInt(choose);
            switch (num) {
                case 1:
                    List<AirInfo> allList = airInfoDao.getAllList();
                    System.out.println("编号\t航班号\t目的地\t起飞日期\t");
                    for (AirInfo airInfo : allList) {
                        System.out.println(airInfo.getId() + "\t" + airInfo.getAirNum() + "\t" + airInfo.getDestination() + "\t" + airInfo.getAirDate() + "\t");
                    }
                    break;
                case 2:
                    System.out.println("请输入日期");
                    String date = input.nextLine();
                    List<AirInfo> list = airInfoDao.getByDate(date);
                    for (AirInfo airInfo : list) {
                        System.out.println(airInfo.getId() + "\t" + airInfo.getAirNum() + "\t" + airInfo.getDestination() + "\t" + airInfo.getAirDate() + "\t");
                    }
                    break;
                case 3:
                    System.out.println("请输入目的地");
                    String destination = input.nextLine();
                    List<AirInfo> list1 = airInfoDao.getByDestination(destination);
                    for (AirInfo airInfo : list1) {
                        System.out.println(airInfo.getId() + "\t" + airInfo.getAirNum() + "\t" + airInfo.getDestination() + "\t" + airInfo.getAirDate() + "\t");
                    }
                    break;
                case 4:
                    System.out.println("请输入需要删除的航班编号");
                    String airNum = input.nextLine();
                    int n = Integer.parseInt(airNum);
                    boolean b = airInfoDao.deleteByAirNum(n);
                    if (b){
                        System.out.println("删除成功！");
                    }else {
                        System.out.println("删除失败！");
                    }
                    break;
                case 5:
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.println("请输入要更新的航班编号：");
                    int id = Integer.parseInt(input.nextLine());
                    AirInfo airInfo = new AirInfo();
                    System.out.println("请输入新的航班号：");
                    String updateAirNum = input.nextLine();
                    System.out.println("请输入新的目的地：");
                    String updateDestination = input.nextLine();
                    System.out.println("请输入新的起飞时间：");
                    String updateAirDate = input.nextLine();
                    airInfo.setId(id);
                    airInfo.setAirNum(updateAirNum);
                    airInfo.setDestination(updateDestination);
                    airInfo.setAirDate(sdf.parse(updateAirDate));
                    boolean u = airInfoDao.updateById(airInfo);
                    if (u){
                        System.out.println("更新成功！");
                    }else {
                        System.out.println("更新失败！");
                    }
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("请输入1-6之间的数！");
                    break;
            }
        }
    }
}
