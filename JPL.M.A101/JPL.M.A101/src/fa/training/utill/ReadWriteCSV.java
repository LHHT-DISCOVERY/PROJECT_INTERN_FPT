package fa.training.utill;

import fa.training.entities.Candidate;
import fa.training.entities.Experience;
import fa.training.entities.Fresher;
import fa.training.service.TableGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCSV {

    private static void writeListStringToCSV(List<String> stringList, String path, boolean append) {
        File file = new File(path);

        try {
            FileWriter fileWriter = new FileWriter(file, append);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : stringList) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("lỗi ghi file");
        }
    }

    public static void writeListFresherToCSV(List<Fresher> fresherList, String path, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Fresher fresher : fresherList) {
            stringList.add(fresher.getStringToWrite());
        }
        writeListStringToCSV(stringList, path, append);
    }

    public static void writeListExperienceToCSV(List<Experience> experienceList, String path, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Experience experience : experienceList) {
            stringList.add(experience.getStringToWrite());
        }
        writeListStringToCSV(stringList, path, append);
    }


    private static List<String> readCSV(String path) {
        File file = new File(path);
        List<String> listString = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                listString.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi đọc  file");
        }
        return listString;
    }

    public static <T extends Candidate> List<T> getListFresherFromCSV(String path) {
        List<T> fresherList = new ArrayList<>();
        List<String> stringList = readCSV(path);
        for (String line : stringList) {
            String[] array = line.split(",");
            Fresher fresher = new Fresher(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8], array[9]);
            fresherList.add((T) fresher);
        }
        return fresherList;
    }

    public static <T extends Candidate> List<T> getListExperienceFromCSV(String path) {
        List<T> experienceList = new ArrayList<>();
        List<String> stringList = readCSV(path);
        for (String line : stringList) {
            String[] array = line.split(",");
            Experience experience = new Experience(array[0], array[1], array[2], array[3], array[4], array[5], array[6], Integer.parseInt(array[7]), array[8]);
            experienceList.add((T) experience);
        }
        return experienceList;
    }

    // đọc ghi txt
    public static void writeFileToTXT(String filePath, List<Object> list) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Object objects : list
            ) {
                printWriter.println(objects.toString());
            }
            fileWriter.close();
            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //    public static void readFileTXT(String filePath) {
//        File file = new File(filePath);
//        try {
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNext()) {
//                String line = scanner.nextLine();
//                System.out.println(line);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void readFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại hoặc nội dung có lỗi");
        }
    }

    public static List<List<String>> readFileToTable(String filePath) {
        List<List<String>> rowList = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                List<String> row = new ArrayList<>();
                String[] array = null;
                for (int i = 0; i < line.length(); i++) {
                    array = line.split(",");
                }
                for (int i = 0; i < array.length; i++) {
                    row.add(array[i]);
                }
                rowList.add(row);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại hoặc nội dung có lỗi");
        }
        return rowList;
    }

    public static void printTableFresher() {
        TableGenerator tableGenerator = new TableGenerator();
        List<String> headersList = new ArrayList<>();
        headersList.add("Id");
        headersList.add("First Name");
        headersList.add("Last Name");
        headersList.add("Birthday ");
        headersList.add("Address");
        headersList.add("Phone");
        headersList.add("Email");
        headersList.add("Graduation Date");
        headersList.add("Graduation Rank");
        headersList.add("Education");
        List<List<String>> rowsList = ReadWriteCSV.readFileToTable("F:\\Intern_FPT\\fresher.txt");
        System.out.println(tableGenerator.generateTable(headersList, rowsList));

    }
}
