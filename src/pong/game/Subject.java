package pong.game;

public interface Subject {
	
	public void register(Observer o);
	public void Unregister(Observer o);
	public void notifyObserver();

}
