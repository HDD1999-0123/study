package view;

import dao.ExpressDao;
import exception.OutNumberException;
import pojo.Coordinate;
import pojo.Express;

import java.util.Random;
import java.util.Scanner;

/**
 * 视图类
 */
public class Views {
    public Scanner input = new Scanner(System.in);
    ExpressDao expressDao = new ExpressDao();
    /**
     * 欢迎界面
     */
    public static void welcome(){
        System.out.println("欢迎使用快递存取系统！");
    }

    /**
     * 结束界面
     */
    public static void bye(){
        System.out.println("本次操作结束，谢谢使用！");
    }
    private int validateNum(String strNum,int begin,int end) throws OutNumberException,NumberFormatException{
        int num = -1;
        try{
            num = Integer.parseInt(strNum);
            if(num<begin || num>end){
                throw new OutNumberException("输入数字的范围必须是"+begin+"到"+end+"范围之内");
            }
        }catch (NumberFormatException e){
            throw new NumberFormatException("必须输入数字");
        }
        return num;
    }
    /**
     * 主菜单界面
     * @return
     */
    public int menu(){
        int num = -1;
        do{
            System.out.println("请输入对应操作序号");
            System.out.println("1.管理员");
            System.out.println("2.普通用户");
            System.out.println("0.退出");
            String strNum = input.nextLine();
            try {
                num = validateNum(strNum,0,2);
                break;
            }catch (NumberFormatException e){
                System.err.println(e.getMessage());
            }catch (OutNumberException e){
                System.err.println(e.getMessage());
            }
        }while (true);
        if(num == 1){
            cMenu();
        }
        if(num == 2){
            uMenu();
        }
        if (num == 0){
            bye();
        }
        return num;
    }

    private void uMenu() {
        int code = 0;
        System.out.println("请输入取件码");
        String strCode = input.nextLine();
        code = Integer.parseInt(strCode);//将取件码转成int类型
        Coordinate coordinate = expressDao.findByCode(code);//获取快递柜坐标
        Express express = expressDao.getExpressByCode(code);//获取快递信息
        System.out.println("取件成功！");
        System.out.println("取出的快递信息："+express);
        System.out.println("快递所在柜子："+coordinate);
    }

    /**
     * 快递员界面
     * @return
     */
    private void cMenu(){
        int num = -1;
        do {
            System.out.println("请输入对应操作序号");
            System.out.println("1.快递录入");
            System.out.println("2.删除快递");
            System.out.println("3.修改快递");
            System.out.println("4.查看所有快递");
            System.out.println("0.返回上一级菜单");
            String strNum = input.nextLine();
            try{
                num = validateNum(strNum,0,4);
                break;
            }catch (NumberFormatException e){
                System.err.println(e.getMessage());
            }catch (OutNumberException e){
                System.err.println(e.getMessage());
            }
        }while (true);
        if(num == 1){
            Express express = new Express();
            System.out.println("请输入单号");
            String number = input.nextLine();
            System.out.println("请输入快递公司");
            String company = input.nextLine();
            express.setNumber(number);
            express.setCompany(company);
            Coordinate c = expressDao.add(express);
            System.out.println("快递存储成功，存储的快递柜位置为："+c);
        }
        if (num == 2){
            System.out.println("请输入要删除的单号");
            String number = input.nextLine();
            if(!expressDao.delete(number)){
                System.out.println("没有该快递！");
            }else {
                System.out.println("删除成功");
            }

        }
        if (num == 3){
            System.out.println("请输入需要修改的快递单号");
            Express express = new Express();
            String number = input.nextLine();
            if(expressDao.isExistNumber(number)){
                System.out.println("请输入单号");
                String n = input.nextLine();
                System.out.println("请输入公司");
                String c = input.nextLine();
                express.setNumber(n);
                express.setCompany(c);
                expressDao.update(number,express);
                System.out.println("修改完成");
            }else{
                System.out.println("没有此单快递");
            }
        }
        if (num == 4){
            Express[][] allExpress = expressDao.getAllExpress();
            printAllExpress(allExpress);
        }
        if(num == 0){
            menu();
        }
    }

    /**
     * 打印所有快递
     * @param allExpress
     */
    private void printAllExpress(Express[][] allExpress){
        for (int i=0;i<allExpress.length;i++){
            for(int j=0;j<allExpress[i].length;j++){
                if(allExpress[i][j] != null){
                    System.out.println(allExpress[i][j]);
                }
            }
        }
    }

}
