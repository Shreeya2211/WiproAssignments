package springprograms;

//bean class
public class Student_Course extends Student //2+2=4 One bean inheriting another bean 
{
	int courseid;
	String coursename;
	public int getCourseid() {
		return courseid;
	}
	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

}
