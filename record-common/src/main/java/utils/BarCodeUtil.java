package utils;

import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 条形码工具类
 */
public class BarCodeUtil {

    /**
     * 生成条形码
     * @param barCode
     * @return
     * @throws Exception
     */
    public static byte[] genBarCodeJpg(String barCode) throws Exception{
        Code128Bean bean = new Code128Bean();
        final int dpi = 250;
        //样式
        bean.setModuleWidth(0.21);
        bean.setBarHeight(7);
        bean.doQuietZone(false);
        bean.setQuietZone(2);

        //两边空白区
        bean.setFontName("Helvetica");
        bean.setFontSize(3);
        bean.setMsgPosition(HumanReadablePlacement.HRP_BOTTOM);

        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(out,
                    "image/png", dpi, BufferedImage.TYPE_BYTE_BINARY
                    , true, 0);

            bean.generateBarcode(canvas, barCode);
            canvas.finish();
            return out.toByteArray();

        } catch (Exception e) {
//            LOG.error(e.getMessage(), e);
            e.printStackTrace();
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
