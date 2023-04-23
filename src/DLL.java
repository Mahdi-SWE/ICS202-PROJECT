
public class DLL<T> {

	protected WordPair<T> head, tail;
	public DLL() {
		head = tail = null;
	}
	public boolean isEmpty() {
		return head == null;
	}
	public void addToHead(T e1, T e2) {
		if (head == null) {
			head = tail = new WordPair<T>(e1,e2);
		}
		else if(head == tail) {
			head = new WordPair<T>(e1,e2,head,null);
			head.next = tail;
			tail.prev = head;
		}
		else {
			head = new WordPair<T>(e1,e2,head,null);
			head.next.prev = head;
		}
	}
	public void addToTail(T e1, T e2) {
		if (tail == null) {
			head = tail = new WordPair<T>(e1,e2);
		}
		else if(head == tail) {
			tail = new WordPair<T>(e1,e2,null,tail);
			tail.prev = head;
			head.next = tail;
		}
		else{
			tail = new WordPair<T>(e1,e2,null,tail);
			tail.prev.next = tail;
		}

	}
	public void deleteFromHead() {
		if (isEmpty()){
		}
		else if (head == tail)
			head = tail = null;
		else {              
			head = head.next;
			head.prev = null;
		}
	}
	public void deleteFromTail() { 
		if (isEmpty()){
		}
		else if (head == tail)   
			head = tail = null;
		else {              
			tail = tail.prev;
			tail.next = null;
		}
	}


	@Override
	public String toString() {
		if(head == null) {
			return "[ ]";
		}
		String str = "";
		WordPair<T> tmp = head;
		while(tmp != null){
			str += tmp.word + ": " + tmp.wordMeanings + "\n";
			tmp = tmp.next;
		}
		return str;
	}

	public boolean contains(T el) {
		if(head == null) {
			return false;
		}
		WordPair<T> tmp = head;
		while(tmp != null){
			if(tmp.word.equals(el)) {
				return true;				
			}
			tmp = tmp.next;
		}
		return false;
	}

	public int size(){
		if(head == null) {
			return 0;
		}
		int count = 0;
		WordPair<T> p = head;
		while(p != null) {
			count++;
			p = p.next;
		}
		return count;
	}
}