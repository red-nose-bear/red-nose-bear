import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import utils.BarCodeUtil;

import java.io.FileOutputStream;
import java.io.IOException;

public class GenPdf {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String fileName = "e:/6.pdf";
        GenPdf.test(fileName);
    }

    private static void test(String fileName) throws Exception {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.setPageSize(PageSize.A4);
        // step 3
        document.open();

        handle(document);

        // step 5
        document.close();
    }

    private static void handle(com.itextpdf.text.Document document) throws Exception{
        /**
         * 查看是否有相应的文件 有则直接发邮件，无则走以下几步
         * 1. 获取二维码
         * 2. 生成pdf（文件名唯一 单号+pin）
         */


        /**
         * 条形码部分
         */
        PdfPTable barcodeTable = new PdfPTable(1);
        PdfPCell barcodeCell = new PdfPCell();
        barcodeCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        Image barcodeImage = Image.getInstance(BarCodeUtil.genBarCodeJpg("JDX0010000000"));
        // 居中显示
        barcodeImage.setAlignment(1);
        // 显示为原条形码图片大小的比例，百分比
        barcodeImage.scalePercent(50);
        barcodeCell.addElement(barcodeImage);
        barcodeCell.setBorder(0);
        barcodeTable.addCell(barcodeCell);
        document.add(barcodeTable);

        /**
         * 用户信息部分
         */
        PdfPTable userInfoTab = new PdfPTable(16);
        // 寄件人信息
        PdfPCell sendcell = new PdfPCell();
        Paragraph sendP = getUserParagraph("寄件人");
        sendcell.addElement(sendP);
        sendcell.setColspan(2);
//        sendImgCell.setBorder(0);
        userInfoTab.addCell(sendcell);

        PdfPCell sendUserCell = new PdfPCell();
        Paragraph sendUserP = getUserParagraph("张三   137****9999");
        Paragraph sendAddress = getNormalParagraph("北京大兴通知泰和是搜索是是北京大兴通知泰和是搜索是是北京大兴通知泰和是搜索是是");
        sendUserCell.addElement(sendUserP);
        sendUserCell.addElement(sendAddress);
        sendUserCell.setColspan(14);
//        sendUserCell.setUseAscender(true);
//        sendUserCell.setVerticalAlignment(PdfPHeaderCell.ALIGN_CENTER);
//        sendUserCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        sendUserCell.setBorder(0);
        userInfoTab.addCell(sendUserCell);

//        PdfPCell emptyCell = new PdfPCell();
//        emptyCell.setBorder(0);
//        userInfoTab.addCell(emptyCell);

        // 寄件人地址
//        PdfPCell sendAddressCell = new PdfPCell();
//        Paragraph sendAddress = getNormalParagraph("寄件地址: 北京大兴通知泰和是搜索是是北京大兴通知泰和是搜索是是北京大兴通知泰和是搜索是是");
//        sendAddressCell.addElement(sendAddress);
//        sendAddressCell.setColspan(15);
//        sendAddressCell.setUseAscender(true);
//        sendAddressCell.setVerticalAlignment(PdfPHeaderCell.ALIGN_CENTER);
//        sendAddressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////        sendAddressCell.setBorder(0);
//        userInfoTab.addCell(sendAddressCell);

        PdfPCell receiveCell = new PdfPCell();
        Paragraph receiveP = getUserParagraph("收件人");
        receiveCell.addElement(receiveP);
        receiveCell.setColspan(2);
//        receiveImgCell.setBorder(0);
        userInfoTab.addCell(receiveCell);

        // 收件人信息
        PdfPCell receiveUserCell = new PdfPCell();
        Paragraph receiveUserP = getUserParagraph("例四   188****6666");
        Paragraph receiveAddress = getNormalParagraph("北京大兴通知泰和是搜索是是");
        receiveUserCell.addElement(receiveUserP);
        receiveUserCell.addElement(receiveAddress);
        receiveUserCell.setColspan(14);
//        receiveUserCell.setUseAscender(true);
//        receiveUserCell.setVerticalAlignment(PdfPHeaderCell.ALIGN_CENTER);
//        receiveUserCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        receiveUserCell.setBorder(0);
        userInfoTab.addCell(receiveUserCell);

//        userInfoTab.addCell(emptyCell);

        // 收件人地址
//        PdfPCell receiveAddressCell = new PdfPCell();
//        Paragraph receiveAddress = getNormalParagraph("收件地址: 北京大兴通知泰和是搜索是是");
//        receiveAddressCell.addElement(receiveAddress);
//        receiveAddressCell.setColspan(15);
//        receiveAddressCell.setUseAscender(true);
//        receiveAddressCell.setVerticalAlignment(PdfPHeaderCell.ALIGN_CENTER);
//        receiveAddressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
////        receiveAddressCell.setBorder(0);
//        userInfoTab.addCell(receiveAddressCell);

        document.add(userInfoTab);

        /**
         * 订单部分
         */
        PdfPTable orderInfoTab = new PdfPTable(4);
        PdfPCell cell1 = new PdfPCell();
        Paragraph cell1P = getNormalParagraph("托寄物品:");
        cell1.addElement(cell1P);
        PdfPCell cell2 = new PdfPCell();
        Paragraph cell2P = getNormalParagraph("酒");
        cell2.addElement(cell2P);
        PdfPCell cell3 = new PdfPCell();
        Paragraph cell3P = getNormalParagraph("付款方式:");
        cell3.addElement(cell3P);
        PdfPCell cell4 = new PdfPCell();
        Paragraph cell4P = getNormalParagraph("寄付现结");
        cell4.addElement(cell4P);

        PdfPCell cell5 = new PdfPCell();
        Paragraph cell5P = getNormalParagraph("产品类型:");
        cell5.addElement(cell5P);
        PdfPCell cell6 = new PdfPCell();
        Paragraph cell6P = getNormalParagraph("特岁送");
        cell6.addElement(cell6P);
        PdfPCell cell7 = new PdfPCell();
        Paragraph cell7P = getNormalParagraph("件数:");
        cell7.addElement(cell7P);
        PdfPCell cell8 = new PdfPCell();
        Paragraph cell8P = getNormalParagraph("1.0");
        cell8.addElement(cell8P);

        PdfPCell cell9 = new PdfPCell();
        Paragraph cell9P = getNormalParagraph("实际重量:");
        cell9.addElement(cell9P);
        PdfPCell cell10 = new PdfPCell();
        Paragraph cell10P = getNormalParagraph("11.5");
        cell10.addElement(cell10P);
        PdfPCell cell11 = new PdfPCell();
        Paragraph cell11P = getNormalParagraph("运费:");
        cell11.addElement(cell11P);
        PdfPCell cell12 = new PdfPCell();
        Paragraph cell12P = getNormalParagraph("￥12.0");
        cell12.addElement(cell12P);

        PdfPCell cell13 = new PdfPCell();
        Paragraph cell13P = getNormalParagraph("计费重量:");
        cell13.addElement(cell13P);
        PdfPCell cell14 = new PdfPCell();
        Paragraph cell14P = getNormalParagraph("55");
        cell14.addElement(cell14P);
        PdfPCell cell15 = new PdfPCell();
        Paragraph cell15P = new Paragraph();
        cell15.addElement(cell15P);
        cell15.setColspan(2);

        PdfPCell cell16 = new PdfPCell();
        Paragraph cell16P = new Paragraph();
        cell16.addElement(cell16P);
        cell16.setColspan(4);

        PdfPCell cell17 = new PdfPCell();
        Paragraph cell17P = getNormalParagraph("优惠金额(CNY):");
        cell17.addElement(cell17P);
        cell17.setColspan(2);
        PdfPCell cell18 = new PdfPCell();
        Paragraph cell18P = getNormalParagraph("￥78");
        cell18.addElement(cell18P);
        cell18.setColspan(2);

        PdfPCell cell19 = new PdfPCell();
        Paragraph cell19P = getNormalParagraph("个性化包装服务(CNY):");
        cell19.addElement(cell19P);
        cell19.setColspan(2);
        PdfPCell cell20 = new PdfPCell();
        Paragraph cell20P = getNormalParagraph("￥78");
        cell20.addElement(cell20P);
        cell20.setColspan(2);

        PdfPCell cell21 = new PdfPCell();
        Paragraph cell21P = getNormalParagraph("费用合计(CNY):");
        cell21.addElement(cell21P);
        cell21.setColspan(2);
        PdfPCell cell22 = new PdfPCell();
        Paragraph cell22P = getNormalParagraph("￥88:");
        cell22.addElement(cell22P);
        cell22.setColspan(2);

        orderInfoTab.addCell(cell1);
        orderInfoTab.addCell(cell2);
        orderInfoTab.addCell(cell3);
        orderInfoTab.addCell(cell4);
        orderInfoTab.addCell(cell5);
        orderInfoTab.addCell(cell6);
        orderInfoTab.addCell(cell7);
        orderInfoTab.addCell(cell8);
        orderInfoTab.addCell(cell9);
        orderInfoTab.addCell(cell10);
        orderInfoTab.addCell(cell11);
        orderInfoTab.addCell(cell12);
        orderInfoTab.addCell(cell13);
        orderInfoTab.addCell(cell14);
        orderInfoTab.addCell(cell15);
        orderInfoTab.addCell(cell16);
        orderInfoTab.addCell(cell17);
        orderInfoTab.addCell(cell18);
        orderInfoTab.addCell(cell19);
        orderInfoTab.addCell(cell20);
        orderInfoTab.addCell(cell21);
        orderInfoTab.addCell(cell22);

        document.add(orderInfoTab);
    }

    /**
     * 获取普通描述
     * @param content
     * @return
     */
    private static Paragraph getNormalParagraph(String content) throws IOException, DocumentException {
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font FontChinese = new Font(bfChinese, 9, Font.NORMAL);
        Paragraph paragraph = new Paragraph(content, FontChinese);
        paragraph.setAlignment(Element.ALIGN_LEFT);
        return paragraph;
    }

    /**
     * 获取用户类型描述
     */
    private static Paragraph getUserParagraph(String userInfo) throws IOException, DocumentException {
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
        Paragraph userP = new Paragraph(userInfo, FontChinese);
        userP.setAlignment(Element.ALIGN_LEFT);
        return userP;
    }



    /**
     * 两种字体显示文字
     *
     * @param cont
     * @param size
     * @param color
     * @return
     */
    private static Paragraph str2ParaByTwoFont(String cont, float size, BaseColor color) {
        Paragraph res = new Paragraph();
        FontSelector selector = new FontSelector();
        //非汉字字体颜色
        Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, size);
        f1.setColor(color);
        //汉字字体颜色
        Font f2 = FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED, size);
        f2.setColor(color);

        selector.addFont(f1);
        selector.addFont(f2);
        Phrase ph = selector.process(cont);
        res.add(ph);
        return res;
    }

    /**
     * 两种字体显示文字
     *
     * @param cont
     * @param size
     * @param color
     * @param bold
     * @return
     */
    private static Paragraph str2ParaByTwoFont(String cont, float size, BaseColor color, int bold) {

        Paragraph res = new Paragraph();
        FontSelector selector = new FontSelector();
        //非汉字字体颜色
        Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, size);
        f1.setColor(color);
        f1.setStyle(bold);
        //汉字字体颜色
        Font f2 = FontFactory.getFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED, size);
        f2.setColor(color);
        f2.setStyle(bold);

        selector.addFont(f1);
        selector.addFont(f2);
        Phrase ph = selector.process(cont);
        res.add(ph);
        return res;
    }

}
