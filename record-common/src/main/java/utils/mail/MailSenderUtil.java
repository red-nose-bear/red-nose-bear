package utils.mail;

import com.google.common.base.Preconditions;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 利用 SpringMail 发送邮件
 */
@NoArgsConstructor
@Data
@Slf4j
public class MailSenderUtil {

    private static final String SENDER_NICK_NAME = "JDWL";
    private static final String ENCODING_FORMAT = "UTF-8";
    private static final String DEFAULT_ATTACHMENT_NAME = "attachment";

    private JavaMailSenderImpl mailSender;

    /**
     * mail of sender
     */
    private String mailFrom;

    /**
     * send the email
     *
     * @param mailInfo
     * @throws Exception
     */
    public void sendMail(MailInfo mailInfo) throws Exception {

        checkParam(mailInfo);

        try {
            MimeMessage mailMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = null;
            if (StringUtils.isNotBlank(mailInfo.getAttachmentFilePath())) {
                /**
                 * 带附件时需要传入 multipart true，否则会抛异常 java.lang.IllegalStateException: Not in multipart mode
                 */
                messageHelper = new MimeMessageHelper(mailMessage, true, ENCODING_FORMAT);
            } else {
                messageHelper = new MimeMessageHelper(mailMessage, ENCODING_FORMAT);
            }


            String nick = javax.mail.internet.MimeUtility.encodeText(mailInfo.getSenderNickName() == null ? SENDER_NICK_NAME : mailInfo.getSenderNickName());
            messageHelper.setFrom(new InternetAddress(nick + "<" + this.getMailFrom() + ">"));

            if (!StringUtils.isBlank(mailInfo.getTo())) {
                messageHelper.setTo(mailInfo.getTo());
            }
            if (mailInfo.getBcc() != null && mailInfo.getBcc().length > 0) {
                messageHelper.setBcc(mailInfo.getBcc());
            }
            if (StringUtils.isBlank(mailInfo.getSubject())) {
                messageHelper.setSubject("No subject");
            } else {
                messageHelper.setSubject(mailInfo.getSubject());
            }

            // true 表示启动HTML格式的邮件
            messageHelper.setText(mailInfo.getContent(), mailInfo.isHtml());

            // 是否有附件
            if (StringUtils.isNotBlank(mailInfo.getAttachmentFilePath())) {
                FileSystemResource file = new FileSystemResource(mailInfo.getAttachmentFilePath());
                messageHelper.addAttachment(StringUtils.isNotBlank(mailInfo.getAttachmentFileName()) ? mailInfo.getAttachmentFileName() : DEFAULT_ATTACHMENT_NAME, file);
            }

            //发送邮件
            mailSender.send(mailMessage);
        } catch (Exception e) {
            log.error("MailSenderUtil.sendMail exception: " + e);
            throw new RuntimeException("MailSenderUtil.sendMail exception: " + e);
        }
    }

    private void checkParam(MailInfo mailInfo) {
        Preconditions.checkArgument(mailInfo != null, "mailInfo can not be null");
        Preconditions.checkArgument(!(StringUtils.isBlank(mailInfo.getTo()) && (mailInfo.getBcc() == null || mailInfo.getBcc().length == 0)), "send email can not be null");
    }

}
