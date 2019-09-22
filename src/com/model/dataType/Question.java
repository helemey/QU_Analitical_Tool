package com.model.dataType;

import com.model.Constants;

public class Question {
    private String questionTypeId;
    private String categoryId;
    private String subcategoryId;


    public void setQuestion(String questionTypeId, String categoryId, String subcategoryId) {
        this.questionTypeId = questionTypeId;
        this.categoryId = categoryId;
        this.subcategoryId = subcategoryId;
    }

    public void setQuestion(String questionTypeId, String categoryId) {
        setQuestion(questionTypeId, categoryId, null);
    }

    public void setQuestion(String questionTypeId) {
        setQuestion(questionTypeId, null, null);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Question question = (Question) object;

        if (!questionTypeId.equals(question.questionTypeId)) {
            return false;
        }
        if (categoryId == null) return true;
        return categoryId.equals(question.categoryId) && subcategoryId == null
                || subcategoryId.equals(question.subcategoryId);
    }

    @Override
    public int hashCode() {
        int result = questionTypeId.hashCode();
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (subcategoryId != null ? subcategoryId.hashCode() : 0);
        return result;
    }

    public boolean isQuestionEquals(Question line) {
        return (this.questionTypeId.equals(Constants.SPECIAL_VALUE) || this.equals(line));
    }
}
