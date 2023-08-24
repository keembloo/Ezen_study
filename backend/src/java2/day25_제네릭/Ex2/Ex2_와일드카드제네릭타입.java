package java2.day25_제네릭.Ex2;

public class Ex2_와일드카드제네릭타입 {
	public static void main(String[] args) {
		
			// 1. 사람객체
		Person person = new Person();
			// 2. 지원자 객체 [ 지원자 객체에 사람 객체를 생성자 대입 ]
		Applicant<Person> applicant = new Applicant<Person>(person);
			// 3. 모든 객체가 지원 가능한 코스 등록 함수
		Course.registerCourse1(applicant);
		Course.registerCourse1(new Applicant<Person>(new Person()));
		
		
		// 1. 모든 사람(사람,직장인,학생,고등학생,중학생)이 신청 가능
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();
		
		// 2. 학생만 신청 가능
			//Applicant<? extends Student > applicant
			// 지원서 중에 Student 객체와 Student 자손객체만 가능 [ Person , worker 불가능 ]
		//Course.registerCourse2(new Applicant<Person>(new Person()));
		//Course.registerCourse2(new Applicant<Worker>(new Worker())
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println();
		
		// 3. 직장인 및 일반인만 신청 가능
			// Applicant<? super Worker > applicant
			// 지원서 객체 중에 Worker 객체와 Worker 부모객체만 가능 [ Student, HighStudent , MiddleStudent ] 
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
		//Course.registerCourse3(new Applicant<Student>(new Student()));
		//Course.registerCourse3(new Applicant<HighStudent>(new HighStudent()));
		//Course.registerCourse3(new Applicant<MiddleStudent>(new MiddleStudent()));
	}
}
