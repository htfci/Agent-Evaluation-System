package dev.htfci.server.evaluation;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvalRepository extends ListCrudRepository<RunEntity, Long> {}
