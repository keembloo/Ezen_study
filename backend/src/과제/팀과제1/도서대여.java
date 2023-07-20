package 과제.팀과제1;

import java.util.Arrays;
import java.util.Scanner;

import javax.print.attribute.SetOfIntegerSyntax;

public class 도서대여 {	// class s
	public static void main(String[] args) {	//main s
		  Scanner scanner = new Scanner(System.in);
		  
	      String[] bookList = new String[100]; // 대여리스트
	      int[] bookState = new int[100];   // 1 : 대여가능 , 2: 대여중
	
	      int total = 0;
	      int available =0;
	      
          while(true){
              System.out.println("--------------------------------------------------------");
              System.out.println("1.도서등록 | 2.도서목록 | 3.대여 | 4.반납 | 5.도서수정 | 6.도서삭제");
              System.out.println("--------------------------------------------------------");
              int ch = scanner.nextInt();
              
              if (ch ==1) { // 도서등록
                  System.out.println("등록할 도서명을 작성해주세요");
                  scanner.nextLine();
                  String addBook = scanner.nextLine();
                  System.out.println("입력한 도서명 : "+addBook);
                  for (int i =0; i<bookList.length; i++) { //배열내 null찾기
                     if (bookList[i] == null) {
                        bookList[i] = addBook;
                        bookState[i] = 1; // 0 -> 1 대여가능으로 변환
                        //System.out.println(bookList[i]); 확인용
                       // System.out.println(bookState[i]); 확인용
                        break;
                     } // if end
                  } // for end
               } 
              
              else if (ch ==2) { // 도서목록
                  System.out.printf("%s\t\t%s\t\t %s\n" ,"순번", "도서목록" ,"대여상태");
                  for (int i=0; i<bookList.length; i++) {
                     if (bookList[i] != null) {
                        total++; // 도서 총 수량계산
                        if (bookState[i] == 1) {
                        System.out.printf("%d\t\t%s\t\t %s\n" ,i+1, bookList[i] ,"대여가능" );
                           available++; // 대여가능한 도서 수량
                        } else if (bookState[i] == 2) {
                           System.out.printf("%d\t\t%s\t\t %s\n" ,i+1, bookList[i] ,"대여불가" );
                        }
                     } // if 1 end
                  } // for end
                  System.out.println("----------------------------");
                  System.out.println("보유하고 있는 도서 총수량 :"+total);
                  total = 0;
                  System.out.println("대여가능한 도서 수량 :"+available);
                  available = 0;
               } 
              
              else if(ch == 3) {   // 대여 if s
                  
                  // 도서목록 출력
                  for (int i=0; i<bookList.length; i++) {
                     if (bookList[i] != null) {
                           if (bookState[i] == 1) {
                           System.out.printf("%d\t\t%s\t\t %s\n" ,i+1, bookList[i] ,"대여가능" );
                           } else if (bookState[i] == 2) {
                              System.out.printf("%d\t\t%s\t\t %s\n" ,i+1, bookList[i] ,"대여불가" );
                           }
                     }
                  }
                  
                  
                  System.out.printf("대여하실 책 번호를 입력해주세요(1~100) >>> ");
                  int bookCh = scanner.nextInt();
                  // 잘못된 책 번호를 입력하면 반복문 재시작
                  if(bookCh >100 || bookCh < 1) {
                     System.out.println("1~100사이의 번호를 입력해주세요.");
                     continue;
                  }
                  if(bookState[bookCh - 1] == 1) {   // 책번호의 상태가 1(대여가능)이면 실행
                     System.out.println("대여하실 책은 " + bookList[bookCh - 1] + "입니다.");
                     System.out.println("정말로 대여하시겠습니까? [1.확인 2.취소]");
                     System.out.printf("입력 >>> ");
                     ch = scanner.nextInt();
                     if(ch == 1) {
                        // 대여완료후 책상태를 2(대여중)으로 변경
                        bookState[bookCh - 1] = 2;
                        System.out.println("대여가 완료되었습니다.");
                     }else {
                        System.out.println("취소되었습니다.");
                     }
                  }else if(bookState[bookCh - 1] == 2) {
                     System.out.println("이미 대여중인 책입니다.");
                  }else {
                     System.out.println("존재하지않는 번호입니다.");
                  }
               } // 대여 if end
              
               else if(ch == 4) {   // 반납 if s
                  
                 // 도서목록 출력
                  for (int i=0; i<bookList.length; i++) {
                     if (bookList[i] != null) {
                           if (bookState[i] == 1) {
                           System.out.printf("%d\t\t%s\t\t %s\n" ,i+1, bookList[i] ,"대여가능" );
                           } else if (bookState[i] == 2) {
                              System.out.printf("%d\t\t%s\t\t %s\n" ,i+1, bookList[i] ,"반납대상" );
                           }
                     }
                  }
                  
                  
                  System.out.printf("반납하실 책 번호를 입력해주세요(1~100) >>> ");
                  int bookCh = scanner.nextInt();
                  // 잘못된 책 번호를 입력하면 반복문 재시작
                  if(bookCh >100 || bookCh < 1) {
                     System.out.println("1~100사이의 번호를 입력해주세요.");
                     continue;
                  }
                  if(bookState[bookCh - 1] == 2) {   // 책번호의 상태가 2(대여중)이면 실행
                     System.out.println("반납하실 책은 " + bookList[bookCh - 1] + "입니다.");
                     System.out.println("정말로 반납하시겠습니까? [1.확인 2.취소]");
                     System.out.printf("입력 >>> ");
                     ch = scanner.nextInt();
                     if(ch == 1) {
                        // 반납이 완료되면 책상태를 1(대여가능)으로 변경
                        bookState[bookCh - 1] = 1;
                        System.out.println("반납이 완료되었습니다.");
                     }else {
                        System.out.println("취소되었습니다.");
                     }
                  }else if(bookState[bookCh - 1] == 1) {
                     System.out.println("대여중인 책이 아닙니다.");
                  }else {
                     System.out.println("존재하지않는 번호입니다.");
                  }
               }
               
               else if(ch==5) {
                 System.out.println("--------------------------------------------------------");
                 System.out.println("순번\t도서목록");
                 System.out.println("--------------------------------------------------------");
                 for(int i=1; i<=bookList.length; i++) {
                    
                    if(bookList[i-1]==null) {
                       // 도서리스트에 값이 없으면 공백출력
                       System.out.print("");
                    } else {
                       System.out.println(i+"\t"+bookList[i-1]);
                    }
                 }
                 System.out.println("수정할 도서의 순번을 입력해주세요");
                 
                 int changeBookNumber = scanner.nextInt();
                 if(changeBookNumber > bookList.length) {
                    // 입력값이 도서리스트 배열의 범위를 넘어갈 시 에러방지
                    System.out.println("해당 순번의 도서는 등재되어있지 않습니다");
                 } else if(bookList[changeBookNumber-1]==null) {
                    // 입력한 도서리스트에 값이 없을 시 "null"출력 방지
                    System.out.println("해당 순번의 도서는 등재되어있지 않습니다");
                 } else if( bookState[changeBookNumber-1] == 2) {
                    // 입력한 도서리스트에 도서가 대여중일 시 수정금지
                    System.out.println("해당 순번의 도서는 대여중입니다");
                 } else {
                    
                    // 도서리스트 출력
                    System.out.println("수정도서\t"+bookList[changeBookNumber-1]);
                    System.out.println("수정할 도서의 이름을 기입해주세요");
                    // 개행버림
                    scanner.nextLine();
                    // 수정할 도서의 새 이름을 입력
                    bookList[changeBookNumber-1] = scanner.nextLine();
                    System.out.println("수정완료되었습니다");
                 }
                 
              
               }
               
               else if(ch==6) {
                 System.out.println("--------------------------------------------------------");
                 System.out.println("순번\t도서목록");
                 System.out.println("--------------------------------------------------------");
                 for(int i=1; i<=bookList.length; i++) {
                    
                    if(bookList[i-1]==null) {
                       // 도서리스트에 값이 없으면 공백출력
                       System.out.print("");
                    } else {
                       System.out.println(i+"\t"+bookList[i-1]);
                    }
                 }
                 System.out.println("수정할 도서의 순번을 입력해주세요");
                 
                 int deleteBookNumber = scanner.nextInt();
                 if(deleteBookNumber > bookList.length) {
                    // 입력값이 도서리스트 배열의 범위를 넘어갈 시 에러방지
                    System.out.println("해당 순번의 도서는 등재되어있지 않습니다");
                 } else if(bookList[deleteBookNumber-1]==null) {
                    // 입력한 도서리스트에 값이 없을 시 "null"출력 방지
                    System.out.println("해당 순번의 도서는 등재되어있지 않습니다");
                 } else if( bookState[deleteBookNumber-1] == 2) {
                    // 입력한 도서리스트에 도서가 대여중일 시 수정금지
                    System.out.println("해당 순번의 도서는 대여중입니다");
                 } else {
                    String[] arr = new String[bookList.length]; 
                    
                    //삭제할 순번 기준 뒤에 있는 도서목록으로 값을 모두 초기화
                    for(int i=deleteBookNumber; i<bookList.length; i++) {
                       arr[i-1] = bookList[i];
                    }
                    for(int i=deleteBookNumber-1; i<bookList.length; i++) {
                       bookList[i] = arr[i];
                    }
                    
                    System.out.println("삭제완료되었습니다");
                    
                 }
              }
        }	//while end
  } // main end
} // class end