package com.poly.ps24083.service;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

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

	public static String writeFileImg(HttpServletRequest request, String path) {
		try {
			int randomNumber = (int) (Math.random() * 500);
			String realpath = request.getServletContext().getRealPath("/images");
			if (!Files.exists(Paths.get(realpath))) {
				Files.createDirectory(Paths.get(realpath));
			}
			Part photo = request.getPart(path);
			if (photo != null) {
				String filename = photo.getSubmittedFileName();
				if (filename != null && !filename.isEmpty()) {
					String[] line = filename.split("\\.");
					String writeFilename = line[0] + randomNumber +"."+ line[1];
					photo.write(realpath + "/" + writeFilename);
					System.out.println(writeFilename);
					return writeFilename;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
}
