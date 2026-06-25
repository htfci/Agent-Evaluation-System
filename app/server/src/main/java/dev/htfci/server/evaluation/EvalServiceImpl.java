package dev.htfci.server.evaluation;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class EvalServiceImpl implements EvalService {
    private final EvalRepository evalRepository;

    public EvalServiceImpl(EvalRepository evalRepository) {
        this.evalRepository = evalRepository;
    }

    @Override
    public RunEntity save(RunEntity run) {
        Objects.requireNonNull(run);
        return evalRepository.save(run);
    }
    
}
