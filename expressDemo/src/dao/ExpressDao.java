package dao;

import pojo.Coordinate;
import pojo.Express;

import java.util.Random;

/**
 * dao层，对数据的操作
 */
public class ExpressDao {
    //初始化快递盒子，用来存取快递对象
    private Express[][] expresseArr = new Express[10][10];
    public ExpressDao(){
        expresseArr[0][0] = new Express("1001","顺丰",123456);
        expresseArr[2][2] = new Express("1002","韵达",322256);
        expresseArr[4][7] = new Express("1003","百世",432256);
    }

    /**
     * 获取所有快递柜
     * @return
     */
    public Express[][] getAllExpress(){
        return expresseArr;
    }
    /**
     *
     * @param express
     * @return
     */
    public Coordinate add(Express express){
        Random random = new Random();
        int x,y,code;
        do{
            x = random.nextInt(10);
            y = random.nextInt(10);
        }while (expresseArr[x][y] != null);//该位置有快递，重新生成
        do{
            code = random.nextInt(999999)+100000;
        }while (isExistCode(code));
        express.setCode(code);
        expresseArr[x][y] = express;
        return new Coordinate(x,y);
    }
    /**
     * 判断code是否重复
     * @param code
     * @return
     */
    private boolean isExistCode(int code){
        for (int i=0;i<expresseArr.length;i++){
            for (int j=0;j<expresseArr[i].length;j++){
                if(expresseArr[i][j]!=null && expresseArr[i][j].getCode() == code){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 根据快递单号删除快递
     * @param number
     * @return
     */
    public boolean delete(String number){
        Coordinate coordinate = findCoordinateByNumber(number);
        if(coordinate != null){
            expresseArr[coordinate.getX()][coordinate.getY()] = null;
        }else{
            return false;
        }
        return true;
    }
    public void update(String number,Express express){
        Coordinate coordinate = findCoordinateByNumber(number);
        Integer code = expresseArr[coordinate.getX()][coordinate.getY()].getCode();
        express.setCode(code);
        expresseArr[coordinate.getX()][coordinate.getY()] = express;
    }
    /**
     * 根据快递单号查找快递柜
     * @param number
     * @return
     */
    private Coordinate findCoordinateByNumber(String number){
        for(int i=0;i<expresseArr.length;i++){
            for (int j=0;j<expresseArr[i].length;j++){
                if(expresseArr[i][j]!=null){
                    if(number.equals(expresseArr[i][j].getNumber())){
                        return new Coordinate(i,j);
                    }
                }
            }
        }
        return null;
    }
    public boolean isExistNumber(String number){
        for(int i=0;i<expresseArr.length;i++){
            for (int j=0;j<expresseArr[i].length;j++){
                if(expresseArr[i][j]!=null){
                    if(number.equals(expresseArr[i][j].getNumber())){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 通过取件码获取快递信息,并从快递柜中删除快递
     * @param code
     * @return
     */
    public Express getExpressByCode(int code) {
        Coordinate coordinate = findByCode(code);
        Express express = expresseArr[coordinate.getX()][coordinate.getY()];
        expresseArr[coordinate.getX()][coordinate.getY()] = null;
        return express;
    }

    /**
     * 通过取件码获取快递位置
     * @param code
     * @return
     */
    public Coordinate findByCode(int code){
        for(int i=0;i<expresseArr.length;i++){
            for (int j=0;j<expresseArr[i].length;j++){
                if (expresseArr[i][j]!=null){
                    if(expresseArr[i][j].getCode() == code){
                        return new Coordinate(i,j);
                    }
                }
            }
        }
        return null;
    }
}
