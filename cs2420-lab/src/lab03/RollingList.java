package lab03;

public interface RollingList <T>  {
	public T getElement(int i);
	
	public void setElement(int i, T value);
	
	public void append(T value);
	
	public void prepend(T value);

	public T removeLast();
	
	public T removeFirst();

	public int size();
}
