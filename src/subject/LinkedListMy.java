package subject;

/**
 * 双向循环链表
 * 
 * @author zy
 *
 */
public class LinkedListMy<T> {
	private Node<T> head;
	private int size;

	public static void main(String[] args) {

	}

	public void add(T data) {
		// 如果链表是空的，则创建头
		if (head == null) {
			head = new Node<T>(data);
			head.next = head;
			head.prev = head;
			size = 1;
		} else {
			Node<T> node = new Node<T>(data);
			Node prev = head.prev;
			prev.next = node;
			node.prev = prev;
			node.next = head;
			head.prev = node;
			size++;
		}
	}

	public void add(T data, int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("下标越界");
		}

	}
	

	public void delete(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("下标越界");
		}

		Node node = head;
		if (index == 0) {
			// 找到这个元素上一个元素
			Node prev = node.prev;
			// 找到这个元素下一个元素
			Node next = node.next;

			prev.next = next;
			next.prev = prev;
			size--;
			head = next;
			return;
		}
		if (index < size / 2) {
			System.out.println("+");
			// 从开头找
			for (int i = 0; i < index; i++) {
				node = node.next;
			}

		} else {
			System.out.println("-");
			// 从末尾找
			for (int i = 0; i < size - index; i++) {
				node = node.prev;
			}
		}

		// 找到这个元素上一个元素
		Node prev = node.prev;
		// 找到这个元素下一个元素
		Node next = node.next;

		prev.next = next;
		next.prev = prev;
		size--;
		node = null;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();

		// 无数据
		if (head == null) {
			return "[]";
		}
		builder.append("[");
		builder.append(head.data.toString());
		builder.append(",");
		Node node = head;
		while (node.next != head) {
			node = node.next;
			builder.append(node.data.toString());
			builder.append(",");
		}
		String str = builder.toString();
		str = str.substring(0, str.length() - 1);
		return str + "]";
	}

	class Node<T> {
		T data;
		Node next;
		Node prev;

		public Node(T data) {
			this.data = data;
		}
	}

	public int getSize() {
		return size;
	}

}
