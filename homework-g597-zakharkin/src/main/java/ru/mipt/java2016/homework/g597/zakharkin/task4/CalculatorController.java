package ru.mipt.java2016.homework.g597.zakharkin.task4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.mipt.java2016.homework.base.task1.Calculator;
import ru.mipt.java2016.homework.base.task1.ParsingException;

@RestController
@RequestMapping("eval")
public class CalculatorController {
    private static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);
    @Autowired
    private RestfulCalculator calculator;
    @Autowired
    private BillingDao dbms;

    @RequestMapping(method = RequestMethod.POST, consumes = "text/plain", produces = "text/plain")
    public String eval(Authentication account,
                       @RequestBody String expression) throws ParsingException {
        LOG.debug("Evaluation request: [" + expression + "]");
        double result = calculator.calculate(account.getName(), expression);
        LOG.trace("Result: " + result);
        return Double.toString(result) + "\n";
    }

}
