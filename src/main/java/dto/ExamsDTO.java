package dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExamsDTO {
    private Integer examId;
    // @NotNull
    private LocalDate examDate;

  //  private LocalTime examTime;

    public Integer getExamId() {
        return examId;
    }

    public void setExamId(Integer examId) {
        this.examId = examId;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

//    public LocalTime getExamTime() {
//        return examTime;
//    }
//
//    public void setExamTime(LocalTime examTime) {
//        this.examTime = examTime;
//    }
//
//    @Override
//    public String toString() {
//        return "ExamsDTO{" +
//                "examId=" + examId +
//                ", examDate=" + examDate +
//                ", examTime=" + examTime +
//                '}';
//    }

    @Override
    public String toString() {
        return "ExamsDTO{" +
                "examId=" + examId +
                ", examDate=" + examDate +
                '}';
    }
}
