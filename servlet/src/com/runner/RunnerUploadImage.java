package com.runner;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet("/RunnerUploadImage")
public class RunnerUploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletFileUpload upload;
	private final long MAXSize = 4194304 * 2L;// 4*2MB
	private String filedir;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RunnerUploadImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 设置文件上传的初始化信息
	 * 
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();
		// Create a new file upload handler
		this.upload = new ServletFileUpload(factory);
		// Set overall request size constraint 4194304
		this.upload.setSizeMax(this.MAXSize);
		// File file = new File(pathname);
		filedir = config.getServletContext().getRealPath("runnerImages");
		System.out.println(filedir);
		File file = new File(filedir);
		if (!file.exists()) {
			// 创建临时目录
			file.mkdir();
		}
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println(request.getMethod());
		String runnerId=request.getParameter("runnerId");
		System.out.println(runnerId);
		//创建商户目录
		File runnerfile=new File(filedir+"\\"+runnerId);
		if (!runnerfile.exists()) {
			runnerfile.mkdir();
		}
		PrintWriter out = response.getWriter();
		try {
			List<FileItem> items = this.upload.parseRequest(request);
			if (items != null && !items.isEmpty()) {
				for (FileItem fileItem : items) {

					System.out.println(fileItem);

					String filename = fileItem.getName();
					String filepath = filedir +"\\"+runnerId +File.separator + filename;

					
					System.out.println("文件保存路径为:" + filepath);

					File file = new File(filepath);
					InputStream inputSteam = fileItem.getInputStream();
					BufferedInputStream fis = new BufferedInputStream(inputSteam);
					FileOutputStream fos = new FileOutputStream(file);
					int f;
					while ((f = fis.read()) != -1) {
						fos.write(f);
					}
					fos.flush();
					fos.close();
					fis.close();
					inputSteam.close();
					System.out.println("文件：" + filename + "上传成功!");
				}
			}
			System.out.println("上传文件成功!");
			out.write("上传文件成功!");
		} catch (FileUploadException e) {
			e.printStackTrace();
			out.write("上传文件失败:" + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
