package dao_repository;

import model.Certificate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CertificateRepository implements ICertificateRepository {
    private final String INSERT_CERTIFICATE = "INSERT INTO  certificate VALUES (?,?,?,?,?);";

    @Override
    public Certificate addCertificate(Certificate certificate ,int candidateID) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_CERTIFICATE);
            ps.setInt(1, certificate.getCertificatedID());
            ps.setString(2, certificate.getCertificateName());
            ps.setString(3, certificate.getCertificateRank());
            ps.setString(4, certificate.getCertificatedDate());
            ps.setInt(5 , candidateID);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return certificate;
    }
}
