package BUS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.ThanhVienDAO;
import DTO.ThanhVien;

public class ThanhVienBUS {
    static ArrayList<ThanhVien> listTV;
    ThanhVienDAO dao;

    public ArrayList<ThanhVien> getData()
    {
        dao= new ThanhVienDAO();
        listTV=dao.getData();
        return listTV;
    }

    public void addThanhVien(ThanhVien tv)
    {
        dao=new ThanhVienDAO();
        dao.addThanhVien(tv);
    }

    public Boolean delThanhVien(int ID)
    {
        dao= new ThanhVienDAO();
        if( dao.delThanhVien(ID)) return true;
        return false;
        
    }

    public Boolean delThanhVienByField(String fieldName, String value)
    {
        dao= new ThanhVienDAO();
        if(dao.delThanhVienByField(fieldName, value)) return true;
        return false;
    }

    public Boolean updateThanhVien(int ID,ThanhVien tv)
    {
        dao= new ThanhVienDAO();
        if(dao.updateThanhVien(ID, tv))return true;
        return false;
    }

    public ThanhVien getThanhVienByID(int ID)
    {
        dao= new ThanhVienDAO();
        return dao.getThanhVienByID(ID);
    }
    public ArrayList<String> getDSKhoa(){
        HashSet<String> hashSet = new HashSet<>();
        for (ThanhVien tv:getData()){
            if (!hashSet.contains(tv.getKhoa())){
                hashSet.add(tv.getKhoa());
            }
        }
        return new ArrayList<>(hashSet);
    }
    public ArrayList<String> getDSNganh(){
        HashSet<String> hashSet = new HashSet<>();
        for (ThanhVien tv:getData()){
            if (!hashSet.contains(tv.getNganh())){
                hashSet.add(tv.getNganh());
            }
        }
        return new ArrayList<>(hashSet);
    }
    public String getNganhByID(int id){
        for (ThanhVien tv : getData()){
            if (tv.getMaTV() == id)
                return tv.getNganh();
        }
        return "";
    }
    public String getKhoaByID(int id){
        for (ThanhVien tv : getData()){
            if (tv.getMaTV() == id)
                return tv.getKhoa();
        }
        return "";
    }
    public String getTenByID(int id){
        for (ThanhVien tv : getData()){
            if (tv.getMaTV() == id)
                return tv.getHoTen();
        }
        return "";
    }
    //ghi 1 arraylist vô file excel
    public void writeExcel(ArrayList<ThanhVien> listTVNew, String excelFilePath) throws IOException 
    {
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet();
        createHeaderRow(sheet);
    int rowCount = 0;
 
    for (ThanhVien tv : listTVNew) {
        Row row = sheet.createRow(++rowCount);
        writeBook(tv, row);
    }

    for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
        sheet.autoSizeColumn(i);
    }
 
    try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
        workbook.write(outputStream);
    }
}
    
private void writeBook(ThanhVien tv, Row row) {
    Cell cell = row.createCell(1);
    cell.setCellValue(tv.getMaTV());
 
    cell = row.createCell(2);
    cell.setCellValue(tv.getHoTen());
 
    cell = row.createCell(3);
    cell.setCellValue(tv.getKhoa());

    cell = row.createCell(4);
    cell.setCellValue(tv.getNganh());
 
    cell = row.createCell(5);
    cell.setCellValue(tv.getSdt());

    cell = row.createCell(6);
    cell.setCellValue(tv.getPassword());

    cell = row.createCell(7);
    cell.setCellValue(tv.getEmail());
}

public void createHeaderRow(Sheet sheet) {
 
    CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
    Font font = sheet.getWorkbook().createFont();
    font.setFontHeightInPoints((short) 14);
    cellStyle.setAlignment(HorizontalAlignment.CENTER);
    cellStyle.setFont(font);
 
    Row row = sheet.createRow(0);
    Cell cellTitle = row.createCell(1);
 
    cellTitle.setCellStyle(cellStyle);
    cellTitle.setCellValue("MaTV");
 
    Cell cellAuthor = row.createCell(2);
    cellAuthor.setCellStyle(cellStyle);
    cellAuthor.setCellValue("HoTen");
 
    Cell cellPrice = row.createCell(3);
    cellPrice.setCellStyle(cellStyle);
    cellPrice.setCellValue("Khoa");

    Cell cellNganh = row.createCell(4);
    cellNganh.setCellStyle(cellStyle);
    cellNganh.setCellValue("Nganh");
 
    Cell cellSDT = row.createCell(5);
    cellSDT.setCellStyle(cellStyle);
    cellSDT.setCellValue("SDT");

    Cell cellPassword = row.createCell(6);
    cellPassword.setCellStyle(cellStyle);
    cellPassword.setCellValue("Password");

    Cell cellEmail = row.createCell(7);
    cellEmail.setCellStyle(cellStyle);
    cellEmail.setCellValue("Email");
}

//đọc từ excel ra 1 arraylist
    public ArrayList<ThanhVien> ExcelReader(String excelFilePath) throws FileNotFoundException, IOException
    {
        ArrayList<ThanhVien> listTVNew = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(excelFilePath)) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                ThanhVien tv = new ThanhVien();

                tv.setMaTV((int)(currentRow.getCell(1).getNumericCellValue()));
                tv.setHoTen(currentRow.getCell(2).getStringCellValue());
                tv.setKhoa(currentRow.getCell(3).getStringCellValue());
                tv.setNganh(currentRow.getCell(4).getStringCellValue());
                tv.setSdt((currentRow.getCell(5).getStringCellValue()));
                tv.setPassword((currentRow.getCell(6).getStringCellValue()));
                tv.setEmail((currentRow.getCell(7).getStringCellValue()));
                listTVNew.add(tv);
            }
        }

        return listTVNew;
    }

    public String getNameByID(int id){
        String result = "";
        for (ThanhVien tv: getData()){
            if (id == tv.getMaTV()){
                result = tv.getHoTen();
                return result;
            }
        }
        return result;
    }
}

