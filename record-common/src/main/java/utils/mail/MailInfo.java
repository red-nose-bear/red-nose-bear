package utils.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 邮件信息
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class MailInfo {

    /**
     * 收件人
     */
    private String to;

    /**
     * 收件列表
     */
    private String[] bcc;

    /**
     * 主题
     */
    private String subject;

    /**
     * 是否为html格式邮件
     */
    private boolean html;

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 附件路径(文件系统路径)
     */
    private String attachmentFilePath;

    /**
     * 附件名称
     */
    private String attachmentFileName;

    /**
     * 发件人昵称
     */
    private String senderNickName;

}
