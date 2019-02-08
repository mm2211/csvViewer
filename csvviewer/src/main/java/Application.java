import csvData.CSVImport;
import csvData.DataEntity;
import page.Page;
import userInterface.UserInterface;

import java.io.FileNotFoundException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws FileNotFoundException {
        CSVImport csvImport = new CSVImport();
        UserInterface ui = new UserInterface();
        Page page = new Page();
        List<DataEntity> csvdata = csvImport.importCSV();
        List<DataEntity> data = page.gotoFirstPage(csvdata);
        if (args.length == 0) {
            ui.showHeader(data);
        } else {
            page.setPageSize(Integer.parseInt(args[0]));
            ui.showHeader(data);
        }
        page.setNumberOfPages(csvdata.size()-1);
        ui.drawData(data.subList(1, data.size()));

        while(true) {
            ui.getUserInput();
            data = page.gotoLastPage(csvdata);
            ui.drawData(data.subList(1, data.size()));
        }
    }
}
