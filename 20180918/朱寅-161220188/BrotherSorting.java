public class BrotherSorting {

    private static final int broNum = 7;

    public static CalabashBrother[] bubbleSort(CalabashBrother[] calabashBrothers) {
        for(int round = 0; round < broNum; round ++) {
            for(int bubble = broNum - 1; bubble > round; bubble --) {
                if(calabashBrothers[bubble].brotherRank < calabashBrothers[bubble - 1].brotherRank) {
                    calabashBrothers[bubble].reportSwitch(bubble, bubble - 1);
                    CalabashBrother temp = calabashBrothers[bubble];
                    calabashBrothers[bubble] = calabashBrothers[bubble - 1];
                    calabashBrothers[bubble - 1] = temp;
                }

            }
        }
        return calabashBrothers;
    }

    public static CalabashBrother[] dichotomySort(CalabashBrother[] calabashBrothers) {
        for(int round = 1; round < broNum; round ++) {
            CalabashBrother temp = calabashBrothers[round];
            int left = 0, right = round - 1, mid;
            while(left <= right) {
                mid = (left + right) / 2;
                if(calabashBrothers[mid].brotherRank > temp.brotherRank) {
                    right = mid - 1;
                } else if (calabashBrothers[mid].brotherRank < temp.brotherRank) {
                    left = mid + 1;
                }
            }

            for(int mov = round; mov > left; mov --) {
                calabashBrothers[mov - 1].reportSwitch(mov - 1, mov);
                calabashBrothers[mov] = calabashBrothers[mov - 1];
            }
            temp.reportSwitch(round, left);
            calabashBrothers[left] = temp;
        }

        return calabashBrothers;
    }

    public static void main(String[] args) {
        CalabashBrother[] calabashBrothers1 = { CalabashBrother.BLU, CalabashBrother.PPL, CalabashBrother.YLW,
                CalabashBrother.ORG, CalabashBrother.GRN, CalabashBrother.RED, CalabashBrother.CYN };

        calabashBrothers1 = bubbleSort(calabashBrothers1);
        for(CalabashBrother element: calabashBrothers1)
            System.out.println(element.brotherName);

        CalabashBrother[] calabashBrothers2 = { CalabashBrother.BLU, CalabashBrother.PPL, CalabashBrother.YLW,
                CalabashBrother.ORG, CalabashBrother.GRN, CalabashBrother.RED, CalabashBrother.CYN };

        calabashBrothers2 = dichotomySort(calabashBrothers2);
        for(CalabashBrother element: calabashBrothers2)
            System.out.println(element.brotherName);


    }
}
