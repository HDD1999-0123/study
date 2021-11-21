package expressDemo.dao;





import expressDemo.pojo.Express;
import expressDemo.utils.SerializeUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * dao层，处理数据
 */
public class ExpressDao {
    //初始化快递盒子，用来存取快递对象
    private List<Express> expressList = new ArrayList<>();
    private String fileName = "express.txt";
    public ExpressDao() {
        File file = new File(fileName);
        if (!file.exists()){
            try {
                file.createNewFile();
                SerializeUtil.mySerialize(expressList,fileName);//如果文件不存在，创建文件并初始化内容
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
        查询所有快递
     */
    public List<Express> getExpressList() throws IOException, ClassNotFoundException {
        expressList = (List<Express>) SerializeUtil.myDeserialize(fileName);//反序列化，取得存入的数据
        return expressList;
    }
    /*
        快递录入
     */
    public Express add(Express express) throws Exception {
        expressList = (List<Express>) SerializeUtil.myDeserialize(fileName);
        Random random = new Random();
        if (expressList.size() == 100){
            throw new Exception("快递柜已满，快递存入失败！");
        }
        int x,y,code;
        do{
            x = random.nextInt(10);
            y = random.nextInt(10);
        }while (isExist(x,y));//该位置有快递，重新生成
        do{
            code = random.nextInt(999999)+100000;
        }while (isExistCode(code));//code重复，重新生成code
        express.setX(x);
        express.setY(y);
        express.setCode(code);
        expressList.add(express);
        SerializeUtil.mySerialize(expressList,fileName);//序列化，将数据存入文件中
        return express;
    }
    /*
        判断编号code是否重复
     */
    private boolean isExistCode(int code) throws IOException, ClassNotFoundException {
        expressList = (List<Express>) SerializeUtil.myDeserialize(fileName);
        for (Express express : expressList) {
            if (express.getCode() == code){
                return true;
            }
        }
        return false;
    }

    /*
        判断该快递柜是否存在快递
     */
    public boolean isExist(int x,int y) throws IOException, ClassNotFoundException {
        expressList = (List<Express>) SerializeUtil.myDeserialize(fileName);
        for (Express express : expressList) {
            if (express.getX() == x && express.getY() == y){
                return true;
            }
        }
        return false;
    }
    /*
        删除快递
     */
    public boolean delete(String number) throws IOException, ClassNotFoundException {
        expressList = (List<Express>) SerializeUtil.myDeserialize(fileName);
        Express express = getExpressByNumber(number);
        if (express != null){
            expressList.remove(express);
            SerializeUtil.mySerialize(expressList,fileName);//删除后，需要更新文件
        }else {
            return false;
        }
        return true;
    }
    /*
        更新快递
     */
    public void update(String number, Express express) throws IOException, ClassNotFoundException {
        expressList = (List<Express>) SerializeUtil.myDeserialize(fileName);
        //把原先的删掉，然后添加修改的
        int x = getExpressByNumber(number).getX();
        int y = getExpressByNumber(number).getY();
        int code = getExpressByNumber(number).getCode();
        expressList.remove(getExpressByNumber(number));
        express.setX(x);
        express.setY(y);
        express.setCode(code);
        expressList.add(express);
        SerializeUtil.mySerialize(expressList,fileName);
    }
    /*
        根据单号获取快递
     */
    private Express getExpressByNumber(String number) throws IOException, ClassNotFoundException {
        expressList = (List<Express>) SerializeUtil.myDeserialize(fileName);
        for (Express express : expressList) {
            if (number.equals(express.getNumber())){
                return express;
            }
        }
        return null;
    }
    /*
        判断该单号快递是否存在
     */
    public boolean isExistNumber(String number) throws IOException, ClassNotFoundException {
        expressList = (List<Express>) SerializeUtil.myDeserialize(fileName);
        for (Express express : expressList) {
            if (number.equals(express.getNumber())){
                return true;
            }
        }
        return false;
    }
    /*
        取出快递
     */
    public Express getExpressByCode(int code) throws IOException, ClassNotFoundException {
        expressList = (List<Express>) SerializeUtil.myDeserialize(fileName);
        for (Express express : expressList) {
            if (code == express.getCode()){
                expressList.remove(express);
                SerializeUtil.mySerialize(expressList,fileName);
                return express;
            }
        }
        return null;
    }
}
