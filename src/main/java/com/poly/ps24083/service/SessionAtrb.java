package com.poly.ps24083.service;

import java.nio.file.Files;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SessionAtrb {
	public static final String Current_User = "currentUser";

	public static String getNameGenre(Integer id) {
		switch (id) {
		case 1:
			return "Phim Hành Động";
		case 2:
			return "Phim Tình Cảm";
		case 3:
			return "Phim Kinh Dị";
		case 4:
			return "Phim Khoa Học Viễn Tưởng";
		case 5:
			return "Phim Hoạt Hình";
		}
		return "Chưa Có Thể Loại";
	}

//	public static String writeFileImg(HttpServletRequest request, String partName) {
//	    try {
//	        int randomNumber = (int) (Math.random() * 500);
//	        String realPath = request.getServletContext().getRealPath("/images");
//	        Path path = Paths.get(realPath);
//	        
//	        // Tạo thư mục nếu chưa tồn tại
//	        if (!Files.exists(path)) {
//	            Files.createDirectories(path);
//	        }
//	        
//	        // Lấy phần file ảnh từ request
//	        Part photo = request.getPart(partName);
//	        if (photo != null) {
//	            String filename = photo.getSubmittedFileName();
//	            if (filename != null && !filename.isEmpty()) {
//	                // Đảm bảo có thể tách tên file và phần mở rộng
//	                int dotIndex = filename.lastIndexOf('.');
//	                if (dotIndex > 0 && dotIndex < filename.length() - 1) {
//	                    String baseName = filename.substring(0, dotIndex);
//	                    String extension = filename.substring(dotIndex + 1);
//	                    String writeFilename = baseName + randomNumber + "." + extension;
//	                    photo.write(realPath + "/" + writeFilename);
//	                    System.out.println(writeFilename);
//	                    return writeFilename;
//	                }
//	            }
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	        return null;
//	    }
//	    return null;
//	}
}

