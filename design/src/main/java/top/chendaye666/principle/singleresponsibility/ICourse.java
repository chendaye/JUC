package top.chendaye666.principle.singleresponsibility;

/**
 * Created by geely
 */
public interface ICourse {
    String getCourseName();
    byte[] getCourseVideo();

    void studyCourse();
    void refundCourse();

}
