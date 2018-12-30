package CalabashBrothers;

class CalabashBrothersSort{
	public static void BubbleSort(Calabashbrother[] AllBrothers) {
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 6; j++) {
				if(AllBrothers[j + 1].Number < AllBrothers[j].Number) {
					Calabashbrother temp = AllBrothers[j];
					AllBrothers[j] = AllBrothers[j + 1];
					AllBrothers[j + 1] = temp;
				}
			}
		}
	}
}