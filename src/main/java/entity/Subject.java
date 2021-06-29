package entity;

import javax.persistence.*;

@Entity
public class Subject {
    @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long subjectId;
    private String subjectName;
    private Integer subjectScore;


    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "examId", unique = true)
private Exams exams;

    public Exams getExams() {
        return exams;
    }

    public void setExams(Exams exams) {
        this.exams = exams;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getSubjectScore() {
        return subjectScore;
    }

    public void setSubjectScore(Integer subjectScore) {
        this.subjectScore = subjectScore;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectScore=" + subjectScore +
                '}';
    }
}
