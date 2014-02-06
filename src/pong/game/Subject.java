package pong.game;

public interface Subject {
	
	void register(Observer o);
	void Unregister(Observer o);
	void notifyObserver();

}
