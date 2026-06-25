package dev.htfci.server.evaluation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/eval")
public class EvalController {
    private final EvalService evalService;


    public EvalController(EvalService evalService) {
        this.evalService = evalService;
    }

    
}
