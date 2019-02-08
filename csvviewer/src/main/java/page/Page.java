package page;

import csvData.DataEntity;

import java.util.ArrayList;
import java.util.List;

public class Page {
    private static int currentPage = 1;
    private static int pageSize = 3;
    private static int numberOfPages;

    public List<DataEntity> gotoFirstPage(List<DataEntity> csvData) {
        currentPage = 1;
        return csvData.subList(0, pageSize + 1);
    }

    public List<DataEntity> gotoLastPage(List<DataEntity> csvData) {

        List<DataEntity> data = new ArrayList<DataEntity>();
        data.add(csvData.get(0));
        data.addAll(csvData.subList(csvData.size() - (csvData.size()%pageSize)+1, csvData.size()));
        return data;
    }

    public List<DataEntity> gotoNextPage(List<DataEntity> csvData) {
        if (numberOfPages != currentPage) {
            List<DataEntity> data = new ArrayList<DataEntity>();
            data.add(csvData.get(0));
            data.addAll(csvData.subList((pageSize*currentPage) - pageSize, (pageSize*currentPage)));
            return data;
        } else {
            return gotoFirstPage(csvData);
        }
    }

    public List<DataEntity> gotoPreviousPage(List<DataEntity> csvData) {
        if (currentPage != 1) {
            List<DataEntity> data = new ArrayList<DataEntity>();
            data.add(csvData.get(0));
            data.addAll(csvData.subList(csvData.size() - pageSize, csvData.size()));
            return data;
        } else {
            return gotoLastPage(csvData);
        }
    }

    public void setPageSize(int size) {
        pageSize = size;
    }
    public void setNumberOfPages(int datasize){
        numberOfPages = datasize/pageSize;
    }
}