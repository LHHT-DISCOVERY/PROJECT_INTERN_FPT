package com.example.managerment_player_footbal.service.impl;

import com.example.managerment_player_footbal.service.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class FileServiceImpl implements IFileService {
    @Override
    public File uploadFile(MultipartFile multipartFile, String path) {
        String fileName = multipartFile.getOriginalFilename();

        File folder = new File(path);

        if (!folder.exists()) {
            folder.mkdir();
        }

        File fileSaved = new File(folder.getAbsolutePath() + File.separator + fileName);

        BufferedOutputStream bs;

        try {
            bs = new BufferedOutputStream(new FileOutputStream(fileSaved));
            bs.write(multipartFile.getBytes());
            bs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileSaved;
    }

    @Override
    public void copyFile(File source, File target) {
        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(target);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
