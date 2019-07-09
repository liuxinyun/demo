package com.lxy.lambdademo.model;

/**
 * @author 刘新运
 * @date 2019/7/9 17:05
 */
public class LearningSchedule {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 课表id
     */
    private Integer courseId;

    /**
     * 学习路径id
     */
    private Integer learningSubjectId;

    /**
     * 学习路径节点id
     */
    private Integer lcNodeId;

    public LearningSchedule() {
    }

    public LearningSchedule(Integer userId, Integer courseId, Integer learningSubjectId, Integer lcNodeId) {
        this.userId = userId;
        this.courseId = courseId;
        this.learningSubjectId = learningSubjectId;
        this.lcNodeId = lcNodeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getLearningSubjectId() {
        return learningSubjectId;
    }

    public void setLearningSubjectId(Integer learningSubjectId) {
        this.learningSubjectId = learningSubjectId;
    }

    public Integer getLcNodeId() {
        return lcNodeId;
    }

    public void setLcNodeId(Integer lcNodeId) {
        this.lcNodeId = lcNodeId;
    }

    @Override
    public String toString() {
        return "LearningSchedule{" +
                "userId=" + userId +
                ", courseId=" + courseId +
                ", learningSubjectId=" + learningSubjectId +
                ", lcNodeId=" + lcNodeId +
                '}';
    }
}
