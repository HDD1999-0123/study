package homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 某公司软件开发工程师孙工,作息规律为上三天班,休息一天,经常不确定休息日
 * 是否周末,为此,请你开发一个程序,当孙工输入年及月,以日历方式显示对应月
 * 份的休息日,用中括号进行标记.同时,统计出本月有几天休息,轮到周末休息有
 * 几天.(注:首次休息日是 2019 年 2 月 2 日)
 */
public class Demo5 {
    public static void main(String[] args) throws ParseException {
        //初始化
        Views views=new Views();
        //欢迎界面
        views.welcome();

        while(true){
            //设定目标时间
            int targetYear=views.getYearView();
            int targetMonth=views.getMonthView()-1;
            Calendar cl=Calendar.getInstance();
            cl.set(Calendar.YEAR,targetYear);
            cl.set(Calendar.MONTH,targetMonth);
            cl.set(Calendar.DAY_OF_MONTH,1);
            //确定本月最大天数
            int MaxDay=cl.getActualMaximum(Calendar.DAY_OF_MONTH);
            //判断第一天星期几
            int week=cl.get(Calendar.DAY_OF_WEEK);
            //调用周列表显示
            views.WeekListView();
            //第一天前空格
            for(int i=1;i<week;i++){
                System.out.printf("%-8s","");//%表示格式化，s代表输出字符串
            }
            //本月休息天数
            int relaxDay=0;
            //本月周末休息天数
            int relaxWeekDay=0;
            for(int i=1;i<=MaxDay;i++){
                //设置这是哪一天
                cl.set(Calendar.DAY_OF_MONTH,i);
                //获取目标的Date对象
                Date targetDate=cl.getTime();
                //调用判断是否休息函数
                if(judgeRelax(targetDate)){
                    System.out.printf("%-8s","["+cl.get(Calendar.DAY_OF_MONTH)+"]");
                    relaxDay++;
                    if(cl.get(Calendar.DAY_OF_WEEK)==6||cl.get(Calendar.DAY_OF_WEEK)==7){
                        relaxWeekDay++;
                    }
                }
                else{
                    System.out.printf("%-8d",i);
                }

                if(cl.get(Calendar.DAY_OF_WEEK)==7){
                    System.out.println(" ");
                }
            }
            System.out.println(" ");
            System.out.println("本月休息天数有"+relaxDay+"天");
            System.out.println("本月轮到周末休息天数有"+relaxWeekDay+"天");


            //判断是否继续
            String choose=views.continueView();
            if(choose.equals("y")){
                views.bye();
                break;
            }
            System.out.println("");
        }


    }
    public  static boolean judgeRelax(Date date) throws ParseException {
        //格式化
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        //原始时间  从一号开始排除02 01号
        Date remoteDate=format.parse("2019-02-02");
        //记录0202的毫秒
        long remoteTime=remoteDate.getTime();
        //记录目标日期毫秒
        long dateTime=date.getTime();
        //时间差 (天数)
        int result=(int)((dateTime-remoteTime)/1000/3600/24);
        //时间间隔是否为3天

        if(result>=0&&result%4==1){
            return true;
        }
        return false;
    }

}

/**
 * 视图类
 */
class Views{
    Scanner scanner=new Scanner(System.in);
    public int getYearView(){
        System.out.println("请输入年:");
        int year = scanner.nextInt();
        return year;
    }
    public int getMonthView(){
        System.out.println("请输入月份");
        int month= scanner.nextInt();
        return month;
    }
    public String continueView(){
        String temp = scanner.nextLine();
        System.out.println(" ");
        System.out.println("是否退出?  y/n");
        String choose = scanner.nextLine();
        return choose;
    }
    public  void welcome(){
        System.out.println("欢迎使用");
    }
    public void bye(){
        System.out.println("期待下次相遇");
    }
    public void WeekListView(){
        System.out.println("星期日\t星期一\t星期二\t星期三\t星期四\t星期五\t星期六");
    }
}
