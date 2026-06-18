package dev.htfci.server.evaluation;

import org.springframework.stereotype.Service;

@Service
public class EvalServiceImpl implements EvalService {
    private final EvalRepository evalRepository;

    public EvalServiceImpl(EvalRepository evalRepository) {
        this.evalRepository = evalRepository;
    }

    @Override
    public RunEntity save(RunEntity run) {
        return null;
    }

}
