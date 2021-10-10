
/*
 * @author: abhishek kumar
 * 
 * 
 * */
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Iterator;

public class LRU_Cache {

	// store keys of cache
	private Deque<Integer> doublyQueue;

	// store references of key in cache
	private HashSet<Integer> hashSet;

	// maximum capacity of cache
	private final int CACHE_SIZE;

	LRU_Cache(int capacity) {
		doublyQueue = new LinkedList<>();
		hashSet = new HashSet<>();
		CACHE_SIZE = capacity;
	}

	/* Refer the page within the LRU cache */
	public void lookup(int page) {
		if (!hashSet.contains(page)) {
			if (doublyQueue.size() == CACHE_SIZE) {
				int last = doublyQueue.removeLast();
				hashSet.remove(last);
			}
		} else {
			doublyQueue.remove(page);
		}
		doublyQueue.push(page);
		hashSet.add(page);
	}

	// display contents of cache
	public void print() {
		Iterator<Integer> itr = doublyQueue.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	public static void main(String[] args) {
		LRU_Cache cache = new LRU_Cache(5);
		cache.lookup(1);
		cache.lookup(2);
		cache.lookup(3);
		cache.lookup(1);
		cache.lookup(4);
		cache.lookup(5);
		cache.lookup(2);
		cache.lookup(2);
		cache.lookup(1);
		cache.print();
	}
}
