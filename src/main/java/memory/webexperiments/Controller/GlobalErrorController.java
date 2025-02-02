package memory.webexperiments.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorController {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        return "redirect:/error";
    }
}
