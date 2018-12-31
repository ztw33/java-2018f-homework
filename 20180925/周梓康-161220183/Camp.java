import java.util.List;
import java.util.Collections;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

abstract class Camp<T> {

    CampProperty<T> property;
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    Camp(T leader, List<T> soldier, NonCalabashBrother supporter, Formation formation) {
        this.property = new CampProperty<>(leader, soldier, supporter, formation);
    }

    T getLeader() {
        return property.getLeader();
    }

    List<T> getSoldier() {
        return property.getSoldier();
    }

    NonCalabashBrother getSupporter() {
        return property.getSupporter();
    }

    Formation getFormation() {
        return property.getFormation();
    }

    void setLeader(T leader) {
        support.firePropertyChange("leader", property.getLeader(), leader);
        property.setLeader(leader);
    }

    void setSoldier(List<T> soldier) {
        support.firePropertyChange("soldier", property.getSoldier(), soldier);
        property.setSoldier(soldier);
    }

    void setSupporter(NonCalabashBrother supporter) {
        support.firePropertyChange("supporter", property.getSupporter(), supporter);
        property.setSupporter(supporter);
    }

    void setFormation(Formation formation) {
        support.firePropertyChange("formation", property.getFormation(), formation);
        property.setFormation(formation);
    }

    void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}

class CalabashCamp extends Camp<CalabashBrother> {

    CalabashCamp(CalabashBrother leader, List<CalabashBrother> soldier, NonCalabashBrother supporter, Formation formation) {
        super(leader, soldier, supporter, formation);
    }

    void shuffle() {
        Collections.shuffle(property.getSoldier());
    }

    void numberOffByRank() {
        System.out.println(property.getLeader().getRank().toString());
        for (CalabashBrother brother : property.getSoldier()) {
            System.out.println(brother.getRank().toString());
        }
    }

    void numberOffByColor() {
        System.out.println(property.getLeader().getColor().toString());
        for (CalabashBrother brother : property.getSoldier()) {
            System.out.println(brother.getColor().toString());
        }
    }

    void sortByRank() {
        for (int i = 0; i < property.getSoldier().size() - 1; ++i)
            for (int j = 0; j < property.getSoldier().size() - 1 - i; ++j)
                if (property.getSoldier().get(j).getRank().ordinal() > property.getSoldier().get(j + 1).getRank().ordinal())
                    swapCalabash(j, j + 1);
    }

    void sortByColor() {
        for (int i = 1; i < property.getSoldier().size(); ++i) {
            int low = 0, high = i - 1, mid;
            while (low <= high) {
                mid = (low + high) / 2;
                if (property.getSoldier().get(mid).getColor().ordinal() >= property.getSoldier().get(i).getColor().ordinal())
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            for (int j = i; j > low; --j)
                swapCalabash(j - 1, j);
        }
    }

    private void swapCalabash(int index1, int index2) {
        CalabashBrother tmp = property.getSoldier().get(index1);
        property.getSoldier().set(index1, property.getSoldier().get(index2));
        property.getSoldier().set(index2, tmp);
        System.out.println(property.getSoldier().get(index2).getRank().toString() + ": " + index1 + "->" + index2);
        System.out.println(property.getSoldier().get(index1).getRank().toString() + ": " + index2 + "->" + index1);
    }
}

class NonCalabashCamp extends Camp<Creature> {
    NonCalabashCamp(Creature leader, List<Creature> soldier, NonCalabashBrother supporter, Formation formation) {
        super(leader, soldier, supporter, formation);
    }
}

class CampProperty<T> {

    private T leader;
    private List<T> soldier;
    private NonCalabashBrother supporter;
    private Formation formation;

    CampProperty(T leader, List<T> soldier, NonCalabashBrother supporter, Formation formation) {
        this.leader = leader;
        this.soldier = soldier;
        this.supporter = supporter;
        this.formation = formation;
    }

    T getLeader() {
        return leader;
    }

    List<T> getSoldier() {
        return soldier;
    }

    NonCalabashBrother getSupporter() {
        return supporter;
    }

    Formation getFormation() {
        return formation;
    }

    void setLeader(T leader) {
        this.leader = leader;
    }

    void setSoldier(List<T> soldier) {
        this.soldier = soldier;
    }

    void setSupporter(NonCalabashBrother supporter) {
        this.supporter = supporter;
    }

    void setFormation(Formation formation) {
        this.formation = formation;
    }
}