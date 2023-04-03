package fa.training.controller;

import fa.training.service.ICandidateService;
import fa.training.service.TableGenerator;
import fa.training.service.impl.CandidateService;
import fa.training.utill.ReadWriteCSV;

import java.util.Scanner;

public class CandidateController {
    ICandidateService iCandidateService = new CandidateService();
    Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        do {
            System.out.println("- Chương Trình Tuyển Dụng FPT - ");
            System.out.println("1. Thêm mới nhân viên \n" +
                    "2. Xem danh sách Experience \n" +
                    "3. Xem danh sách Fresher \n" +
                    "4. Xem danh sách Fresher dưới dạng table \n" +
                    "0. Thoát");
            System.out.println("Enter select : ");
            int select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    iCandidateService.showMenuAddCandidate();
                    break;
                case 2:
                    iCandidateService.showListExperience();
                    break;
                case 3:
                    iCandidateService.showListFresher();
                    break;
                case 4:
                    ReadWriteCSV.printTableFresher();
                case 0:
                    System.exit(0);
                default:
                    System.out.println("không có sự lựa chọn này ");
            }
        } while (true);
    }

}
