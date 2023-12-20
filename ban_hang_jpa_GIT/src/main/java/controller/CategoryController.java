package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import entity.Category;

@MultipartConfig
@WebServlet(urlPatterns= {"/listcate","/admin-Category-create", "/admin-Category-update", "/admin-Category-delete", "/admin-Category-reset"})
public class CategoryController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	private CategoryDAO cateDao;
	public CategoryController() {
        super();
        this.cateDao = new CategoryDAO();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		if (url.contains("listcate")) {
			this.findAll(req, resp);
		}else if(url.contains("create"))
		{//chỉ việc gọi view đã chạy, nhiệm vụ: lấy addCategory.jsp
			RequestDispatcher rd = req.getRequestDispatcher("/views/category/addCategory.jsp"); rd.forward(req, resp);
		}else if(url.contains("update"))
		{
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			//Nhan du lieu tu view
			int id = Integer.parseInt(req.getParameter("id"));
			
			//goi phuong thuc findOne trong service
			Category model = cateDao.findById(id);
			
			req.setAttribute("cate", model);
			RequestDispatcher rd = req.getRequestDispatcher("/views/category/updateCategory.jsp");
			rd.forward(req, resp);
		}else if (url.contains("delete"))
		{
			delete(req,resp);
		}
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url=req.getRequestURL().toString();
		if (url.contains("create")){
			try {
				insert(req,resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(url.contains("update"))
		{
			try {
				update(req,resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//thiết lập ngôn ngữ tiếng việt
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//nhận dữ liệu từ form
		int id=Integer.parseInt(req.getParameter("cateID"));
		String cateName =req.getParameter("cateName");
		String images = req.getParameter("images");
		
		Category cate = new Category();
		//cate.setCateID(cateID);
		cate.setCategoryID(id);
		cate.setCategoryName(cateName);
		cate.setIcon(images);
		//gọi phương thức insert trong service
		cateDao.update(cate);
		//trả về view
		//resp.sendRedirect(req.getContextPath()+"/HCMUTEArtifactId/listcate"); FIX KHI THAY MÁY KHÔNG THAY ĐƯỜNG DẪN NỮA
		resp.sendRedirect(req.getContextPath()+"/listcate");
		
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//Nhan du lieu tu view
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			//goi phuong thuc findOne trong service
			//thủ tục delete viết trong IDAO
			cateDao.delete(id);
			//đẩy dữ liệu view
			req.setAttribute("message", "Da xoa thanh cong\n");
		}catch(Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "That bai\n");
		}
		RequestDispatcher rd = req.getRequestDispatcher("/listcate");
		rd.forward(req, resp);
	}
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws Exception{
		//thiết lập ngôn ngữ tiếng việt
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//nhận dữ liệu từ view
		//Int cateID=req.getParameter("cateID").to
		//int id=Integer.parseInt(req.getParameter("cateID"));
		String cateName =req.getParameter("cateName");
		String images = req.getParameter("images");
		
		//khởi tạo model đưa vào dữ liệu
		Category cate = new Category();
		cate.setCategoryName(cateName);
		cate.setIcon(images);
		
		//gọi phương thức insert trong service
		cateDao.insert(cate);
		//trả về view
		//resp.sendRedirect(req.getContextPath()+"/HCMUTEArtifactId/listcate"); FIX KHI THAY MÁY KHÔNG THAY ĐƯỜNG DẪN NỮA
		resp.sendRedirect(req.getContextPath()+"/listcate");
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Category> listcate = cateDao.findAll();
		int tong = cateDao.count();
		req.setAttribute("tong", tong);
		//Chuyển dữ liệu ra view
		req.setAttribute("list", listcate);
		//View nào sẽ nhận dữ liệu
		RequestDispatcher rd = req.getRequestDispatcher("/views/category/listCategory.jsp");
		rd.forward(req, resp);
	}
}
