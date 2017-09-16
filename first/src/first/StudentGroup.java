package first;
import java.util.Arrays;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		if(students.length==0)
		return null;
		else
			return Arrays.copyOf(students,students.length);
	}

	@Override
	public void setStudents(Student[] students) {
	this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		
		return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		this.students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		
		int i=this.students.length;
		for(int j=i;j>0;j--)
			this.students[j]=this.students[j-1];
		    this.students[0]=student;
		    this.students[i+1]=null;
	}

	@Override
	public void addLast(Student student) {
		
		int i=this.students.length;
		this.students[i]=student;
		this.students[i+1]=null;
	}

	@Override
	public void add(Student student, int index) {
		
		int i=this.students.length;
		for(int j=i;j>index;j--)
			this.students[j]=this.students[j-1];
		    this.students[index]=student;
		    this.students[i+1]=null;
	}

	@Override
	public void remove(int index) {
		
		int i=this.students.length;
		for(int j=index;j<i;j++)
			this.students[j]=this.students[j+1];
		    this.students[i+1]=null;
	}

	@Override
	public void remove(Student student) {
		
		int i=this.students.length;
		int index=0;
		 for(int j=0;j<i;j++)
				if(this.students[j].equals(student))
				{
			    index=j;
				break;
				}
				for(int j=index;j<i;j++)
				this.students[j]=this.students[j+1];
				this.students[i+1]=null;
	}

	@Override
	public void removeFromIndex(int index) {
	
		int i=this.students.length;
		this.students[index]=this.students[i];
		this.students[index]=null;
	}

	@Override
	public void removeFromElement(Student student) {
		int i=this.students.length;
		int index=0;
             for(int j=0;j<i;j++)
		if((this.students[j]).equals(student))
		{
		index=j;
		break;
        }
		
		this.students[index]=null;
	}

	@Override
	public void removeToIndex(int index) {
		int j=this.students.length;
		for(int i=0; i<= j-index;i++)
		this.students[i]=this.students[i+index+1];
		this.students[j+1]=null;
 
	}

	@Override
	public void removeToElement(Student student) {
		int i=this.students.length;
		int index=0;
             for(int j=0;j<i;j++)
		if((this.students[j]).equals(student))
		{
		index=j;
		break;
                }
		int j=this.students.length;
		for(i=0;i<=j-index;i++)
		this.students[i]=this.students[i+index+1];
		this.students[i+1]=null;
	
	}

	@Override
	public void bubbleSort() {
		int n=this.students.length;
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-i-1;j++)
				if((this.students[j]).compareTo(this.students[j+1])>0)
				{
                    Student student= new Student();
				    student=this.students[i];
				    this.students[i]=this.students[j];
		    		    this.students[j]=student;	
				}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		int count = 0;
		for(int i=0;i<students.length;i++)
			if(students[i].getBirthDate().equals(date))
				count++;
		Student temp[] = new Student[count];
		count = 0;
		for(int i=0;i<students.length;i++)
			if(students[i].getBirthDate().equals(date))
				temp[count++] = students[i];
		return temp;
	
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		double max = -1;
		for(int i=0;i<students.length;i++)
			if(max < students[i].getAvgMark())
				max = students[i].getAvgMark();
		
	     return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		int i=this.students.length;
		int index1=0;
             for(int j=0;j<i;j++)
		if((this.students[j]).equals(student))
		{
	    index1=j;
		break;
                }
        	return this.students[index1+1];
	
	}
}

