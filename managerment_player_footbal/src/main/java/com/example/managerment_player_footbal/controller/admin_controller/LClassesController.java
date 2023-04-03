package com.example.managerment_player_footbal.controller.admin_controller;


import com.example.managerment_player_footbal.model.Classes;
import com.example.managerment_player_footbal.model.Coach;
import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.model.account.Account;
import com.example.managerment_player_footbal.repository.LAccountRepository;
import com.example.managerment_player_footbal.repository.LIClassesRepository;
import com.example.managerment_player_footbal.repository.LICoachRepository;
import com.example.managerment_player_footbal.repository.LIPlayerRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class LClassesController {
    @Autowired
    private LAccountRepository accountRepository;

    @Autowired
    private LICoachRepository icoachRepository;

    @Autowired
    private LIClassesRepository iclassesRepository;

    @Autowired
    private LIPlayerRepository iplayerRepository;


    @GetMapping("/classes")
    public String listClasses(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("userName", username);
        List<Classes> classes = iclassesRepository.findAll();
        model.addAttribute("classes", classes);
        return "list_classes_form";
    }

    @GetMapping("/classes/create-player")
    public String showAddPlayerForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("userName", username);
        List<Classes> classes = iclassesRepository.findAll();
        model.addAttribute("classes", classes);
        model.addAttribute("player", new Player());
        return "create_Player";
    }

    @PostMapping("/classes/classes/create-player")
    public String createPlayer(@ModelAttribute("player") Player player,
                               BindingResult result,
                               @RequestParam("avatar") MultipartFile avatar, HttpServletRequest request) throws IOException {


        // Lưu file ảnh thẻ vào thư mục "uploads" để có thể hiển thị trên trang web sau này
        String fileName = StringUtils.cleanPath(avatar.getOriginalFilename());
        String uploadDir = "src/main/resources/static/image";
        Path uploadPath = Paths.get(uploadDir).toAbsolutePath();
        Files.createDirectories(uploadPath); // tạo folder nếu folder chưa tồn tại
        Path filePath = uploadPath.resolve(fileName);
        Files.copy(avatar.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
//        //Lưu đường dẫn của ảnh vào database
        String avatarPath = "/" + "image" + "/" + fileName;
        player.setAvatar(avatarPath);

//        Lấy class id
        int classId = Integer.parseInt(request.getParameter("clases"));
//        Lấy user name
        String userName = request.getParameter("username");
        Optional<Account> accountOptional = accountRepository.findByAccountName(userName);
        Account account = accountOptional.orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản"));
        player.setAccount(account);

        Optional<Classes> classOptional = iclassesRepository.findById(classId);
        Classes classI = classOptional.orElse(new Classes());
        player.setClasses(classI);
        // Lưu thông tin người chơi vào cơ sở dữ liệu
        iplayerRepository.save(player);

        return "redirect:/admin/classes";
    }

    @GetMapping("/classes/create")
    public String createClassForm(Model model) {
        model.addAttribute("classes", new Classes());
        List<Coach> coaches = icoachRepository.findAll();
        model.addAttribute("coaches", coaches);
        return "class_form";
    }


    @PostMapping("/classes/create")
    public String createClass(@ModelAttribute("class") Classes classes, HttpServletRequest request) {
        int coachId = Integer.parseInt(request.getParameter("coach"));
        Optional<Coach> coachOptional = icoachRepository.findById(coachId);
        Coach coach = coachOptional.orElse(new Coach());
        classes.setCoach(coach);
        iclassesRepository.save(classes);
        return "redirect:/admin/classes";
    }


    @GetMapping("/classes/{id}/edit")
    public String editClassForm(@PathVariable("id") int id, Model model) {
        Classes classes = iclassesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid class Id:" + id));
        model.addAttribute("classes", classes);
        List<Coach> coaches = icoachRepository.findAll();
        model.addAttribute("coaches", coaches);
        return "update_classes_form";
    }

    @PostMapping("/classes/{id}/edit")
    public String editClass(@PathVariable("id") int id, @ModelAttribute("class") Classes classes, HttpServletRequest request) {
        classes.setClassId(id);
        int coachId = Integer.parseInt(request.getParameter("coach"));
        Optional<Coach> coachOptional = icoachRepository.findById(coachId);
        Coach coach = coachOptional.orElse(new Coach());
        classes.setCoach(coach);
        iclassesRepository.save(classes);
        return "redirect:/admin/classes";
    }

    @GetMapping("/classes/{id}/delete")
    public String deleteClass(@PathVariable("id") int id) {

        Classes classes = iclassesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid class Id:" + id));
        iclassesRepository.delete(classes);
        return "redirect:/admin/classes";
    }

    @GetMapping("/admin/export")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Classes> classList = iclassesRepository.findAll();

        //Create Excel workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create Excel sheet
        XSSFSheet sheet = workbook.createSheet("Users");

        //Create header row
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID lớp học");
        headerRow.createCell(1).setCellValue("Tên lớp học");
        headerRow.createCell(2).setCellValue("Số lượng");
        headerRow.createCell(3).setCellValue("Tên huấn luyện viên");
        headerRow.createCell(4).setCellValue("Thời gian bắt đầu");
        headerRow.createCell(5).setCellValue("Thời gian kết thúc");

        //Add data rows
        int rowCount = 1;
        for (Classes classT : classList) {
            DateFormat dateFormatte = new SimpleDateFormat("yyyy-MM-dd");
            String startDateString = dateFormatte.format(classT.getStartDate());
            String endDateString = dateFormatte.format(classT.getEndDate());
            XSSFRow dataRow = sheet.createRow(rowCount++);
            dataRow.createCell(0).setCellValue(classT.getClassId());
            dataRow.createCell(1).setCellValue(classT.getClassName());
            dataRow.createCell(2).setCellValue(classT.getCapacity());
            dataRow.createCell(3).setCellValue(classT.getCoach().getNameCoach());
            dataRow.createCell(4).setCellValue(startDateString);
            dataRow.createCell(5).setCellValue(endDateString);


        }

        //Write output to response
        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();
        workbook.close();
    }


    @GetMapping("/print-classes-pdf")
    public void printClassesPdf(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font font = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

        Paragraph title = new Paragraph("Danh sách lớp học", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
        title.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(20f);
        document.add(title);

        List<Classes> classes = (List<Classes>) iclassesRepository.findAll();

        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(100);

        PdfPCell cell = new PdfPCell(new Paragraph("ID lớp học", font));
        cell.setPadding(10);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Tên lớp học", font));
        cell.setPadding(20);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Số lượng", font));
        cell.setPadding(10);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Tên huấn luyện viên", font));
        cell.setPadding(10);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Thời gian bắt đầu", font));
        cell.setPadding(10);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Thời gian kết thúc", font));
        cell.setPadding(10);
        table.addCell(cell);

        cell = new PdfPCell(new Paragraph("Tính năng", font));
        cell.setPadding(10);
        table.addCell(cell);
        cell = new PdfPCell(new Paragraph(""));
        table.addCell(cell);

        for (Classes cl : classes) {


            table.addCell(new PdfPCell(new Paragraph(Integer.toString(cl.getClassId()), font)));
            table.addCell(new PdfPCell(new Paragraph(cl.getClassName(), font)));
            table.addCell(new PdfPCell(new Paragraph(Integer.toString(cl.getCapacity()), font)));
            table.addCell(new PdfPCell(new Paragraph(cl.getCoach().getNameCoach(), font)));
            table.addCell(new PdfPCell(new Paragraph(cl.getStartDate().toString(), font)));
            table.addCell(new PdfPCell(new Paragraph(cl.getEndDate().toString(), font)));
            table.addCell(new PdfPCell(new Paragraph("edit, delete", font)));
            table.addCell(new PdfPCell(new Paragraph("")));
        }

        document.add(table);

        document.close();
    }


}

