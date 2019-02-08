package csvData;

public class Header {
    private int rowLength1;
    private int rowLength2;
    private int rowLength3;

    String value1;
    String value2;
    String value3;

    public Header(int rowLength1, int rowLength2, int rowLength3, String value1, String value2, String value3) {
        this.rowLength1 = rowLength1;
        this.rowLength2 = rowLength2;
        this.rowLength3 = rowLength3;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    public int getRowLength1() {
        return rowLength1;
    }

    public void setRowLength1(int rowLength1) {
        this.rowLength1 = rowLength1;
    }

    public int getRowLength2() {
        return rowLength2;
    }

    public void setRowLength2(int rowLength2) {
        this.rowLength2 = rowLength2;
    }

    public int getRowLength3() {
        return rowLength3;
    }

    public void setRowLength3(int rowLength3) {
        this.rowLength3 = rowLength3;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }
}
