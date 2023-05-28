package CG.CognitiveGames.Controller;

import CG.CognitiveGames.Model.PDFFile;
import CG.CognitiveGames.Repository.PDFFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PDFController {

    @Autowired
    private PDFFileRepository pdfFileRepository;

    @PostMapping("/uploadpdf")
    public String uploadPDF(@RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                PDFFile pdfFile = new PDFFile();
                pdfFile.setFile(file.getBytes());
                pdfFileRepository.save(pdfFile);
                return "redirect:/success";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/error";
    }
}
