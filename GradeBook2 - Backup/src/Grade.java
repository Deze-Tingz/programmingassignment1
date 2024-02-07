/*
Description: Keeps a single grade in the form of both score (from 0 to 100) and
letter grade (A, A-, ..., F). The assumption is that the letter-grade cut-off points are
the same as you see in the course syllabus.
*/

public class Grade {
    private int score;
    private String letterGrade;

    public Grade() {
        // Optional: Initialize with default values if required
    }

    public int getScore() {
        return score;
    }

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setScore(int score) {
        this.score = score;
        this.letterGrade = determineLetterGrade(score); // Update letter grade based on the score
    }

    private String determineLetterGrade(int score) {
        if (score >= 95) {
            return "A";
        } else if (score >= 90) {
            return "A-";
        } else if (score >= 87) {
            return "B+";
        } else if (score >= 83) {
            return "B";
        } else if (score >= 80) {
            return "B-";
        } else if (score >= 77) {
            return "C+";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
