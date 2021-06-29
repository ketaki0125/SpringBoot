package dto;



public class SubjectDTO {
    private long subjectId;
    private String subjectName;
    private Integer subjectScore;
//    @NotNull(message="{exam.schedule.abscent}") // "Exams are not scheduled for this subject."
//   @Valid
    private ExamsDTO examsDTO;

//    public SubjectDTO(long subjectId, String subjectName, Integer subjectScore) {
//        this.subjectId = subjectId;
//        this.subjectName = subjectName;
//        this.subjectScore = subjectScore;
//    }

    public ExamsDTO getExamsDTO() {
        return examsDTO;
    }

    public void setExamsDTO(ExamsDTO examsDTO) {
        this.examsDTO = examsDTO;
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
        return "SubjectDTO{" +
                "subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectScore=" + subjectScore +
                ", examsDTO=" + examsDTO +
                '}';
    }
}
