package calculation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FireCalculatorController {

    @RequestMapping("/calcfin")
    public Result calculateFINumber(
            @RequestParam(value = "ySPending", required = true) Double ySPending,
            @RequestParam(value = "swr", required = true) Double swr) {
        Double result;
        validateForZero(swr);
        result = ySPending / swr;
        return new Result(result);
    }

    private void validateForZero(double swr) {
        if (swr == 0) {
            throw new IllegalArgumentException("Error: swr can not be zero");
        }
    }
}
