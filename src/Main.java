public class Main {

    public static String calc(String input) throws Exception {

        String[] inputArray = input.split("\\s+");
        if (inputArray.length > 3) {
            throw new Exception("������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)");
        }
        if (inputArray.length == 3) {
            String strA = inputArray[0];
            String sign = inputArray[1];
            String strB = inputArray[2];

            Calculator calculator = new Calculator();
            calculator.parse(strA, strB);
            return calculator.calculateToString(sign);
        } else {
            throw new Exception("������ �� �������� �������������� ���������");
        }
    }
}
