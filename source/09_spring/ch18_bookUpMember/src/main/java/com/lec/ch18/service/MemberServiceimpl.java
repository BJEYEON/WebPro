package com.lec.ch18.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch18.repository.MemberRepository;
import com.lec.ch18.vo.Member;
@Service
public class MemberServiceimpl implements MemberService {
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private JavaMailSender mailSender;
	@Override
	public int idConfirm(String mid) {
		return memberRepository.idConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession httpSession) {
		int result = memberRepository.joinMember(member);//db저장
		if(result == 1) { //db에 회원가입 성공시에만 세션에 넣고 데이터 메일보냄
			httpSession.setAttribute("mid", member.getMid());
			// 메일전송
			MimeMessagePreparator message = new MimeMessagePreparator() {
				String  content = "<div style=\"width:500px; margin: 0 auto;\">\n" + 
						"	<h1>"+ member.getMname() +"님의 회원가입 감사합니다.</h1>\n" + 
						"	<div>\n" + 
						"		<p>아무개 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다</p>\n" + 
						"       <img src=\"https://t1.daumcdn.net/daumtop_chanel/op/20170315064553027.png\" />\n" + 
						"		<hr color=\"red\">\n" + 
						"	</div>\n" + 
						"	<div>\n" + 
						"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
						"		<p style=\"color:blue\">파란 글씨 부분</p>\n" + 
						"		<img src=\"http://localhost:8093/ch18/img/coupon.jpg\">\n" + 
						"	</div>\n" + 
						"	<p>서울시 어떤구 몰라17길 51 어떤빌딩 4층</p>\n" + 
						"</div>";
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					//받을메일
					mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMmail()));
					//보낼메일
					mimeMessage.setFrom(new InternetAddress("jaeyeon.park74#gmail.com"));
					// 메일 제목
					mimeMessage.setSubject(member.getMname() + "님 회원가입 감사합니다");
					// 메일 본문
					mimeMessage.setText(content, "utf-8", "html");
				}
			}; // message객체
			mailSender.send(message);
		}
		return result;
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String result="로그인성공";
		Member member = memberRepository.getDetailMember(mid); //db에서 가져온id정보
		if(member == null || !member.getMpw().equals(mpw)) { //입력한 아이디가null인지? 입력한 비번과 db에 비번이 맞는지?
			result = "아이디 혹은 비밀번호를 입력하세요";
		}else {
			httpSession.setAttribute("member", member);
		}
		return result;
	}

	@Override
	public Member getDetailMember(String mid) {
		return memberRepository.getDetailMember(mid);
	}

	@Override
	public int modifyMember(Member member, HttpSession httpSession) {
		httpSession.setAttribute("member", member);
		return memberRepository.modifyMember(member);
	}

}
