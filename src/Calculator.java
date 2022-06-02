import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private boolean roman;
    private int intA;
    private int intB;

    public static final Map<String, Integer> numberMap = new HashMap<>();

    static {
        numberMap.put("I", 1);
        numberMap.put("II", 2);
        numberMap.put("III", 3);
        numberMap.put("IV", 4);
        numberMap.put("V", 5);
        numberMap.put("VI", 6);
        numberMap.put("VII", 7);
        numberMap.put("VIII", 8);
        numberMap.put("IX", 9);
        numberMap.put("X", 10);
    }

    public boolean isRoman(String str) {
        return numberMap.containsKey(str);
    }

    public boolean isArabic(String str) {
        return str.matches("\\d+");
    }

    public void parse(String strA, String strB) throws Exception {
        if (isRoman(strA) && isRoman(strB)) {
            intA = numberMap.get(strA);
            intB = numberMap.get(strB);
            roman = true;
        } else if (isArabic(strA) && isArabic(strB)) {
            try {
                intA = Integer.parseInt(strA);
                intB = Integer.parseInt(strB);
                if (intA <= 0 || intA > 10 || intB <= 0 || intB > 10) {
                    throw new Exception("„исла должны быть в диапазоне от 0 до 10.");
                }
                roman = false;
            } catch (NumberFormatException nfe) {
                throw new Exception("Ќа вход передано не целое число");
            }
        } else {
            throw new Exception("используютс€ одновременно разные системы счислени€");
        }
    }

    public String calculateToString(String sign) throws Exception {
        checkSign(sign);
        int res = calculate(sign);
        if (roman) {
            return intToRoman(res);
        } else {
            return String.valueOf(res);
        }
    }

    private void checkSign(String sign) throws Exception {
        if (!(sign.equals("+") || sign.equals("-") || sign.equals("*") || sign.equals("/"))) {
            throw new Exception("Ќеверный тип операции");
        }
    }

    private String intToRoman(int value) {
        if (value <= 0) {
            throw new RuntimeException("в римской системе нет отрицательных чисел/нол€");
        }
        StringBuilder result = new StringBuilder();
        while (value > 0) {
            if ((value / 100) >= 1) {
                result.append("C");
                value = value - 100;
            } else if ((value / 50) >= 1) {
                result.append("L");
                value = value - 50;
            } else if ((value / 10) >= 1) {
                result.append("X");
                value = value - 10;
            } else {
                switch (value) {
                    case 9:
                        result.append("IX");
                        value = value - 9;
                        break;
                    case 8:
                        result.append("VIII");
                        value = value - 8;
                        break;
                    case 7:
                        result.append("VII");
                        value = value - 7;
                        break;
                    case 6:
                        result.append("VI");
                        value = value - 6;
                        break;
                    case 5:
                        result.append("V");
                        value = value - 5;
                        break;
                    case 4:
                        result.append("IV");
                        value = value - 4;
                        break;
                    case 3:
                        result.append("III");
                        value = value - 3;
                        break;
                    case 2:
                        result.append("II");
                        value = value - 2;
                        break;
                    case 1:
                        result.append("I");
                        value = value - 1;
                        break;
                }
            }
        }
        return result.toString();
    }

    private int calculate(String sign) throws Exception {
        switch (sign) {
            case "+":
                return intA + intB;
            case "-":
                return intA - intB;
            case "*":
                return intA * intB;
            case "/":
                return intA / intB;
            default:
                throw new Exception("Wrong sign.");
        }
    }
}
