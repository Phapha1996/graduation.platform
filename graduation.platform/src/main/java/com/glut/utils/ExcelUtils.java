package com.glut.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.glut.domain.Major;
import com.glut.domain.Student;

/**
 * 
 * @author Caizhf
 * @date 2017年11月10日下午7:58:43
 * @version v.0.1
 * @email Caizhfy@163.com
 *
 *        <p>
 * 		Description: 读取excel文件所需方法
 * 		请注意，excel格式从左到右必须为：用户名，密码，名字，班级，联系方式，专业
 *        </p>
 *
 *
 */
public class ExcelUtils {
	// 总行数
	private int totalRows = 0;
	// 总条数
	private int totalCells = 0;
	// 错误信息接收器
	private String errorMsg;

	// 构造方法
	public ExcelUtils() {
		super();
	}

	// 获取总行数
	public int getTotalRows() {
		return totalRows;
	}

	// 获取总列数
	public int getTotalCells() {
		return totalCells;
	}

	// 获取错误信息
	public String getErrorInfo() {
		return errorMsg;
	}

	/**
	 * 读EXCEL文件，获取信息集合
	 * 
	 * @param fielName
	 * @param isStudent
	 *            是否学生excel，有可能是传入老师的excel
	 * @return
	 */
	public List getExcelInfo(MultipartFile mFile, boolean isStudent) {
		String fileName = mFile.getOriginalFilename();// 获取文件名
		List userList = null;
		try {
			if (!validateExcel(fileName)) {// 验证文件名是否合格
				return null;
			}
			boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
			if (isExcel2007(fileName)) {
				isExcel2003 = false;
			}
			userList = createExcel(mFile.getInputStream(), isExcel2003, isStudent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * 根据excel里面的内容读取客户信息
	 * 
	 * @param is
	 *            输入流
	 * @param isExcel2003
	 *            excel是2003还是2007版本
	 * @return
	 * @throws IOException
	 */
	public List createExcel(InputStream is, boolean isExcel2003, boolean isStudent) {
		List userList = null;
		try {
			Workbook wb = null;
			if (isExcel2003) {// 当excel是2003时,创建excel2003
				wb = new HSSFWorkbook(is);
			} else {// 当excel是2007时,创建excel2007
				wb = new XSSFWorkbook(is);
			}
			userList = readExcelValue(wb, isStudent);// 读取Excel里面客户的信息
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * 读取Excel里面客户的信息
	 * 
	 * @param wb
	 * @return
	 */
	private List readExcelValue(Workbook wb, boolean isStudent) {

		// 得到第一个shell
		Sheet sheet = wb.getSheetAt(0);
		// 得到Excel的行数
		this.totalRows = sheet.getPhysicalNumberOfRows();
		// 得到Excel的列数(前提是有行数)
		if (totalRows > 1 && sheet.getRow(0) != null) {
			this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
		}
		List userList = new ArrayList();
		HSSFDataFormatter dataFormatter = new HSSFDataFormatter();
		// 循环Excel行数
		for (int r = 1; r < totalRows; r++) {
			Row row = sheet.getRow(r);
			if (row == null) {
				continue;
			}
			if (isStudent) {
				Student student = new Student();
				// 循环Excel的列
				for (int c = 0; c < this.totalCells; c++) {
					Cell cell = row.getCell(c);
					if (null != cell) {
						if (c == 0) {
							// 如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String username = dataFormatter.formatCellValue(cell);
								student.setUsername(username);
							} else {
								student.setUsername(cell.getStringCellValue());// 用户名
							}
						} else if (c == 1) {
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String password = dataFormatter.formatCellValue(cell);
								student.setPassword(password);// 密码
							} else {
								student.setPassword(cell.getStringCellValue());// 密码
							}
						} else if (c == 2) {
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String name = dataFormatter.formatCellValue(cell);//名字
								student.setName(name);
							} else {
								student.setName(cell.getStringCellValue());// 名字
							}
						} else if (c == 3) {
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String sclass = dataFormatter.formatCellValue(cell);
								student.setSclass(sclass);
							} else {
								student.setSclass(cell.getStringCellValue());// 班级
							}
						} else if (c == 4) {
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String contact = dataFormatter.formatCellValue(cell);// 联系方式
								student.setContact(contact);
							} else {
								student.setContact(cell.getStringCellValue());// 联系方式
							}
						}else if (c == 5) {
							if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
								String majorName = dataFormatter.formatCellValue(cell);// 专业
								student.setMajor(new Major(majorName));
							} else {
								student.setMajor(new Major(cell.getStringCellValue()));
							}
						}
					}
				}
				// 添加到list
				userList.add(student);
			} else {
				//写入老师装载的逻辑
			}
		}
		return userList;
	}

	/**
	 * 验证EXCEL文件
	 * 
	 * @param filePath
	 * @return
	 */
	public boolean validateExcel(String filePath) {
		if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
			errorMsg = "文件名不是excel格式";
			return false;
		}
		return true;
	}

	// @描述：是否是2003的excel，返回true是2003
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	// @描述：是否是2007的excel，返回true是2007
	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}
}
