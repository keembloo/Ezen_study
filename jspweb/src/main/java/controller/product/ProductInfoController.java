package controller.product;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dto.ProductDto;


@WebServlet("/ProductInfoController")
public class ProductInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ProductInfoController() {
        super();
    }
    
    // 2. 제품 조회
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 1. 제품 등록 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// commons.jar 이용한 업로드 구현
		// commons-io.jar ,  commons-fileupload.jar 빌드 필요 !!
		
		// 1. 저장경로 [ 첨부파일이 저장될 폴더 위치 ]
		String uploadPath = request.getServletContext().getRealPath("/product/img");
		
		// 2. 파일 아이템 저장소 객체 : 업로드할 옵션 [ import org.apache.commons.fileupload.FileItem; ]
		DiskFileItemFactory itemFactory = new DiskFileItemFactory();
		itemFactory.setRepository(new File(uploadPath));	// 2.저장위치 file타입으로 변환
		itemFactory.setSizeThreshold(1024*1024*1024); // 3.용량
		itemFactory.setDefaultCharset("UTF-8"); // 4.한글인코딩
		
		// 3. 파일 업로드 객체 
		ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
		
		// 4. 파일 업로드 요청 [ 요청방식 : request ]
		try {
			Map< Integer , String > imgList = new HashMap<>();
						// form 전송시 input태그 모든 데이터 한번에 요청해서 결과를 List 반환
			List<FileItem> fileList =  fileUpload.parseRequest(request);
				// FileItem : 각 요청한 데이터 
			
			// 5. 업로드 실행
			int i=0;
			for(FileItem item : fileList ) { // 요청한 input들의 데이터를 반복문으로 하나씩 꺼내기 
				
				// 1. 일반필드 [ isFormField() : 만약에 일반폼필드이면 true / 아니고 첨부파일필드이면 false ] 
				if( item.isFormField() ) {
					System.out.println(item.getString()); // item.getString() : 해당 요청 input의 value 호출 
				} else {// 2. file 필드
					// 만약에 파일 필드이면 업로드 진행
					System.out.println("업로드할 파일명 : "+ item.getName()); // .getName()
					// 6.업로드 경로 + 파일명 [ 조합 ]
					File fileuploadPath = new File( uploadPath + "/"+item.getName());
					System.out.println("업로드경로와 파일명이 조합된 경로 : "+fileuploadPath);
					item.write(fileuploadPath); // .write("저장할경로[파일명포함]") 파일 업로드할 경로를 file타입으로 제공 
					
					// 7. 업로드된 파일명을 Map에 저장 [ -DB에 저장하려고]
					i++;
					imgList.put( i , item.getName()  ); // 저장시에는 이미지번호가 필요 없음
				}
			}
			ProductDto productDto = new ProductDto(
		               Integer.parseInt(fileList.get(0).getString()),
		               fileList.get(1).getString(),
		               fileList.get(2).getString(),
		               Integer.parseInt(fileList.get(3).getString()),
		               null,
		               null, 
		               0,
		               imgList
               );
			System.out.println( productDto );
		} catch (Exception e) {
			
		}
		
		
	}

	// 3. 제품 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// 4. 제품 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

/*
// -------------------------- 업로드 ----------------------------	
		MultipartRequest multi = new MultipartRequest(
				request,
				request.getServletContext().getRealPath("/product/img"),
				1024*1024*1024,
				"utf-8",
				new DefaultFileRenamePolicy()	);
		// ------------------------------------------------------------	
		String pcno = multi.getParameter("pcno");	
		String pname = multi.getParameter("pname");	
		String pcontent = multi.getParameter("pcontent");	
		int pprice = Integer.parseInt(multi.getParameter("pprice"));
			// * 만약에 첨부파일 2개 이상일때 파일명 여러개 호출
		Enumeration pimg = multi.getFileNames();
		System.out.println(pimg);
		System.out.println(pimg.nextElement());
			// .getFilesystemName("input name") : 첨부된 하나의 파일명 호출
			// .getFileNames() : 첨부된 input 태그들의 



	//[ form 태그 없는경우 1 ]  
	// 1. ajax 전달한 data의 객체 속성명을 이용한 호출 
	/*
	String pname1 = request.getParameter("pname1");
	String pcontent1 = request.getParameter("pcontent1");
		System.out.println( pname1 ) ; System.out.println( pcontent1 ) ;
	*/
	/*
	//[ form 태그 이용하는 경우 2 - form 전송시 ]
	MultipartRequest multi = new MultipartRequest(request , request.getServletContext().getRealPath("/product") );
	
	String pname2 = multi.getParameter("pname2");
	String pcontent2 = multi.getParameter("pcontent2");
		System.out.println( pname2 ) ; System.out.println( pcontent2) ;
	
*/
