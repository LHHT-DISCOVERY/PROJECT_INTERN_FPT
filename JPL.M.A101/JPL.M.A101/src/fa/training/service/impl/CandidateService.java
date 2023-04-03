package fa.training.service.impl;

import fa.training.entities.Experience;
import fa.training.entities.Fresher;
import fa.training.service.ICandidateService;
import fa.training.utill.ReadWriteCSV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateService implements ICandidateService {
    Scanner scanner = new Scanner(System.in);
    final String PATH_FRESHER = "src\\fa\\training\\data\\fresher.csv";
    final String PATH_TXT_FRESHER = "src\\fa\\training\\data\\fresher_TXXT.txt";
    final String PATH_EXPERIENCE = "src\\fa\\training\\data\\experience.csv";

    @Override
    public void showMenuAddCandidate() {
        System.out.println("Nhập số lượng ứng viên ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập mã nhân viên thứ " + ++i);
            String id = scanner.nextLine();
            System.out.println("Nhập họ của nhân viên : ");
            String firstName = scanner.nextLine().trim();
            System.out.println("Nhập tên của nhân viên : ");
            String lastName = scanner.nextLine().trim();
            System.out.println("Nhập ngày sinh của nhân viên ");
            String birthDay = scanner.nextLine();
            System.out.println("Nhập số điện thoại nhân viên  : ");
            String phone = scanner.nextLine().trim();
            System.out.println("Nhập địa chỉ của nhân viên");
            String address = scanner.nextLine();
            System.out.println("Nhập email của nhân viên ");
            String email = scanner.nextLine();
            do {
                System.out.println("- Nhập vị trí úng tuyển  - ");
                System.out.println("1. Fresher \n" +
                        "2. Experience \n" +
                        "3. exit");
                System.out.println("Enter select : ");
                int candidatetype = Integer.parseInt(scanner.nextLine());
                if (candidatetype == 3) {
                    break;
                }
                switch (candidatetype) {
                    case 1:
                        System.out.println("Nhập ngày tốt nghiệp");
                        String graduationDate = scanner.nextLine();
                        System.out.println("Nhập hạn tốt nghiệp  ");
                        String graduationRank = scanner.nextLine().trim();
                        System.out.println("Nhập nơi tốt nghiệp : ");
                        String education = scanner.nextLine().trim();
                        Fresher fresher = new Fresher(id, firstName, lastName, birthDay, address, phone, email, graduationDate, graduationRank, education);
                        //khai báo list Object để ghi txt
                        List<Object> list = new ArrayList<>();
                        // Khai báo list frssher đ ghi csv
                        List<Fresher> fresherList = new ArrayList<>();
                        list.add(fresher);
                        fresherList.add(fresher);
                        // ghi ra csv
                        ReadWriteCSV.writeListFresherToCSV(fresherList, PATH_FRESHER, true);
                        // ghi ra txt
                        ReadWriteCSV.writeFileToTXT("F:\\Intern_FPT\\fresher.txt", list);
                        break;
                    case 2:
                        System.out.println("Nhập số năm kinh nghiệm : ");
                        int expInYear = Integer.parseInt(scanner.nextLine());
                        System.out.println("nhập kĩ năng");
                        String proSKill = scanner.nextLine().trim();
                        Experience experience = new Experience(id, firstName, lastName, birthDay, address, phone, email, expInYear, proSKill);
                        // khai báo list experience để ghi csv
                        List<Experience> experienceList = new ArrayList<>();
                        // Khai báo list object để ghi txt
                        List<Object> listE = new ArrayList<>();
                        experienceList.add(experience);
                        listE.add(experience);
                        ReadWriteCSV.writeListExperienceToCSV(experienceList, PATH_EXPERIENCE, true);
                        ReadWriteCSV.writeFileToTXT("F:\\Intern_FPT\\experience.txt", listE);
                        break;
                    default:
                        System.out.println("không có sự lựa chọn này ");
                }
            } while (true);
        }
    }

    @Override
    public void showListFresher() {
        ReadWriteCSV.readFileText("F:\\Intern_FPT\\fresher.txt");
    }

    @Override
    public void showListExperience() {
        List<Experience> experienceList = ReadWriteCSV.getListExperienceFromCSV(PATH_EXPERIENCE);
        for (int i = 0; i < experienceList.size(); i++) {
            System.out.println((i + 1) + ". " + experienceList.get(i));
        }
    }
}
