package Utils;

import java.util.List;

public class Page<T> {
    //应该一开始提供
    private int currentPage;//当前页
    private int paggsize;//页大小
    //来自数据库
    private int totalRecord;//总记录数
    private List<T> list;

    public Page(int currentPage, int paggsize) {
        this.currentPage = currentPage;
        this.paggsize = paggsize;
    }

    /**
     * 总页数
     *
     * @return
     */
    public int getTotalPage() {
        int r;
        if (totalRecord % paggsize == 0) {
            r = totalRecord / paggsize;
        } else {
            r = totalRecord / paggsize + 1;
        }
        return r;
    }

    public int getUpPage() {
        if (currentPage > 1)
            return currentPage - 1;
        return 1;
    }

    public int getNextPage() {
        if (currentPage < getTotalPage())
            return currentPage + 1;
        return getTotalPage();
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPaggsize() {
        return paggsize;
    }

    public void setPaggsize(int paggsize) {
        this.paggsize = paggsize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
