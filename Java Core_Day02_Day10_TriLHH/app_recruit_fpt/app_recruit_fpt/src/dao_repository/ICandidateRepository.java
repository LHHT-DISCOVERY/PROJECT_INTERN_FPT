package dao_repository;

import model.Candidate;
import model.Certificate;

import java.util.List;

public interface ICandidateRepository {
    public <T extends Candidate> T add(T candidate);

    public <T extends Candidate> List<T> getAll();

    public void sortCandidate(List<Candidate> list);

    public List<String> getAllNameCandidate();

    public void updateCandidate(int id, int caseFunction);
}
