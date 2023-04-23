
public class WordPair<T>{
	protected T word; 
	protected T wordMeanings;
	protected WordPair<T> next, prev;
	public WordPair() {
		next = null; prev = null;
	}
	public WordPair(T e1, T e2) {
		this(e1,e2,null,null);
	}
	public WordPair(T e1,T e2, WordPair<T> n, WordPair<T> p) {
		word = e1; wordMeanings = e2; next = n; prev = p;
	}
	@Override
	public String toString() {
		return word + ": " + wordMeanings;
	}
}