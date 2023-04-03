package com.example.managerment_player_footbal.controller.admin_controller;

import com.example.managerment_player_footbal.model.Classes;
import com.example.managerment_player_footbal.model.Player;
import com.example.managerment_player_footbal.repository.LAccountRepository;
import com.example.managerment_player_footbal.repository.LIClassesRepository;
import com.example.managerment_player_footbal.repository.LICoachRepository;
import com.example.managerment_player_footbal.repository.LIPlayerRepository;
import com.example.managerment_player_footbal.service.IAccountRoleService;
import com.example.managerment_player_footbal.service.IAccountService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class LPlayerController {
    @Autowired
    private LAccountRepository accountRepository;

    @Autowired
    private LICoachRepository icoachRepository;

    @Autowired
    private LIClassesRepository iclassesRepository;

    @Autowired
    private LIPlayerRepository iplayerRepository;

    @Autowired
    private IAccountService accountService;

    @Autowired
    IAccountRoleService iAccountRoleService;

    @GetMapping("/classes/{id}/listPlayer")
    public String listClasses(@PathVariable("id") int idClass, Model model) {
        model.addAttribute("players", iplayerRepository.findAllByClassesId(idClass));
        return "list_players";
    }

    @GetMapping("/classes/{idClass}/delete-player/{id}")
    public String deletePlayer(@PathVariable("idClass") int idClass, @PathVariable("id") int id) {

        Optional<Player> optionalPlayer = Optional.ofNullable(iplayerRepository.findById(id));
        Player player = optionalPlayer.orElseThrow(() -> new IllegalArgumentException("Invalid player Id:" + id));

        iplayerRepository.delete(player);
        return "redirect:/admin/classes/" + idClass + "/listPlayer";
    }

    @GetMapping("/classes/exportPlayerList")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Player> playerList = iplayerRepository.findAll();

        //Create Excel workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create Excel sheet
        XSSFSheet sheet = workbook.createSheet("Users");

        //Create header row
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID học viên");
        headerRow.createCell(1).setCellValue("Họ và tên");
        headerRow.createCell(2).setCellValue("Ngày sinh");
        headerRow.createCell(3).setCellValue("Cân nặng");
        headerRow.createCell(4).setCellValue("Chiều cao");
        headerRow.createCell(5).setCellValue("Số điện thoại phụ huynh");

        //Add data rows
        int rowCount = 1;
        for (Player classT : playerList) {
            DateFormat dateFormatte = new SimpleDateFormat("yyyy-MM-dd");
            String birthdateString = dateFormatte.format(classT.getBirthday());
            XSSFRow dataRow = sheet.createRow(rowCount++);
            dataRow.createCell(0).setCellValue(classT.getPlayerId());
            dataRow.createCell(1).setCellValue(classT.getName());
            dataRow.createCell(2).setCellValue(birthdateString);
            dataRow.createCell(3).setCellValue(classT.getWeight());
            dataRow.createCell(4).setCellValue(classT.getHeight());
            dataRow.createCell(5).setCellValue(classT.getParentPhone());


        }

        //Write output to response
        OutputStream out = response.getOutputStream();
        workbook.write(out);
        out.close();
        workbook.close();
    }

    @GetMapping("/classes/{idClass}/update-player/{id}")
    public String createClassForm(@PathVariable("idClass") int idClass, @PathVariable("id") int id, Model model) {
        Optional<Player> optionalPlayer = Optional.ofNullable(iplayerRepository.findById(id));
        Player player = optionalPlayer.orElseThrow(() -> new IllegalArgumentException("Invalid player Id:" + id));
        model.addAttribute("player", player);
        List<Classes> classes = iclassesRepository.findAll();
        model.addAttribute("classes", classes);
        return "update_player_form";
    }

    @PostMapping("/classes/{idClass}/update-player/admin/{id}/update-info")
    public String editClass(@PathVariable("idClass") int idClass, @ModelAttribute("player") Player player, HttpServletRequest request) {
        int classId = Integer.parseInt(request.getParameter("classesId"));
        Optional<Classes> classOptional = iclassesRepository.findById(classId);
        Classes classU = classOptional.orElse(new Classes());
        player.setClasses(classU);
        iplayerRepository.save(player);
        return "redirect:/admin/classes/" + idClass + "/listPlayer";
    }

}




