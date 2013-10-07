package email;

import email.EmailUtil;

public class SendaEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmailUtil em = new EmailUtil("sllydel@gmail.com","ben.buckey@gmail.com","localhost");
		
		em.sendMail();
	}

}
