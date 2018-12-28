import java.util.List;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BattleField implements PropertyChangeListener {

    private Cell[][] field;
    private int row;
    private int col;

    BattleField(int row, int col) {
        this.row = row;
        this.col = col;
        field = new Cell[row][col];
        for (int i = 0; i < row; ++i)
            for (int j = 0; j < col; ++j)
                field[i][j] = new Cell(new Coordinate(i, j));
    }

    int size() {
        return row * col;
    }

    private Cell getCell(Coordinate coordinate) {
        return field[coordinate.getCoordinateX()][coordinate.getCoordinateY()];
    }

    private void add(Creature creature, Coordinate coordinate) {
        field[coordinate.getCoordinateX()][coordinate.getCoordinateY()].setCreature(creature);
    }

    void add(Camp camp) {
        camp.addPropertyChangeListener(this);
        add((Creature) camp.getLeader(), camp.getFormation().getLeader());
        for (int i = 0; i < camp.getFormation().getSoldier().length; ++i) {
            add((Creature) camp.getSoldier().get(i), camp.getFormation().getSoldier()[i]);
        }
        add(camp.getSupporter(), camp.getFormation().getSupporter());
    }

    void move(Creature creature, Coordinate coordinate) {
        field[creature.getCoordinate().getCoordinateX()][creature.getCoordinate().getCoordinateY()].remove();
        field[coordinate.getCoordinateX()][coordinate.getCoordinateY()].setCreature(creature);
    }

    private void remove(Coordinate coordinate) {
        field[coordinate.getCoordinateX()][coordinate.getCoordinateY()].remove();
    }

    private void remove(Coordinate[] coordinates) {
        for (Coordinate coordinate : coordinates)
            remove(coordinate);
    }

    void remove(Creature creature) {
        remove(creature.getCoordinate());
    }

    void remove(Camp camp) {
        remove(camp.getFormation().getLeader());
        remove(camp.getFormation().getSoldier());
        remove(camp.getFormation().getSupporter());
        camp.removePropertyChangeListener(this);
    }

    void clear() {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                field[i][j].remove();
            }
        }
    }

    private boolean isEmpty(int coordinateX, int coordinateY) {
        return field[coordinateX][coordinateY].isEmpty();
    }

    void display() {
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j)
                if (isEmpty(i, j))
                    System.out.print("null ");
                else
                    System.out.print(field[i][j].getName() + " ");
            System.out.println();
        }
        System.out.println();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void propertyChange(PropertyChangeEvent evt) {
        Camp camp = (Camp) evt.getSource();
        switch (evt.getPropertyName()) {
            case "formation":
                Formation oldFormation = (Formation) evt.getOldValue();
                Formation newFormation = (Formation) evt.getNewValue();
                remove(oldFormation.getLeader());
                remove(oldFormation.getSoldier());
                remove(oldFormation.getSupporter());
                add((Creature) camp.getLeader(), newFormation.getLeader());
                for (int i = 0; i < camp.getFormation().getSoldier().length; ++i) {
                    add((Creature) camp.getSoldier().get(i), newFormation.getSoldier()[i]);
                }
                add(camp.getSupporter(), newFormation.getSupporter());
                break;

            case "leader":
                Creature oldLeader = (Creature) evt.getOldValue();
                Creature newLeader = (Creature) evt.getNewValue();
                remove(oldLeader.getCoordinate());
                add(newLeader, camp.getFormation().getLeader());
                break;

            case "soldier":
                List<Creature> oldSoldierList = (List<Creature>)evt.getOldValue();
                List<Creature> newSoldierList = (List<Creature>) evt.getNewValue();
                for(Creature soldier : oldSoldierList)
                    remove(soldier.getCoordinate());
                for (int i = 0; i < camp.getFormation().getSoldier().length; ++i) {
                    add(newSoldierList.get(i), camp.getFormation().getSoldier()[i]);
                }
                break;

            case "supporter":
                Creature oldSupporter = (Creature) evt.getOldValue();
                Creature newSupporter = (Creature) evt.getNewValue();
                remove(oldSupporter.getCoordinate());
                add(newSupporter, camp.getFormation().getSupporter());
                break;
        }
    }
}
