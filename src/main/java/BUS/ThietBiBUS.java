package BUS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import DAO.ThietBiDAO;
import DAO.ThongTinSDDAO;
import DTO.ThanhVien;
import DTO.ThietBi;
import DTO.ThongTinSD;

public class ThietBiBUS {
    static ArrayList<ThietBi> listTB;
    ThietBiDAO dao;

    public ArrayList<ThietBi> getData()
    {
        dao= new ThietBiDAO();
        listTB=dao.getData();
        return listTB;
    }

    public void addThietBi(ThietBi tb,String loaiTB,int year)
    {
        dao=new ThietBiDAO();
        loaiTB+=String.valueOf(year);
        dao.addThietBi(tb,loaiTB);
    }

    public void addThietBiEx(ThietBi tb)
    {
        dao= new ThietBiDAO();
        dao.addThietBiEx(tb);
    }

    public Boolean delThietBi(int ID)
    {
        dao= new ThietBiDAO();
        if( dao.delThietBi(ID)) return true;
        return false;
        
    }

    public Boolean delThietBiByField(String fieldName,String value)
    {
        dao= new ThietBiDAO();
        if(dao.delThietBiByField(fieldName,value))return true;
        return false;
    }

    public Boolean updateThietBi(int ID,ThietBi tb)
    {
        dao= new ThietBiDAO();
        if(dao.updateThietBi(ID, tb))return true;
        return false;
    }
    public String getNameByID(int id){
        String kq = "";
        for (ThietBi tb : listTB){
            if (tb.getMaTB() == id){
                return tb.getTenTB();
            }
        }
        return kq;
    }
    public ThietBi getThanhVienByID(int ID)
    {
        dao= new ThietBiDAO();
        return dao.geThietBiByID(ID);
    }

     public void writeExcel(ArrayList<ThietBi> listTBNew, String excelFilePath) throws IOException 
    {
    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet();
        createHeaderRow(sheet);
    int rowCount = 0;
 
    for (ThietBi tb : listTBNew) {
        Row row = sheet.createRow(++rowCount);
        writeBook(tb, row);
    }

    for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
        sheet.autoSizeColumn(i);
    }
 
    try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
        workbook.write(outputStream);
    }
}
    
private void writeBook(ThietBi tb, Row row) {
    Cell cell = row.createCell(1);
    cell.setCellValue(tb.getMaTB());
 
    cell = row.createCell(2);
    cell.setCellValue(tb.getTenTB());
 
    cell = row.createCell(3);
    cell.setCellValue(tb.getMoTa());

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
    cellTitle.setCellValue("MaTB");
 
    Cell cellAuthor = row.createCell(2);
    cellAuthor.setCellStyle(cellStyle);
    cellAuthor.setCellValue("TenTB");
 
    Cell cellPrice = row.createCell(3);
    cellPrice.setCellStyle(cellStyle);
    cellPrice.setCellValue("MoTaTB");

}

//đọc từ excel ra 1 arraylist
    public ArrayList<ThietBi> ExcelReader(String excelFilePath) throws FileNotFoundException, IOException
    {
        ArrayList<ThietBi> listTBNew = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(excelFilePath)) {
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                ThietBi tb = new ThietBi();
               tb.setMaTB((int)(currentRow.getCell(1).getNumericCellValue()));
                tb.setTenTB(currentRow.getCell(2).getStringCellValue());
                tb.setMoTa(currentRow.getCell(3).getStringCellValue());
               

                listTBNew.add(tb);
            }
        }

        return listTBNew;
    }

    public ArrayList<ThongTinSD>ThongKeByTime(String Ngaybd, String Ngaykt)
    {
        ThongTinSDDAO ttsdDAO=new ThongTinSDDAO();
        ArrayList<ThongTinSD> kq= new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ngaybd = LocalDateTime.parse(Ngaybd, formatter);
        LocalDateTime ngaykt = LocalDateTime.parse(Ngaykt, formatter);
        
        for(ThongTinSD ttsd: ttsdDAO.getData())
        {
            if(ttsd.getTgMuon()!=null)
            {
                LocalDateTime tgMuon = LocalDateTime.parse(ttsd.getTgMuon(), formatter);
                if (ngaybd.compareTo(tgMuon) <= 0 && tgMuon.compareTo(ngaykt) <= 0)
                {
                    kq.add(ttsd);
                }
            }
        }
        return kq;
    }
    public ArrayList<ThongTinSD>ThongKeByStartDate(String Ngaybd)
    {
        ThongTinSDDAO ttsdDAO=new ThongTinSDDAO();
        ArrayList<ThongTinSD> kq= new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ngaybd = LocalDateTime.parse(Ngaybd, formatter);
        for(ThongTinSD ttsd: ttsdDAO.getData())
        {
            if(ttsd.getTgMuon()!=null)
            {
                LocalDateTime tgMuon = LocalDateTime.parse(ttsd.getTgMuon(), formatter);
                if (ngaybd.compareTo(tgMuon) <= 0)
                {
                    kq.add(ttsd);
                }
            }
        }
        return kq;
    }
    public ArrayList<ThongTinSD>ThongKeByEndDate(String Ngaykt)
    {
        ThongTinSDDAO ttsdDAO=new ThongTinSDDAO();
        ArrayList<ThongTinSD> kq= new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ngaykt = LocalDateTime.parse(Ngaykt, formatter);

        for(ThongTinSD ttsd: ttsdDAO.getData())
        {
            if(ttsd.getTgMuon()!=null)
            {
                LocalDateTime tgMuon = LocalDateTime.parse(ttsd.getTgMuon(), formatter);
                if (ngaykt.compareTo(tgMuon) > 0)
                {
                    kq.add(ttsd);
                }
            }
        }
        return kq;
    }

    public ArrayList<ThongTinSD> ThongKeByName(String tenTB)
    {
        ThongTinSDDAO ttsdDAO=new ThongTinSDDAO();
        ArrayList<ThongTinSD> kq= new ArrayList<>();

        for(ThongTinSD ttsd: ttsdDAO.getData())
        {
            if(ttsd.getTgMuon()!=null)
            {
                dao=new ThietBiDAO();
                if(dao.geThietBiByID(ttsd.getMaTB()).getTenTB().contains(tenTB))
                    kq.add(ttsd);
            }
        }
        return kq;
    }
    public ArrayList<ThongTinSD> ThongKeDangMuonTheoTG(String Ngaybd, String Ngaykt)
    {
        ThongTinSDDAO ttsdDAO=new ThongTinSDDAO();
        ArrayList<ThongTinSD> kq= new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ngaybd = LocalDateTime.parse(Ngaybd, formatter);
        LocalDateTime ngaykt = LocalDateTime.parse(Ngaykt, formatter);

        for(ThongTinSD ttsd: ttsdDAO.getData())
        {
            if(ttsd.getTgMuon()!=null && ttsd.getTgTra()==null)
            {
                LocalDateTime tgMuon = LocalDateTime.parse(ttsd.getTgMuon(), formatter);
                if (ngaybd.compareTo(tgMuon) <= 0 && tgMuon.compareTo(ngaykt) <= 0)
                {
                    kq.add(ttsd);
                }
            }
        }
        return kq;
    }
    public ArrayList<ThongTinSD> ThongKeDangMuon()
    {
        ThongTinSDDAO ttsdDAO=new ThongTinSDDAO();
        ArrayList<ThongTinSD> kq= new ArrayList<>();
        for(ThongTinSD ttsd: ttsdDAO.getData())
        {
            if(ttsd.getTgMuon()!=null &&ttsd.getTgTra()==null)
            {
                kq.add(ttsd);
            }
        }
        return kq;
    }

}
