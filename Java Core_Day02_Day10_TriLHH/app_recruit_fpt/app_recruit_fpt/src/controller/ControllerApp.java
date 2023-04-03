package controller;

import dao_repository.CandidateRepository;
import dao_repository.CertificateRepository;
import dao_repository.ICandidateRepository;
import dao_repository.ICertificateRepository;
import exception.UserException;
import model.*;
import validate.BirthDayException;
import validate.EmailException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ControllerApp {
    static Scanner scanner = new Scanner(System.in);
    ICandidateRepository iCandidateRepository = new CandidateRepository();
    ICertificateRepository iCertificateRepository = new CertificateRepository();

    public void addCertificateToDB(int candidateId) {
        System.out.println("Nhập mã chứng chỉ");
        int certificatedID = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Nhập tên chứng chỉ ");
        String certificateName = scanner.nextLine().trim();
        System.out.println("Nhập hạng tốt nghiệp chứng chỉ ");
        String certificateRank = scanner.nextLine().trim();
        System.out.println("Nhập ngày tốt nghiệp ");
        String CertificatedDate = enterCheckDate();
        Certificate certificate = new Certificate(certificatedID, certificateName, certificateRank, CertificatedDate);
        iCertificateRepository.addCertificate(certificate, candidateId);
    }

    void displayUpdateCandidate() {
        do {
            System.out.println("Nhập vào id bạn muốn thay update");
            int idCandidateUpdate = Integer.parseInt(scanner.nextLine());
            System.out.println("1. update họ tên \n" +
                    "2. update phone\n" +
                    "0. Thoát \n");
            System.out.println("nhập vào chức năng bạn update");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    iCandidateRepository.updateCandidate(idCandidateUpdate, 1);
                    return;
                case 2:
                    iCandidateRepository.updateCandidate(idCandidateUpdate, 2);
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Vui lòng nhập lại");
            }

        } while (true);
    }

    public String enterCheckDate() {
        do {
            String birthday = scanner.nextLine().trim();
            Date date = new Date();
            int yearNow = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
            try {
                BirthDayException.validate(birthday);
                if (BirthDayException.checkYear(birthday)) {
                    return birthday;
                } else {
                    System.out.printf(" -- Năm sinh phải từ 1900 đến %d -- ", yearNow);
                    System.out.println();
                    System.out.println(" -- Vui lòng nhập lại số kiểm tra lại số năm --");
                }
            } catch (NumberFormatException er) {
                System.out.println("Sai định dạng (yyyy/MM/dd)");
            } catch (UserException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public String enterCheckEmail() {
        do {
            System.out.println();
            System.out.println("Nhập Email nhân viên  : ");
            String email = scanner.nextLine().trim();
            if (EmailException.validate(email)) {
                return email;
            }
        } while (true);
    }

    public void displayMenu() {
        int select = 0;
        do {
            System.out.println("- Chương Trình Tuyển Dụng FPT - ");
            System.out.println("1. Thêm mới nhân viên \n" +
                    "2. Xem danh sách tên nhân viên \n" +
                    "3. cập nhật thông tin nhân viên \n" +
                    "0. Thoát");
            System.out.println("Enter select : ");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    System.out.println("Nhập mã nhân viên");
                    int CandidateID = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Nhập tên nhân viên : ");
                    String fullName = scanner.nextLine().trim();
                    System.out.println("Nhập ngày sinh nhân viên (yyyy-MM-dd) ");
                    String birthDay = enterCheckDate();
                    System.out.println("Nhập số điện thoại nhân viên  : ");
                    String phone = scanner.nextLine().trim();
                    String email = enterCheckEmail();
                    while (true) {
                        System.out.println("- Nhập vị trí úng tuyển  - ");
                        System.out.println("1. Fresher \n" +
                                "2. Intern \n" +
                                "3. Experience \n" +
                                "4. exit");
                        System.out.println("Enter select : ");
                        int candidatetype = Integer.parseInt(scanner.nextLine());
                        if (candidatetype == 4) {
                            break;
                        }
                        switch (candidatetype) {
                            case 1:
                                System.out.println("Nhập ngày tốt nghiệp (yyyy-MM-dd) : ");
                                String graduationDate = enterCheckDate();
                                System.out.println("Nhập hạn tốt nghiệp  ");
                                String graduationRank = scanner.nextLine().trim();
                                System.out.println("Nhập nơi tốt nghiệp : ");
                                String education = scanner.nextLine().trim();
                                Fresher fresher = new Fresher(CandidateID, fullName, birthDay, phone, email, 1, graduationDate, graduationRank, education);
                                iCandidateRepository.add(fresher);
                                break;
                            case 2:
                                System.out.println("Nhập ngành học ");
                                String majors = scanner.nextLine().trim();
                                System.out.println("Nhập kì học");
                                int semester = Integer.parseInt(scanner.nextLine());
                                System.out.println("Nhâp trường học ");
                                String universityName = scanner.nextLine().trim();
                                Intern intern = new Intern(CandidateID, fullName, birthDay, phone, email, 2, majors, semester, universityName);
                                iCandidateRepository.add(intern);
                                break;
                            case 3:
                                System.out.println("Nhập số năm kinh nghiệm : ");
                                int expInYear = Integer.parseInt(scanner.nextLine());
                                System.out.println("nhập kĩ năng");
                                String proSKill = scanner.nextLine().trim();
                                Experience experience = new Experience(CandidateID, fullName, birthDay, phone, email, 3, expInYear, proSKill);
                                iCandidateRepository.add(experience);
                                System.out.println(" ---- Chứng Chỉ ----  ");
                                break;
                            case 0:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Vui lòng nhập lại ");
                                break;
                        }
                        System.out.println("Nhập số tín chỉ hiện có : ");
                        int n2 = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < n2; i++) {
                            addCertificateToDB(CandidateID);
                        }
                        System.out.println(++Candidate.candidate_count + " Ứng viên đã lưu vào Database");
                    }
                    return;
                case 2:
                    List<Candidate> list = iCandidateRepository.getAll();
                    iCandidateRepository.sortCandidate(list);
                    System.out.println("Danh sách ứng viên : ");
                    for (Candidate candidate : list
                    ) {
                        System.out.println(candidate.showMe());
                    }
                    List<String> stringList = iCandidateRepository.getAllNameCandidate();
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < stringList.size(); i++) {
                        if (stringList.size() - 1 == i) {
                            sb.append(stringList.get(i));
                        } else {
                            sb.append(stringList.get(i)).append(",");
                        }
                    }
                    System.out.println("Tất cả họ tên trong candidate : " + sb);
                    break;
                case 0:
                    System.exit(0);
                case 3:
                    System.out.println("------------------------");
                    displayUpdateCandidate();
                    break;
                default:
                    System.out.println(" VUi lòng nhập lại! ");
            }
        } while (true);

    }
}