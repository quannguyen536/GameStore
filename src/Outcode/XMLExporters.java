package Outcode;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import models.Models_Khachhang;
import models.Models_Monan;
import models.Models_Nhanvien;

public class XMLExporters {

    public static void exportNhanVienListToXML(List<Models_Nhanvien> nhanVienList) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu trữ");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files (*.xml)", "xml");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".xml")) {
                filePath += ".xml"; // Đảm bảo rằng tệp có đuôi .xml
            }
            exportNhanVienListToXML(nhanVienList, filePath);
        }
    }

    private static void exportNhanVienListToXML(List<Models_Nhanvien> nhanVienList, String filePath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("nhanvienlist");
            doc.appendChild(rootElement);

            for (Models_Nhanvien nhanVien : nhanVienList) {
                Element nhanVienElement = doc.createElement("nhanvien");
                rootElement.appendChild(nhanVienElement);

                createElementWithValue(doc, nhanVienElement, "manv", String.valueOf(nhanVien.getManv()));
                createElementWithValue(doc, nhanVienElement, "tennv", nhanVien.getTennv());
                createElementWithValue(doc, nhanVienElement, "cccd", nhanVien.getCccd());
                createElementWithValue(doc, nhanVienElement, "gioitinh", nhanVien.getGioitinh());
                createElementWithValue(doc, nhanVienElement, "ngaysinh", formatDate(nhanVien.getNgaysinh()));
                createElementWithValue(doc, nhanVienElement, "sdt", nhanVien.getSdt());
                createElementWithValue(doc, nhanVienElement, "vaitro", nhanVien.getChucvu());
                createElementWithValue(doc, nhanVienElement, "luong", String.valueOf(nhanVien.getLuong()));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

            JOptionPane.showMessageDialog(null, "File đã được lưu thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi lưu file.");
        }
    }
    
    public static void exportPhoneListToXML(List<Models_Monan> foodList) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu trữ");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files (*.xml)", "xml");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".xml")) {
                filePath += ".xml"; 
            }
            exportPhoneListToXML(foodList, filePath);
        }
    }

    private static void exportPhoneListToXML(List<Models_Monan> foodList, String filePath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("phonelist");
            doc.appendChild(rootElement);

            for (Models_Monan food : foodList) {
                Element monanElement = doc.createElement("phone");
                rootElement.appendChild(monanElement);

                createElementWithValue(doc, monanElement, "id", String.valueOf(food.getId()));
                createElementWithValue(doc, monanElement, "tenmonan", food.getTenmonan());
                createElementWithValue(doc, monanElement, "gia", String.valueOf(food.getGia()));
                createElementWithValue(doc, monanElement, "loaimonan", food.getLoaimonan());
                createElementWithValue(doc, monanElement, "slTonKho", String.valueOf(food.getSltonkho()));
                createElementWithValue(doc, monanElement, "slDaBan", String.valueOf(food.getSldaban()));
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

            JOptionPane.showMessageDialog(null, "File đã được lưu thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi lưu file.");
        }
    }
    
    public static void exportKhachHangListToXML(List<Models_Khachhang> khachHangList) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu trữ");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML files (*.xml)", "xml");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".xml")) {
                filePath += ".xml"; 
            }
            exportKhachHangListToXML(khachHangList, filePath);
        }
    }

    private static void exportKhachHangListToXML(List<Models_Khachhang> khachHangList, String filePath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("khachhanglist");
            doc.appendChild(rootElement);

            for (Models_Khachhang khachHang : khachHangList) {
                Element khachHangElement = doc.createElement("khachhang");
                rootElement.appendChild(khachHangElement);

                createElementWithValue(doc, khachHangElement, "makh", String.valueOf(khachHang.getMakh()));
                createElementWithValue(doc, khachHangElement, "tenkh", khachHang.getTenkh());
                createElementWithValue(doc, khachHangElement, "sdt", khachHang.getSdt());
                createElementWithValue(doc, khachHangElement, "sotiennap", String.valueOf(khachHang.getTongchi()));
                createElementWithValue(doc, khachHangElement, "diemtichluy", String.valueOf(khachHang.getDiemtichluy()));
                createElementWithValue(doc, khachHangElement, "hang", khachHang.getHang());
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

            JOptionPane.showMessageDialog(null, "File đã được lưu thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi lưu file.");
        }
    }


    private static void createElementWithValue(Document doc, Element parentElement, String elementName, String value) {
        Element element = doc.createElement(elementName);
        element.appendChild(doc.createTextNode(value));
        parentElement.appendChild(element);
    }

    private static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }
	
}
