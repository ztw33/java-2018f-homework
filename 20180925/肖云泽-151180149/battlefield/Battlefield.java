package battlefield;

import creature.*;

public class Battlefield {
	public Unit[][] units;
	public Battlefield() {
		this.units = new Unit[15][15];
		for (int i=0; i<15; i++) {
			for (int j=0; j<15; j++) {
				units[i][j] = new Unit(new Creature(), new Position(i, j));
			}
		}
	}
	public Battlefield(int N){
		this.units = new Unit[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				units[i][j] = new Unit(new Creature(), new Position(i, j));
			}
		}
	}
	public void place(Queue q, Formation f) {
		if (q.queue.length > f.arr.array.length) {
			System.out.println("Too long Queue");
			return;
		}
		for (int i=0; i<q.queue.length; i++) {
			units[f.arr.array[i].y][f.arr.array[i].x].position = f.arr.array[i];
			units[f.arr.array[i].y][f.arr.array[i].x].creature = q.queue[i];
		}
		for (int i=q.queue.length; i<f.arr.array.length; i++) {
			units[f.arr.array[i].y][f.arr.array[i].x].position = f.arr.array[i];
			units[f.arr.array[i].y][f.arr.array[i].x].creature = new Minion();
		}
	}
	public void place(Creature c, Position p) {
		units[p.y][p.x].position = p;
		units[p.y][p.x].creature = c;
	}
	public void showBattlefield() {
		String chinese = "[\u4e00-\u9fa5]";
		for (int i=0; i<units.length; i++) {
			for (int j=0; j<units[0].length; j++) {
				System.out.print(units[i][j].creature.getName());
				int length = 0;
				for (int p=0; p<units[i][j].creature.getName().length(); p++) {
					String temp = units[i][j].creature.getName().substring(p, p + 1);
					if (temp.matches(chinese)) {
						length += 2;
					} else {
						length += 1;
					}
				}
				for (int p=0; p<10-length; p++) {
					System.out.print("\0");
				}
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	public void changeFormation(Queue q, Formation old, Formation target) {
		this.deleteFormation(q, old);
		System.out.print("Next formation:\n");
		this.place(q, target);
	}
	public void deleteFormation(Queue q, Formation f) {
		for (int i=0; i<q.queue.length; i++) {
			units[f.arr.array[i].y][f.arr.array[i].x].creature = new Creature();
		}
	}
}
