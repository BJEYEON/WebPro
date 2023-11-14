package com.lec.ch17;

import java.util.Locale;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@Autowired
	private JavaMailSender mailSender; //메일보내는매소드
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "join";
	}
	@RequestMapping(value="textMail.do", method=RequestMethod.GET)
	public String textMail(String name, String email, Model model) { //join.jsp에서 받은 파라미터값 뷰단에 전달할 메세지 있으면model
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("[TEXT감사메일]" + name + "님 회원가입 감사합니다");
		String content = name + "님 회원가입 감사합니다\n <h1>태그 안먹음</h1>";
		message.setText(content);
		mailSender.send(message);
		model.addAttribute("mailSendResult", "TEXT메일리 발송되었습니다");
		return "sendResult"; //뷰단에 sendResult로
	}
	@RequestMapping(value="htmlMail.do", method=RequestMethod.GET)
	public String htmlMail(final String name, final String email, Model model) {
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content = "\"<div style=\\\"width:500px; margin: 0 auto;\\\">\\n\" + \n" + 
					"					\"	<h1>\"+name+\"님의 회원가입 감사합니다.</h1>\\n\" + \n" + 
					"					\"	<div>\\n\" + \n" + 
					"					\"		<p>아무개 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다</p>\\n\" + \n" + 
					"					\"       <img src=\\\"https://t1.daumcdn.net/daumtop_chanel/op/20170315064553027.png\\\" />\\n\" + \n" + 
					"					\"		<hr color=\\\"red\\\">\\n\" + \n" + 
					"					\"	</div>\\n\" + \n" + 
					"					\"	<div>\\n\" + \n" + 
					"					\"		<p style=\\\"color:red;\\\">빨간 글씨 부분</p>\\n\" + \n" + 
					"					\"		<p style=\\\"color:blue\\\">파란 글씨 부분</p>\\n\" + \n" + 
					"					\"		<img src=\\\"http://localhost:8093/ch17/resources/coupon.jpg\\\">\\n\" + \n" + 
					"					\"	</div>\\n\" + \n" + 
					"					\"	<p>서울시 어떤구 몰라17길 51 어떤빌딩 4층</p>\\n\" + \n" + 
					"					\"</div>\";\n" + 
					"";
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
				mimeMessage.setFrom(new InternetAddress("jaeyeon.park74@gmail.com"));
				mimeMessage.setSubject("[html 감사메일]" + name + "님 회원가입 감사합니다");
				mimeMessage.setText(content, "utf-8", "html"); //content가 위에있는 메일내용
				
			}
		};
		mailSender.send(message);
		model.addAttribute("mailSendResult", "html 메일발송완료");
		return "sendResult";
	}
}
