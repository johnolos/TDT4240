package pong.game;

import java.util.Observer;

public interface Subject {
	
	void register(Observer o);
	void Unregister(Observer o);
	void notifyObserver(int home, int away);

}
