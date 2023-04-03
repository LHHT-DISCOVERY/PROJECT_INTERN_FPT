import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Class Main để thực hiện giải quyết các bài tập
 *
 * @Author Huu Tri
 */
public class ExerciseTen {

    public static final String REGEX_PHONE = "^(0)+([3-9][0-9]{8})$";
    static int countLine = 1;
    public static final String REGEX_EMAIL = "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$";

    /**
     * method đọc file csv
     *
     * @param path :  đây là đường dẫn đến file bạn muốn đọc
     */
//    câu 10b
    private static void readCheckFile(String path) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            int count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                if (!readFileCsvCheckPhoneAndMail(parseCsvLine(line))) {
                    System.out.println(" ");
                    ++countLine;
                } else {
                    printStudent(parseCsvLine(line));
                    ++countLine;
                }
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void readFileCsv(String path) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                printStudent(parseCsvLine(line));
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * method in ra đối tượng
     *
     * @Param List<String></String>
     */

    private static void printStudent(List<String> student) {
        System.out.println(
                student.get(0) +
                        ", " + student.get(1) +
                        ", " + student.get(2) +
                        ", " + student.get(3) +
                        ", " + student.get(4)
        );
    }

    private static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            for (String i : splitData) {
                result.add(i);
            }
        }
        return result;
    }

    public static boolean readFileCsvCheckPhoneAndMail(List<String> student) {
        String phone = student.get(2);
        String email = student.get(3);
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Pattern pattern2 = Pattern.compile(REGEX_EMAIL);
        if (!pattern.matcher(phone).matches() && !pattern2.matcher(email).matches()) {
            System.out.print("Line " + countLine);
            System.out.print(" : co loi sai dinh dang StdPhone , StdEmail ");
            return false;
        } else if (!pattern.matcher(phone).matches()) {
            System.out.print("Line " + countLine);
            System.out.print(" : co loi sai dinh dang StdPhone ");
            return false;
        } else if (!pattern2.matcher(email).matches()) {
            System.out.print("Line " + countLine);
            System.out.print(" : co loi sai dinh dang StdEmail ");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        a
        readFileCsv("F:\\Intern_FPT\\Java Basic\\Java Core_Day04_TriLHH\\student.csv");
//        b
        readCheckFile("F:\\Intern_FPT\\Java Basic\\Java Core_Day04_TriLHH\\student.csv");
    }
}
