package pojo;

import java.util.Objects;

/**
 * 快递类
 */
public class Express {
    private String number;//单号
    private String company;//公司名字
    private Integer code;//取件码

    public Express(String number, String company, Integer code) {
        this.number = number;
        this.company = company;
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Express express = (Express) o;
        return Objects.equals(number, express.number) && Objects.equals(company, express.company) && Objects.equals(code, express.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, company, code);
    }

    @Override
    public String toString() {
        return "Express{" +
                "number='" + number + '\'' +
                ", company='" + company + '\'' +
                ", code=" + code +
                '}';
    }

    public Express() {
    }
}
