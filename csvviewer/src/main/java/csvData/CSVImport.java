package csvData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVImport {
    private List<DataEntity> csvData = new ArrayList<DataEntity>();
    private String[] dataset;

    public List<DataEntity> importCSV() throws FileNotFoundException {
        ClassLoader loader = CSVImport.class.getClassLoader();
        File file = new File(loader.getResource("data.csv").getFile());

        Scanner scanner = new Scanner(file);
        //   scanner.useDelimiter(";");
        while (scanner.hasNext()) {
            dataset = scanner.next().split(";");
            DataEntity dataEntity = new DataEntity(dataset[0], dataset[1], dataset[2]);
            csvData.add(dataEntity);
        }
        scanner.close();
        return csvData;
    }
}
