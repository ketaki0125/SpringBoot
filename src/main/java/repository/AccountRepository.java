package repository;

import dto.SubjectDTO;
import entity.Subject;
import exception.InfyException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Subject, Long> {
    public List<SubjectDTO> getAllSubjects () throws InfyException;
    public SubjectDTO getSubject(long subjectId) throws InfyException;
    public long addSubject(SubjectDTO subject) throws InfyException;
    public void updateSubject(long subjectId, String subjectName, Integer subjectScore) throws InfyException;
    public void deleteSubject(long subjectId) throws InfyException;
}
