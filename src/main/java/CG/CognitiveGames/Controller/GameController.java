package CG.CognitiveGames.Controller;

import CG.CognitiveGames.Model.PDFFile;
import CG.CognitiveGames.Model.User;
import CG.CognitiveGames.Repository.PDFFileRepository;
import CG.CognitiveGames.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Controller
public class GameController implements HandlerInterceptor {

    @Autowired
    private GameService gameService;

    @Autowired
    private PDFFileRepository pdfFileRepository;

    @GetMapping("/**") // Handle all URLs
    public String redirectToLogin() {
        return "login"; // Redirect to the login page
    }

    @GetMapping("/games")
    public String viewGamesPage(Model model) {
        model.addAttribute("listGames", gameService.getAllgames());
        return "index";
    }

    @GetMapping("/projects")
    public String viewGamesPage() {
        return "projects";
    }



    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute(name = "user") User user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();

        if ("vasilis".equals(username) && "1234".equals(password)) {
            return "menu";
        }
        if ("danai".equals(username) && "5678".equals(password)) {
            return "menu";
        }

        model.addAttribute("invalidCredentials", true);
        return "login";
    }


    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }


    @GetMapping("/pdf")
    public String viewPdf(Model model) throws IOException {
        Optional<PDFFile> pdfFile = pdfFileRepository.findById(Integer.toUnsignedLong(1));
        String encodedPdf = new String(Base64.getEncoder().encode(pdfFile.get().getFile()));
        model.addAttribute("pdfContent", encodedPdf);
        return "pdfPage";
    }


}
