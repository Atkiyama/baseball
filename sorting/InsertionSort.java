package baseball.sorting;

import java.util.ArrayList;

import baseball.Order;
import baseball.player.Player;
/**
 * インサーションソートをArrayListで実装したメソッド
 * @author akiyama
 *
 */
public class InsertionSort extends Sort{

	@Override
	public void sort(ArrayList<Player> list, Order order) {
		// TODO 自動生成されたメソッド・スタブ
		int n = list.size();
		for (int k = 1; k < n; k++) {
			for (int j = k; j > 0; j--) {
				if (order.comparator( list.get(j), list.get(j-1) )>0 ) {
					//printArray(unitArray);
					swap(list, j, j - 1);
					//printArray(unitArray);
				}

				else {

					break;

				}
			}
		}



	}

}
