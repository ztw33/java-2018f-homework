import java.util.Random;

public class CalabashBrothersSorter {

	private CalabashBrothers[] Queue;

	CalabashBrothersSorter() {
		this.Queue = CalabashBrothers.values();
	}

	// operation on the queue
	public CalabashBrothers[] randomOrder() {
		Random rand = new Random();
		int[] QueueIndex = new int[Queue.length];
		// get an index code
		for (int i = 0; i < QueueIndex.length; i++) {
			QueueIndex[i] = rand.nextInt(QueueIndex.length - i);
		}
		// decode
		for (int i = 0; i < QueueIndex.length; i++) {
			int m = QueueIndex[i] + i;
			while (true) {
				int temp = 0;
				for (int j = 0; j < i; j++) {
					if (QueueIndex[j] < m) {
						temp += 1;
					}
				}
				if (QueueIndex[i] + temp == m) {
					break;
				}
				m--;
			}
			QueueIndex[i] = m;
		}
		System.out.println("Random order:");
		CalabashBrothers[] calabros = new CalabashBrothers[7];
		for (int i = 0; i < QueueIndex.length; i++) {
			calabros[i] = this.Queue[QueueIndex[i]];
		}
		this.Queue = calabros;
		this.checkQueue();
		return this.Queue;
	}

	public CalabashBrothers[] bubbleSort() {
		System.out.println("bubbleSort process:");
		for (int i = 0; i < this.Queue.length; i++) {
			for (int j = i + 1; j < this.Queue.length; j++) {
				if (this.Queue[i].index > this.Queue[j].index) {
					this.swapPosition(i, j);
				}
			}
		}
		System.out.println("");
		System.out.println("bubbleSort results:");
		for (int i = 0; i < this.Queue.length; i++) {
			this.Queue[i].tellNickname();
		}
		System.out.println("");
		return this.Queue;
	}
	
	public CalabashBrothers[] binaryInsertSort() {
		System.out.println("binaryInsertSort process:");
		for (int i = 0; i < this.Queue.length; i++) {
			int left = 0;
			int right = i - 1;
			int temp = this.Queue[i].index;
			while (left <= right) {
				int middle = (left + right) / 2;
				if (this.Queue[middle].index > temp) {
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			}
			for (int j = i-1; j>=left ; j--) {
				this.swapPosition(j, j + 1);
			}
		}
		System.out.println("");
		System.out.println("binarySort results:");
		this.checkQueue();
		return this.Queue;
	}
	
	public void checkQueue() {
		for (int i = 0; i < this.Queue.length; i++) {
			this.Queue[i].tellNickname();
		}
		System.out.println("");
	}
	
	public void swapPosition(int index1, int index2) {
		this.Queue[index1].tellNickname();
		CalabashBrothers calabro = this.Queue[index2];
		this.Queue[index2] = this.Queue[index1];
		this.Queue[index1] = calabro;
		System.out.printf(": %d->%d  ", index1, index2);
	}
	
	public static void main(String[] args) {
		CalabashBrothersSorter q = new CalabashBrothersSorter();
		q.randomOrder();
		q.bubbleSort();
		q.randomOrder();
		q.binaryInsertSort();
	}
}

