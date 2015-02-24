package ksh;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionCounterListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("技记积己:"+event.getSession().getId());
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("技记辆丰");
	}
}
