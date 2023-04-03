package dao_repository;

import model.Certificate;

public interface ICertificateRepository {
    public Certificate addCertificate(Certificate certificate , int candidateID);
}
