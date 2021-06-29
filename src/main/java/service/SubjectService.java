package service;

import dto.SubjectDTO;
import entity.Subject;
import exception.InfyException;

import java.util.List;

public interface SubjectService {

public List<SubjectDTO> getAllSubjects () throws InfyException;

public SubjectDTO getSubject (long subjectId) throws InfyException;

public long addSubject (SubjectDTO subject) throws InfyException;

public void updateSubject(long subjectId, String subjectName, Integer subjectScore) throws InfyException;

public void deleteSubject (long subjectId) throws InfyException;

  //  public void deleteSubjectOnly(long subjectId) throws InfyException;
}
