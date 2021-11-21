package utils;

import java.util.List;

/**
 * @ClassName:
 * @Descripton:
 * @author: hedd
 */
public class PageUtils {
    private Integer pageSize = 5;
    private Integer total;
    private Integer pageIndex;
    private List dataList;
    private Integer pagesTotal;

    public Integer getPagesTotal() {
        return total%pageSize>0?total/pageSize+1:total/pageSize;
    }

    public void setPagesTotal(Integer pagesTotal) {
        this.pagesTotal = pagesTotal;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
