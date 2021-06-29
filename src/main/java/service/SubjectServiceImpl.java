package service;

import dto.ExamsDTO;
import dto.SubjectDTO;
import entity.Exams;
import entity.Subject;
import exception.InfyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 @Service(value="subjectService")
 @Transactional
public class SubjectServiceImpl implements SubjectService{

     @Autowired
     public AccountRepository repo;

    @Override
    public List<SubjectDTO> getAllSubjects () throws InfyException{
    Iterable<Subject> subjects = repo.findAll();
    List<SubjectDTO> subjs = new ArrayList<SubjectDTO>();
		subjects.forEach(subject -> {
       SubjectDTO sub =new SubjectDTO();
        sub.setSubjectId(subject.getSubjectId());
        sub.setSubjectName(subject.getSubjectName());
        sub.setSubjectScore(subject.getSubjectScore());
        subjs.add(sub);
    });
		if (subjs.isEmpty())
                throw new InfyException("Service.SUBJECTS_NOT_FOUND");
		return subjs;
}

    public SubjectDTO getSubject(long subjectId) throws InfyException {
        Optional<Subject> optional = repo.findById(subjectId);
        Subject subject = optional.orElseThrow(() -> new InfyException("Service.SUBJECT_NOT_FOUND"));
        SubjectDTO subDTO = new SubjectDTO();
        subDTO.setSubjectId(subject.getSubjectId());
        subDTO.setSubjectScore(subject.getSubjectScore());
        subDTO.setSubjectName(subject.getSubjectName());
        ExamsDTO examdto= new ExamsDTO();
        examdto.setExamId(subject.getExams().getExamId());
        examdto.setExamDate(subject.getExams().getExamDate());
    //    examdto.setExamTime(subject.getExams().getExamTime());
        subDTO.setExamsDTO(examdto);
        return subDTO;
    }

    public long addSubject(SubjectDTO subject) throws InfyException {
       Subject sub = new Subject();
      sub.setSubjectId(subject.getSubjectId());
      sub.setSubjectName(subject.getSubjectName());
      sub.setSubjectScore(subject.getSubjectScore());
        Exams exam = new Exams();
        exam.setExamId(subject.getExamsDTO().getExamId());
      exam.setExamDate(subject.getExamsDTO().getExamDate());
     // exam.setExamTime(subject.getExamsDTO().getExamTime());
      sub.setExams(exam);
         repo.save(sub);
        return sub.getSubjectId();
    }

    public void updateSubject(long subjectId, String subjectName, Integer subjectScore) throws InfyException {
        Optional<Subject> sub = repo.findById(subjectId);
        Subject s1 = sub.orElseThrow(() -> new InfyException("Service.SUBJECT_NOT_FOUND"));
        s1.setSubjectName(subjectName);
        s1.setSubjectScore(subjectScore);
    }

    public void deleteSubject(long subjectId) throws InfyException {
        Optional<Subject> subject = repo.findById(subjectId);
        subject.orElseThrow(() -> new InfyException("Service.SUBJECT_NOT_FOUND"));
        repo.deleteById(subjectId);
    }
//    @Override
//    public void deleteSubjectOnly(long subjectId) throws InfyException{
//        Optional<Subject> sub = repo.findById(subjectId);
//        Subject s1 = sub.orElseThrow(() -> new InfyException("Service.SUBJECT_NOT_FOUND"));
//s1.setExams(null);
//repo.delete(s1);
//
//    }

}
