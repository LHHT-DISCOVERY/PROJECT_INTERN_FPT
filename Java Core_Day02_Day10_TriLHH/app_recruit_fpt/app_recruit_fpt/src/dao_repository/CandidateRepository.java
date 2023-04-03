package dao_repository;

import model.*;

import java.sql.*;
import java.util.*;

public class CandidateRepository implements ICandidateRepository {
    private final String INSERT_CANDIDATE = "INSERT INTO  candidate(id ,full_name ,  birthday ,  phone ,  email ,candidate_type ) VALUES (?,?, ?, ?, ?,?);";
    private final String INSERT_EXPERIENCE = "INSERT INTO experience (exp_in_year, pro_skill, id) VALUES (?,?,?);";
    private final String INSERT_INTERN = "INSERT INTO intern (majors, semester,university_name, id) VALUES (?,?, ?,?);";
    private final String INSERT_FRESHER = "INSERT INTO fresher (graduation_date, graduation_rank, education, id) VALUES (?,?,?,?);";
    private final String SELECT_ALL_CANDIDATE = "SELECT full_name FROM candidate;";
    private final String SELECT_FROM_CANDIDATE = "SELECT * FROM candidate;";
    private final String SELECT_INTERN = "SELECT * FROM intern;";
    private final String SELECT_FRESHER = "SELECT * FROM fresher;";
    private final String SELECT_EXPERIENCE = "SELECT * FROM experience;";


    @Override
    public <T extends Candidate> T add(T candidate) {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(INSERT_CANDIDATE);
            ps.setInt(1, candidate.getCandidateID());
            ps.setString(2, candidate.getFullName());
            ps.setString(3, candidate.getBirthDay());
            ps.setString(4, candidate.getPhone());
            ps.setString(5, candidate.getEmail());
            ps.setInt(6, candidate.getCandidateType());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (candidate instanceof Experience) {
            Experience experience = (Experience) candidate;
            try {
                ps = connection.prepareStatement(INSERT_EXPERIENCE);
                ps.setInt(1, experience.getExpInYear());
                ps.setString(2, experience.getProSkill());
                ps.setInt(3, experience.getCandidateID());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (candidate instanceof Intern) {
            Intern intern = (Intern) candidate;
            try {
                ps = connection.prepareStatement(INSERT_INTERN);
                ps.setString(1, intern.getMajors());
                ps.setInt(2, intern.getSemester());
                ps.setString(3, intern.getUniversityName());
                ps.setInt(4, intern.getCandidateID());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (candidate instanceof Fresher) {
            Fresher fresher = (Fresher) candidate;
            try {
                ps = connection.prepareStatement(INSERT_FRESHER);
                ps.setString(1, fresher.getGraduationDate());
                ps.setString(2, fresher.getGraduationRank());
                ps.setString(3, fresher.getEducation());
                ps.setInt(4, fresher.getCandidateID());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public <T extends Candidate> List<T> getAll() {
        List<T> list = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EXPERIENCE);
            ResultSet resultSetE = preparedStatement.executeQuery();
            while (resultSetE.next()) {
                Experience experience = new Experience();
                experience.setCandidateID(resultSetE.getInt("id"));
                experience.setExpInYear(resultSetE.getInt("exp_in_year"));
                experience.setProSkill(resultSetE.getString("pro_skill"));
                setAttributeCandidate(experience);
                list.add((T) experience);
            }

            PreparedStatement preparedStatementF = connection.prepareStatement(SELECT_FRESHER);
            ResultSet resultF = preparedStatementF.executeQuery();
            while (resultF.next()) {
                Fresher fresher = new Fresher();
                fresher.setCandidateID(resultF.getInt("id"));
                fresher.setGraduationDate(resultF.getString("graduation_date"));
                fresher.setGraduationRank(resultF.getString("graduation_rank"));
                fresher.setEducation(resultF.getString("education"));
                setAttributeCandidate(fresher);
                list.add((T) fresher);
            }

            PreparedStatement preparedStatementI = connection.prepareStatement(SELECT_INTERN);
            ResultSet resultSetI = preparedStatementI.executeQuery();
            while (resultSetI.next()) {
                Intern intern = new Intern();
                int id = resultSetI.getInt("id");
                intern.setCandidateID(id);
                intern.setMajors(resultSetI.getString("majors"));
                intern.setSemester(resultSetI.getInt("semester"));
                intern.setUniversityName(resultSetI.getString("university_name"));
                setAttributeCandidate(intern);
                list.add((T) intern);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private <T extends Candidate> void setAttributeCandidate(T t) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM candidate where id ='" + t.getCandidateID() + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            t.setCandidateID(resultSet.getInt("id"));
            t.setFullName(resultSet.getString("full_name"));
            t.setBirthDay(resultSet.getString("birthday"));
            t.setPhone(resultSet.getString("phone"));
            t.setEmail(resultSet.getString("email"));
            t.setCandidateType(resultSet.getInt("candidate_type"));

        }
    }

    @Override
    public List<String> getAllNameCandidate() {
        List<String> candidateList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CANDIDATE)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String fullName = rs.getString("full_name");
                candidateList.add(fullName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidateList;
    }

    @Override
    public void updateCandidate(int idSearch, int caseFunction) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(SELECT_FROM_CANDIDATE);
            resultSet.beforeFirst();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                if (idSearch == id) {
                    if (caseFunction == 1) {
                        System.out.println("Nhập họ tên mới ");
                        String newFullName = new Scanner(System.in).nextLine();
                        resultSet.updateString("full_name", newFullName);
                    } else if (caseFunction == 2) {
                        System.out.println("Nhập số điện thoại mới");
                        String newPhone = new Scanner(System.in).nextLine();
                        resultSet.updateString("phone", newPhone);
                    } else {
                        System.out.println("Không có chức năng update này ");
                    }
                    resultSet.updateRow();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void sortCandidate(List<Candidate> list) {
        Collections.sort(list, new Comparator<Candidate>() {
            @Override
            public int compare(Candidate o1, Candidate o2) {
                if (o1.getCandidateType() == o2.getCandidateType()) {
                    return Integer.parseInt(o2.getBirthDay().substring(0, 4)) - Integer.parseInt(o1.getBirthDay().substring(0, 4));
                }
                return o1.getCandidateType() - o2.getCandidateType();
            }
        });
    }
}
